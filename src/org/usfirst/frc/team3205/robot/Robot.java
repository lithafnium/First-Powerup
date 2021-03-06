/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3205.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3205.robot.commands.autoDriveForward;
import org.usfirst.frc.team3205.robot.commands.autoPlacedLeftGroup;
import org.usfirst.frc.team3205.robot.commands.autoPlacedRightGroup;
import org.usfirst.frc.team3205.robot.commands.autoDriveForwardNoPID;
import org.usfirst.frc.team3205.robot.commands.encoderArmReset;
import org.usfirst.frc.team3205.robot.commands.encoderBodyReset;
import org.usfirst.frc.team3205.robot.commands.encoderDrivetrainReset;
import org.usfirst.frc.team3205.robot.commands.encoderGyroReset;
import org.usfirst.frc.team3205.robot.commands.placedLeft;
import org.usfirst.frc.team3205.robot.commands.placedRight;
import org.usfirst.frc.team3205.robot.subsystems.Arm;
import org.usfirst.frc.team3205.robot.subsystems.Body;
import org.usfirst.frc.team3205.robot.subsystems.Claw;
import org.usfirst.frc.team3205.robot.subsystems.Climber;
import org.usfirst.frc.team3205.robot.subsystems.DriveTrain;
import org.usfirst.frc.team3205.robot.subsystems.Vision;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	
	
	public static OI oi;

	public static DriveTrain driveTrain;
	public static Body body; 
	public static Arm arm; 
	public static Claw grabby; 
	public static Vision vision; 
	public static Climber climby; 

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		body = new Body(); 
		climby = new Climber(); 
		vision = new Vision(); 
		driveTrain = new DriveTrain(); 
		arm = new Arm(); 
		grabby = new Claw(); 
		oi = new OI();
		
		RobotMap.gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		// if the switch is on the left side of the field 
		
		m_chooser.addDefault("Default Auto", new autoDriveForward(RobotMap.DRIVE_SHORT));
		m_chooser.addObject("Auto Drive foward (rip)", new autoDriveForwardNoPID(RobotMap.placedLeft.DRIVE_FORWARD_FAR));
		
		m_chooser.addObject("Robot left", new placedLeft()); 
		m_chooser.addObject("Robot right", new placedRight());

		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		SmartDashboard.putData("Reset Gyro", new encoderGyroReset());
		SmartDashboard.putData("Reset Drivetrain", new encoderDrivetrainReset());
		SmartDashboard.putData("Reset Arm", new encoderArmReset());

		SmartDashboard.putData("Reset Body", new encoderBodyReset());
		
		

	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
		

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();
		
		
		// gets the game data
		if(RobotMap.gameData.charAt(0) == 'L'){
			System.out.println("LEFT"); 
			RobotMap.switchLeft = true; 
		} else {
			RobotMap.switchRight = true; System.out.println("RIGHT");
		} 
		Command leftGroup = new autoPlacedLeftGroup();
		Command rightGroup = new autoPlacedRightGroup(); 
		
		

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			System.out.println("START"); 
			m_autonomousCommand.start();
			if(RobotMap.robotPlacedLeft){
				leftGroup.start(); 
			} else rightGroup.start(); 
			
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		updateSmartDashboard(); 
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		updateSmartDashboard(); 
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
	
	public void updateSmartDashboard(){
		driveTrain.updateSmartDashboard();
		grabby.updateSmartDashboard();
		arm.updateSmartDashboard(); 
		body.updateSmartDashboard();
	}
}
