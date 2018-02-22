package org.usfirst.frc.team3205.robot.commands;

import org.usfirst.frc.team3205.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class autoRaiseBody extends Command {
	public double angle; 
	public double encoderCount; 
    public autoRaiseBody(double angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.body); 

    	this.angle = angle; 
    	encoderCount = Robot.body.getBodyEncoder();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.grabby.brakeOff(); 

    	Robot.body.raiseBody();
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.body.bodyIsUp()) Robot.body.bodyStop();
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.body.bodyIsUp() || Robot.body.getBodyEncoder() >= angle;
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
