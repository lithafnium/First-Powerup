package org.usfirst.frc.team3205.robot.subsystems;

import org.usfirst.frc.team3205.robot.RobotMap;
import org.usfirst.frc.team3205.robot.commands.drive;

import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveTrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private SpeedController frontLeft; 
	private SpeedController frontRight;
	private SpeedController backLeft; 
	private SpeedController backRight;
	public SpeedControllerGroup left; 
	public SpeedControllerGroup right; 
	
	public Encoder leftEncoder; 
	public Encoder rightEncoder; 

	public ADXRS450_Gyro gyroSensor; 

	public boolean backwards = true; 

//	RobotDrive robotDrive; 
	DifferentialDrive robotDrive; 

	public DriveTrain(){
		
		//Encoders
		leftEncoder = new Encoder(RobotMap.LEFT_ENCODER_ONE, RobotMap.LEFT_ENCODER_TWO, false, Encoder.EncodingType.k4X);
		rightEncoder = new Encoder(RobotMap.RIGHT_ENCODER_ONE, RobotMap.RIGHT_ENCODER_TWO, false, Encoder.EncodingType.k4X);
		rightEncoder.setReverseDirection(true);
		leftEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		rightEncoder.setPIDSourceType(PIDSourceType.kDisplacement);
		
		//Left drive wheels
		frontLeft = new Talon(RobotMap.FRONT_LEFT_DRIVETRAIN_MOTOR); 
		backLeft = new Talon(RobotMap.BACK_LEFT_DRIVETRAIN_MOTOR); 
		left = new SpeedControllerGroup(frontLeft, backLeft); 

		//Right drive wheels 
		frontRight = new Talon(RobotMap.FRONT_RIGHT_DRIVETRAIN_MOTOR); 
		backRight = new Talon(RobotMap.BACK_RIGHT_DRIVETRAIN_MOTOR);
		right = new SpeedControllerGroup(frontRight, backRight); 


		robotDrive = new DifferentialDrive(left, right); 
		robotDrive.setSafetyEnabled(false);
		
		gyroSensor = new ADXRS450_Gyro(); 
		gyroSensor.calibrate();
		gyroSensor.reset(); 


	}
	
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new drive()); 
	}
	public void driveNow(Joystick left, Joystick right){
		
		frontLeft.setInverted(backwards);
		backLeft.setInverted(backwards);
		frontRight.setInverted(backwards);
		backRight.setInverted(backwards);
		if(backwards) robotDrive.tankDrive(left.getY(), right.getY(), true); 
		else robotDrive.tankDrive(right.getY(),  left.getY(), true);
		
	}

	public void driveCertainAmounts(double left, double right){
		robotDrive.tankDrive(left, right); 
	}

	public void stop(){
		robotDrive.tankDrive(0.0,0.0);
	}

	public void driveSlow(){
		robotDrive.tankDrive(0.5, 0.5); 
	}
	
	public double getLeft(){
		return leftEncoder.getDistance(); 
	}
	
	public double getRight(){
		return rightEncoder.getDistance(); 
	}

	public void resetEncoders(){
		leftEncoder.reset(); 
		rightEncoder.reset(); 
	}

	public double getAngle(){
		return gyroSensor.getAngle();
	}
	
	public void resetGyro(){
		gyroSensor.reset(); 
	}
	
	public void setLeftMotors(double speed){
		left.set(speed);
	}
	
	public void setRightMotors(double speed){
		right.set(speed);
	}
	public void updateSmartDashboard(){
		//		SmartDashboard.putNumber("Ultrasonic sensor one", getDistanceOne()); 
		//		SmartDashboard.putNumber("Ultrasonic sensor two", getDistanceTwo()); 

		//SmartDashboard.putNumber("Drive Encoder One - Right Side", getEncoderOne());

		SmartDashboard.putBoolean("Backwards:" , backwards);  
    	SmartDashboard.putNumber("Drivetrain Encoder Left:", getLeft()); 
    	SmartDashboard.putNumber("Drivetrain Encoder Right:", getRight()); 
    	
    	SmartDashboard.putNumber("Angle:", getAngle()); 





	}
	//

}

