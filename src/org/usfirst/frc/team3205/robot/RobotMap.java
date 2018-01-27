/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3205.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	// public static int rangefinderPort = 1;
	// public static int rangefinderModule = 1;
	
	
	// Drive train 
		public static final int FRONT_LEFT_DRIVETRAIN_MOTOR = 6; 
		public static final int BACK_LEFT_DRIVETRAIN_MOTOR = 9; 

		public static final int FRONT_RIGHT_DRIVETRAIN_MOTOR = 3; 
		public static final int BACK_RIGHT_DRIVETRAIN_MOTOR = 2; 
		
		public static final int LEFT_ENCODER_ONE = 0; 
		public static final int LEFT_ENCODER_TWO = 1; 
		
		public static final int RIGHT_ENCODER_ONE = 0; 
		public static final int RIGHT_ENCODER_TWO = 1; 
		
		
		
	// Arm
		public static final int BODY_MOTOR = 1; 
		public static final int ARM_MOTOR = 2; 
		
		public static final int BODY_ENCODER_PORT_ONE = 0; 
		public static final int BODY_ENCODER_PORT_TWO = 1; 
		
		public static final int UP_SWITCH = 0; 
		public static final int DOWN_SWITCH = 1; 

		
	// Claw 
		public static final int PNEUMATIC = 3; 
		public static boolean open = true; 
		
		
	// vision 
		public static boolean camOneStart = true; 
		public static boolean camTwoStart = true; 
		
	// Climber 
		public static final int CLIMBER = 0; 
		public static final double CLIMB_SPEED = 0.5; 
		
	// Auto 
		public static final double kP = 0.5; 
		public static final double kI = 0.3; 
		public static final double kD = 0.4; 
		
		public static final double TOLERANCE = 0.5; 
		public static final double ALIGN_STEADY_TIME = 100; 
		
		public static final double SPEED = 0.50; 
 
	
}
