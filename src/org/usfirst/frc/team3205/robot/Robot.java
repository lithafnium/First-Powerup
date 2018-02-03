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

import org.usfirst.frc.team3205.robot.commands.autoPlacedLeftGroup;
import org.usfirst.frc.team3205.robot.commands.autoPlacedRightGroup;
import org.usfirst.frc.team3205.robot.commands.autoDriveForwardNoPID;

import org.usfirst.frc.team3205.robot.commands.encoderDrivetrainReset;
import org.usfirst.frc.team3205.robot.commands.encoderGyroReset;
import org.usfirst.frc.team3205.robot.subsystems.Arm;
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
		climby = new Climber(); 
		vision = new Vision(); 
		driveTrain = new DriveTrain(); 
		arm = new Arm(); 
		grabby = new Claw(); 
		oi = new OI();
//		m_chooser.addDefault("Default Auto", new ExampleCommand());
		m_chooser.addObject("Auto Drive foward (rip)", new autoDriveForwardNoPID(RobotMap.placedLeft.DRIVE_FORWARD_FAR));
		m_chooser.addObject("Robot placed left", new autoPlacedLeftGroup()); 
		m_chooser.addObject("Robot placed right", new autoPlacedRightGroup()); 

		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);
		SmartDashboard.putData("Reset Gyro", new encoderGyroReset());
		SmartDashboard.putData("Reset Drivetrain", new encoderDrivetrainReset());
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
		RobotMap.gameData = DriverStation.getInstance().getGameSpecificMessage();
		
		// if the switch is on the left side of the field 
		if(RobotMap.gameData.charAt(0) == 'L'){
			RobotMap.switchLeft = true; 
		} else RobotMap.switchRight = true; 
		

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
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
	}
}
