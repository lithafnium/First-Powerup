package org.usfirst.frc.team3205.robot.subsystems;

import org.usfirst.frc.team3205.robot.RobotMap;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	SpeedController climberOne; 
	
	
	public Climber(){
		climberOne = new Talon(RobotMap.CLIMBER); 
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void climb(){
    	climberOne.set(RobotMap.CLIMB_SPEED);
    }
    
    public void stop(){
    	climberOne.set(0.0);
    }
}

