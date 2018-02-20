package org.usfirst.frc.team3205.robot.commands;

import org.usfirst.frc.team3205.robot.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class autoPlacedLeftGroup extends CommandGroup {

    public autoPlacedLeftGroup() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	
    	// if the robot is placed on the left side and the switch is on the left side 
    	System.out.println("asdf"); 
    	if(RobotMap.switchLeft){
    		System.out.println("SWITCH IS LEFT"); 
    		addSequential(new clawClose()); 
    		addSequential(new armRaise()); 
    	
    		addSequential(new autoDriveForwardNoPID(-2900));
    		// addSequential(new autoDriveForwardNoPID(RobotMabp.placedLeft.DRIVE_FORWARD); 
    		addSequential(new autoAlign(-90.0)); 
    		addSequential(new autoDriveForwardNoPID(-3700));

    		addSequential(new armRaise()); 
    		addSequential(new bodyRaise()); 



//    		addSequential(new autoRaiseBody(RobotMap.RAISE_ARM)); 
    		
//    		addSequential(new autoDriveForward(RobotMap.placedLeft.DRIVE_RIGHT)); 
    		addSequential(new clawOpen()); 

    		
    	}
    	//else{ // RobotMap.switchRight 
        	// if the robot is placed on the left side and the switch is on the right side 

//    		addSequential(new autoDriveForward(RobotMap.placedLeft.DRIVE_FORWARD_FAR));
//    		// addSequential(new autoDriveForwardNoPID(RobotMabp.placedLeft.DRIVE_FORWARD_FAR); 
//
//    		addSequential(new autoAlign(90.0)); 
//    		addSequential(new autoDriveForward(RobotMap.placedLeft.DRIVE_RIGHT_FAR)); 
//    		addSequential(new autoAlign(90.0)); 
//    		addSequential(new autoRaiseBody(RobotMap.RAISE_ARM)); 
//    		addSequential(new autoDriveForward(RobotMap.DRIVE_SHORT)); 
//    		addSequential(new clawOpen()); 
//
//
//    		addSequential(new clawOpen()); 
    		
    	//}
    }
}
