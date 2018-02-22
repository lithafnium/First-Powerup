package org.usfirst.frc.team3205.robot.subsystems;

import org.usfirst.frc.team3205.robot.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Body extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	SpeedController body1;
	SpeedController body2; 
	
	Encoder bodyEncoder;
	
	DigitalInput bodyUp; 
	DigitalInput bodyDown; 
	public Body(){
		body1 = new VictorSP(RobotMap.BODY_MOTOR_ONE); 
		body2 = new VictorSP(RobotMap.BODY_MOTOR_TWO); 

		bodyEncoder = new Encoder(RobotMap.BODY_ENCODER_PORT_ONE, RobotMap.BODY_ENCODER_PORT_TWO, false, Encoder.EncodingType.k4X);
		
		bodyUp = new DigitalInput(RobotMap.BODY_UP_SWITCH); 
		bodyDown = new DigitalInput(RobotMap.BODY_DOWN_SWITCH); 
		bodyEncoder.reset(); 

	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void raiseBody(){
    	body1.set(0.3);
    	body2.set(0.3);

    }
    
    public void lowerBody(){
    	body1.set(-0.3);
    	body2.set(-0.3);

    }
    public void bodyStop(){
    	body1.set(0.0);
    	body2.set(0.0);

    }
    
    public boolean bodyIsUp(){
    	return bodyUp.get(); 
    }
    
    public boolean bodyIsDown(){
    	return bodyDown.get(); 
    }
    
    public double getBodyEncoder(){
    	return bodyEncoder.getDistance();
    }
    
    public void resetBodyEncoder(){
    	bodyEncoder.reset();
    }
    
    public void updateSmartDashboard(){
    	SmartDashboard.putBoolean("Body Up:", bodyIsUp()); 
    	SmartDashboard.putBoolean("Body Down:", bodyIsDown()); 
    	SmartDashboard.putNumber("Body Encoder:", getBodyEncoder()); 

    }
}

