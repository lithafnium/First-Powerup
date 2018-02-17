package org.usfirst.frc.team3205.robot.commands;

import org.usfirst.frc.team3205.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class autoRaiseArm extends Command {
	double distance; 
	double encoderCount; 
    public autoRaiseArm(double distance) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.arm); 
    	this.distance = distance;
    	encoderCount = Robot.arm.getArmEncoder();
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.arm.moveArm(distance);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(Robot.arm.armFwd()) Robot.arm.armStop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.arm.armFwd() || Robot.arm.getArmEncoder() - encoderCount >= distance;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.arm.armStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.arm.armStop();

    }
}
