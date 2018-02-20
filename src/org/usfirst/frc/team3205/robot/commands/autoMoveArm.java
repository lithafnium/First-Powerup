package org.usfirst.frc.team3205.robot.commands;

import org.usfirst.frc.team3205.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class autoMoveArm extends Command {
	double position; 
	double encoderCount; 
	boolean down; 
	boolean up; 
    public autoMoveArm(double position) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.arm); 
    	this.position = position;
    	encoderCount = Robot.arm.getArmEncoder();
    }
    
    

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(position < encoderCount){
    		down = true; 
    		Robot.arm.lowerArm();
    	} else {
    		up = true; 
    		Robot.arm.raiseArm(); 
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if((Robot.arm.armFwd() && up) ||( Robot.arm.armRev() && down)) Robot.arm.armStop();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Robot.arm.armFwd() && up )|| (Robot.arm.armRev() && down)|| (Math.abs(Robot.arm.getArmEncoder()) >= Math.abs(position));
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
