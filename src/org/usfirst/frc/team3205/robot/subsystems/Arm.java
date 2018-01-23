package org.usfirst.frc.team3205.robot.subsystems;

import org.usfirst.frc.team3205.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Arm extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	SpeedController body; 
	SpeedController arm; 
	//TalonSRX lowerArm; 
//	WPI_TalonSRX lowerarm; 
	//TalonSRX upperArm; 
	Encoder bodyEncoder;
	
	DigitalInput up; 
	DigitalInput down; 

	public Arm(){
//		lowerarm = new WPI_TalonSRX(2); 
		bodyEncoder = new Encoder(RobotMap.BODY_ENCODER_PORT_ONE, RobotMap.BODY_ENCODER_PORT_TWO, false, Encoder.EncodingType.k4X);
		up = new DigitalInput(RobotMap.UP_SWITCH); 
		down = new DigitalInput(RobotMap.DOWN_SWITCH); 
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
}

