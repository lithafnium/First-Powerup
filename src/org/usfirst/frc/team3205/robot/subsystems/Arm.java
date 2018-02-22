package org.usfirst.frc.team3205.robot.subsystems;

import org.usfirst.frc.team3205.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Arm extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	
	WPI_TalonSRX arm; 

 
	
	
	DigitalInput armUp; 
	DigitalInput armDown; 

	public Arm(){
		arm = new WPI_TalonSRX(RobotMap.ARM_MOTOR); 
		
//		armUp = new DigitalInput(RobotMap.ARM_UP_SWITCH); 
//		armDown = new DigitalInput(RobotMap.ARM_DOWN_SWITCH); 

		
		
		arm.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 10);
		arm.getSensorCollection().setQuadraturePosition(0, 10); 
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public void moveArm(double distance){
    		arm.set(ControlMode.Position, distance);
    	
    }
    public void raiseArm(){
    	arm.set(ControlMode.PercentOutput, 0.5);

    	//arm.set(0.5); 	
    }
    
    public void lowerArm(){
    	arm.set(ControlMode.PercentOutput, -0.5);

    	//arm.set(-0.5);
    }
    
    public void armStop(){
    	arm.set(ControlMode.PercentOutput, 0.0);

//    	arm.set(0.0);

    }
    // BODY
    
    // ARM
    public boolean armFwd(){
    	return arm.getSensorCollection().isFwdLimitSwitchClosed();
    }
    
    public boolean armRev(){
    	return arm.getSensorCollection().isRevLimitSwitchClosed();
    }
    //ENCODERS
    
    public double getArmEncoder(){
    	return arm.getSensorCollection().getQuadraturePosition();
    }
    
    
    
    public void resetArmEncoder(){
    	arm.getSensorCollection().setQuadraturePosition(0, 10); 
    }
    public void updateSmartDashboard(){
    	
//    	
    	SmartDashboard.putBoolean("Arm Up:", armFwd()); 
    	SmartDashboard.putBoolean("Arm Down:", armRev()); 
    	
    	SmartDashboard.putNumber("Arm Encoder:", getArmEncoder()); 
    	
    	SmartDashboard.putBoolean("Can Arm move:", RobotMap.arm_move); 
    	SmartDashboard.putNumber("CLASS TESTING", RobotMap.startPos.armHigh); 
    	SmartDashboard.putNumber("CLASS TESTING", RobotMap.startPos.armLow); 


    	
    	
    }
    
    
}

