package org.usfirst.frc.team3205.robot.subsystems;

import org.usfirst.frc.team3205.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
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
	WPI_TalonSRX arm; 
 
	Encoder bodyEncoder;
	
	DigitalInput up; 
	DigitalInput down; 

	public Arm(){
		arm = new WPI_TalonSRX(0); 
		body = new Talon(RobotMap.BODY_MOTOR); 
		bodyEncoder = new Encoder(RobotMap.BODY_ENCODER_PORT_ONE, RobotMap.BODY_ENCODER_PORT_TWO, false, Encoder.EncodingType.k4X);
		up = new DigitalInput(RobotMap.UP_SWITCH); 
		down = new DigitalInput(RobotMap.DOWN_SWITCH); 
		
		arm.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
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
    	arm.set(ControlMode.PercentOutput, 0.5);
    	
    }
    
    public void lowerArm(){
    	arm.set(ControlMode.PercentOutput, -0.5);
    	
    }
    
    public void armStop(){
    	arm.set(ControlMode.PercentOutput, 0.0);
    	
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
    
    public double getArmEncoder(){
    	return arm.getSensorCollection().getQuadraturePosition();
    }
    
    public void resetEncoder(){
    	bodyEncoder.reset();
    }
    public void updateSmartDashboard(){
    	SmartDashboard.putBoolean("Up:", isUp()); 
    	SmartDashboard.putBoolean("Down:", isDown()); 
    	
    	SmartDashboard.putNumber("Body Encoder:", getBodyEncoder()); 
    	SmartDashboard.putNumber("Arm Encoder:", getArmEncoder()); 

    	
    	
    }
    
    
}

