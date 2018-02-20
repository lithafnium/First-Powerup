package org.usfirst.frc.team3205.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3205.robot.Robot;
import org.usfirst.frc.team3205.robot.RobotMap;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;

/**
 *
 */
public class autoDriveForward extends Command {
	double pidOut; 
	double kP; 
	double kI; 
	double kD; 
	PIDController leftController; 
	PIDController rightController; 
	double distance; 
	
	
    public autoDriveForward(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain); 
    	this.distance = distance; 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	kP = RobotMap.AutoDistances.kP;
    	kI = RobotMap.AutoDistances.kI; 
    	kD = RobotMap.AutoDistances.kD; 
    	
    	Robot.driveTrain.resetEncoders();
    	 
    	
    	PIDOutput leftMotorOutput = new PIDOutput(){
			@Override
			public void pidWrite(double output) {
				// TODO Auto-generated method stub
				Robot.driveTrain.setLeftMotors(output);
	    		SmartDashboard.putNumber("Left Motor Output:", output); 

				
			}
    	}; 
    	PIDOutput rightMotorOutput = new PIDOutput(){
			@Override
			public void pidWrite(double output) {
				// TODO Auto-generated method stub
				Robot.driveTrain.setRightMotors(output);
	    		SmartDashboard.putNumber("Right Motor Output:", output); 

				
			}
    	}; 
    	leftController = new PIDController(kP, kI, kD, Robot.driveTrain.leftEncoder, leftMotorOutput); 
    	rightController = new PIDController(kP, kI, kD, Robot.driveTrain.rightEncoder, rightMotorOutput);
//    	leftController.setInputRange(-5000.0, 5000.0);
//    	rightController.setInputRange(-5000.0, 5000.0);
    	
    	leftController.setOutputRange(-RobotMap.SPEED, RobotMap.SPEED);
    	rightController.setOutputRange(-RobotMap.SPEED, RobotMap.SPEED);
    	
    	leftController.setAbsoluteTolerance(RobotMap.TOLERANCE);
    	rightController.setAbsoluteTolerance(RobotMap.TOLERANCE);
    	
    	leftController.setContinuous();
    	rightController.setContinuous();
    	
    	leftController.setSetpoint(distance);
    	rightController.setSetpoint(distance);
    	
    	leftController.enable();
    	rightController.enable();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	SmartDashboard.putData("Left Side:", leftController); 
    	SmartDashboard.putData("Right Side:", rightController); 
    	
    	SmartDashboard.putNumber("Right value:", Robot.driveTrain.getRight());
    	SmartDashboard.putNumber("Left value:", Robot.driveTrain.getLeft());


    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
        return leftController.onTarget() && rightController.onTarget();
    }

    // Called once after isFinished returns true
    protected void end() {
    	leftController.disable();
    	rightController.disable();
    	Robot.driveTrain.stop(); 
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	leftController.disable();
    	rightController.disable();
    	Robot.driveTrain.stop(); 
    }

	
}
