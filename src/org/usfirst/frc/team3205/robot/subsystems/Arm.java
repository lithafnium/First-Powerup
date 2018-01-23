package org.usfirst.frc.team3205.robot.subsystems;

import org.usfirst.frc.team3205.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

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
		body = new Talon(RobotMap.BODY_MOTOR); 
		bodyEncoder = new Encoder(RobotMap.BODY_ENCODER_PORT_ONE, RobotMap.BODY_ENCODER_PORT_TWO, false, Encoder.EncodingType.k4X);
		up = new DigitalInput(RobotMap.UP_SWITCH); 
		down = new DigitalInput(RobotMap.DOWN_SWITCH); 
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void raiseBody(){
    	body.set(0.8);
    }
    
    public void lowerBody(){
    	body.set(-0.8);
    }
    public void bodyStop(){
    	body.set(0.0);
    }
    
    public void raiseArm(){
    	
    }
    
    public void lowerArm(){
    	
    }
    
    public void armStop(){
    	
    }
    
    public boolean isUp(){
    	return up.get(); 
    }
    
    public boolean isDown(){
    	return down.get(); 
    }
    
    public double getBodyEncoder(){
    	return bodyEncoder.getDistance();
    }
    
    public void resetEncoder(){
    	bodyEncoder.reset();
    }
    public void updateSmartDashboard(){
    	SmartDashboard.putBoolean("Up:", isUp()); 
    	SmartDashboard.putBoolean("Down:", isDown()); 
    	
    	SmartDashboard.putNumber("Body Encoder:", getBodyEncoder()); 

    	
    	
    }
    
    
}

