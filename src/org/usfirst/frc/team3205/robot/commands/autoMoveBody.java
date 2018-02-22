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
    	requires(Robot.body); 
    	this.position = position; 
    	encoderCount = Robot.body.getBodyEncoder();

    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.grabby.brakeOff(); 

    	if(position < encoderCount){
    		down = true; 
    		Robot.body.lowerBody();
    	} else{
    		Robot.body.raiseBody();
    		up = true; 
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if((Robot.body.bodyIsUp() && up)|| (Robot.body.bodyIsDown() && down)) Robot.body.bodyStop();

    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.body.bodyIsUp() && up) || (Robot.body.bodyIsDown() && down) || (Math.abs(Robot.body.getBodyEncoder()) >= Math.abs(position));
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.grabby.brakeOn(); 

    	Robot.body.bodyStop();

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.grabby.brakeOn(); 

    	Robot.body.bodyStop();

    }
}
