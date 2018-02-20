package org.usfirst.frc.team3205.robot.commands;

import org.usfirst.frc.team3205.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class autoMoveBody extends Command {
	double position; 
	double encoderCount; 
	boolean up; 
	boolean down; 
    public autoMoveBody(double position) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.arm); 
    	this.position = position; 
    	encoderCount = Robot.arm.getBodyEncoder();

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.grabby.brakeOff(); 

    	if(position < encoderCount){
    		down = true; 
    		Robot.arm.lowerBody();
    	} else{
    		Robot.arm.raiseBody();
    		up = true; 
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if((Robot.arm.bodyIsUp() && up)|| (Robot.arm.bodyIsDown() && down)) Robot.arm.bodyStop();

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.arm.bodyIsUp() && up) || (Robot.arm.bodyIsDown() && down) || (Math.abs(Robot.arm.getBodyEncoder()) >= Math.abs(position));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.grabby.brakeOn(); 

    	Robot.arm.bodyStop();

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.grabby.brakeOn(); 

    	Robot.arm.bodyStop();

    }
}
