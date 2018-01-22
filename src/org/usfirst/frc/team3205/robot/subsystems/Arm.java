package org.usfirst.frc.team3205.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	SpeedController lowerArm; 
	SpeedController upperArm; 
	//TalonSRX lowerArm; 
//	WPI_TalonSRX lowerarm; 
	//TalonSRX upperArm; 
	DigitalInput up; 
	DigitalInput down; 

	public Arm(){
//		lowerarm = new WPI_TalonSRX(2); 
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
}

