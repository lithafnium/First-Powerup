/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team3205.robot;

import org.usfirst.frc.team3205.robot.commands.cameraOneInit;
import org.usfirst.frc.team3205.robot.commands.cameraTwoInit;
import org.usfirst.frc.team3205.robot.commands.switchDirections;
import org.usfirst.frc.team3205.robot.commands.toggleClaw;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());

	public static Joystick right = new Joystick(0);
		Button r1 = new JoystickButton(right, 1);
		Button r2 = new JoystickButton(right, 2);
		Button r3 = new JoystickButton(right, 3);
		Button r4 = new JoystickButton(right, 4);
		Button r5 = new JoystickButton(right, 5);
		Button r6 = new JoystickButton(right, 6);
		Button r7 = new JoystickButton(right, 7);
		Button r8 = new JoystickButton(right, 8);
		Button r9 = new JoystickButton(right, 9);
		Button r10 = new JoystickButton(right, 10);
		Button r11 = new JoystickButton(right, 11);

	public static Joystick left = new Joystick(1);
		Button l1 = new JoystickButton(left, 1);
		Button l2 = new JoystickButton(left, 2);
		Button l3 = new JoystickButton(left, 3);
		Button l4 = new JoystickButton(left, 4);
		Button l5 = new JoystickButton(left, 5);
		Button l6 = new JoystickButton(left, 6);
		Button l7 = new JoystickButton(left, 7);
		Button l8 = new JoystickButton(left, 8);
		Button l9 = new JoystickButton(left, 9);
		Button l10 = new JoystickButton(left, 10);
		Button l11 = new JoystickButton(left, 11);
	public static Joystick controller = new Joystick(2);
		Button c1 = new JoystickButton(controller, 1);
		Button c2 = new JoystickButton(controller, 2);
		Button c3 = new JoystickButton(controller, 3);
		Button c4 = new JoystickButton(controller, 4);
		Button c5 = new JoystickButton(controller, 5);
		Button c6 = new JoystickButton(controller, 6);
		Button c7 = new JoystickButton(controller, 7);
		Button c8 = new JoystickButton(controller, 8);
		Button c9 = new JoystickButton(controller, 9);
		Button c10 = new JoystickButton(controller, 10);
		Button c11 = new JoystickButton(controller, 11);
		Button c12 = new JoystickButton(controller, 12);
	
	public OI(){
		r1.toggleWhenPressed(new switchDirections());
		c1.whenPressed(new toggleClaw()); 
		c11.toggleWhenPressed(new cameraOneInit());
		c12.toggleWhenPressed(new cameraTwoInit());

		

	}
	
	
	
}
