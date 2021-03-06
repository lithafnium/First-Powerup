package org.usfirst.frc.team3205.robot.commands;

import org.usfirst.frc.team3205.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class autoDriveForwardNoPID extends Command {
	public double distance; 
	public double encoderCount; 
	
    public autoDriveForwardNoPID(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain); 
    	this.distance = distance; 
    	encoderCount = (Robot.driveTrain.getLeft() + Robot.driveTrain.getRight())/2;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(distance < encoderCount){
    		Robot.driveTrain.driveCertainAmounts(0.612, 0.6);
    	}
    	else{
    		Robot.driveTrain.driveCertainAmounts(-0.612, -0.6);
    	}
   
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Math.abs((Robot.driveTrain.getLeft() + Robot.driveTrain.getRight())/2) >= Math.abs(distance);
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.stop(); 
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.driveTrain.stop(); 
    }
}
