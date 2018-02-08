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
		public static final int BODY_MOTOR_ONE = 1; 
		public static final int BODY_MOTOR_TWO = 1; 

		public static final int ARM_MOTOR = 2; 
		
		public static final int BODY_ENCODER_PORT_ONE = 0; 
		public static final int BODY_ENCODER_PORT_TWO = 1; 
		
		public static final int BODY_UP_SWITCH = 0; 
		public static final int BODY_DOWN_SWITCH = 1;
		public static final int ARM_UP_SWITCH = 0; 
		public static final int ARM_DOWN_SWITCH = 1; 
		
		

		
	// Claw 
		public static final int PNEUMATIC = 3; 
		public static boolean open = true; 
		
		
	// vision 
		public static boolean camOneStart = true; 
		public static boolean camTwoStart = true; 
		
	// Climber 
		public static final int CLIMBER = 0; 
		public static final double CLIMB_SPEED = 0.5; 
		
		public static final int CLIMBER_ONE = 0; 
		public static final int CLIMBER_TWO = 1; 
		
		public static final int CLAW = 0; 
		
		
	// Auto 
		public static final double kP = 0.5; 
		public static final double kI = 0.3; 
		public static final double kD = 0.4; 
		
		public static final double TOLERANCE = 0.5; 
		public static final double ALIGN_STEADY_TIME = 100; 
		
		public static final double SPEED = 0.50; 
		
		public static final double ANGLE = 90.0; 
		
		public static String gameData = ""; 
		
		public static double RAISE_ARM = 0.0; 
		public static double DRIVE_SHORT = 0.0; 
		public static boolean switchLeft = false; 
		public static boolean switchRight = false; 
		
		// left auto ditsances --> when we are placed on the left side
		public class placedLeft{
			public static final double DRIVE_FORWARD = 0.0;  // drive forward to the forward position
			public static final double DRIVE_FORWARD_FAR = 0.0;  // drive forward to the forward position
			
			public static final double DRIVE_RIGHT = 0.0; // if we are placed on the right side
			public static final double DRIVE_RIGHT_FAR = 0.0; // if we are placed on the right side

			

		}
		// right auto --> when we are placed on the right side
		public class placedRight{
			public static final double DRIVE_FORWARD = 0.0;  // drive forward to the forward position
			public static final double DRIVE_FORWARD_FAR = 0.0;  // drive forward to the forward position
			
			public static final double DRIVE_LEFT = 0.0; // if we are placed on the right side
			public static final double DRIVE_LEFT_FAR = 0.0; // if we are placed on the right side
		}
		
		
		public class AutoDistances{
			public static final double kP = 0.0; 
			public static final double kI = 0.0; 

			public static final double kD = 0.0; 

		}
 
	
}
