package org.usfirst.frc.team3205.robot.commands;

import org.usfirst.frc.team3205.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class readNetworkTables extends Command {

    public readNetworkTables() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.vision); 
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.vision.areaTable = Robot.vision.table.getEntry("area"); 
    	Robot.vision.centerXTable = Robot.vision.table.getEntry("centerX"); 
    	Robot.vision.centerYTable = Robot.vision.table.getEntry("centerY");
    	Robot.vision.widthTable = Robot.vision.table.getEntry("width");
    	Robot.vision.heightTable = Robot.vision.table.getEntry("height"); 
    	
    	Robot.vision.area = Robot.vision.areaTable.getDoubleArray(new double[1]); 
    	Robot.vision.centerX = Robot.vision.centerXTable.getDoubleArray(new double[1]); 
    	Robot.vision.centerY = Robot.vision.centerYTable.getDoubleArray(new double[1]); 
    	Robot.vision.width = Robot.vision.widthTable.getDoubleArray(new double[1]); 
    	Robot.vision.height = Robot.vision.heightTable.getDoubleArray(new double[1]); 








    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
