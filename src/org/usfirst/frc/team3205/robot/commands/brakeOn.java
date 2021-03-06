package org.usfirst.frc.team3205.robot.commands;

import org.usfirst.frc.team3205.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class brakeOn extends Command {

    public brakeOn() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.grabby); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.grabby.brakeOn(); 
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.grabby.brakeOn(); 

    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.grabby.brakeOn(); 

    }
}
