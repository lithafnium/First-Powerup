package org.usfirst.frc.team3205.robot.commands;

import org.usfirst.frc.team3205.robot.OI;
import org.usfirst.frc.team3205.robot.Robot;
import org.usfirst.frc.team3205.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class drive extends Command {

	public drive() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveTrain); 
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		RobotMap.arm_move = (Robot.body.getBodyEncoder() > 10 && Robot.body.getBodyEncoder() < 4200) ? false : true; 
//		if(Robot.arm.getBodyEncoder() > 10 && Robot.arm.getBodyEncoder() < 4200 ){
//			RobotMap.arm_move = false; 
//		}
//		else RobotMap.arm_move = true; 
		Robot.driveTrain.driveNow(OI.left, OI.right);
		//Robot.driveTrain.backwards(OI.right, OI.left); 
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
