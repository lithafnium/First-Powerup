package org.usfirst.frc.team3205.robot.subsystems;

import org.usfirst.frc.team3205.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
//	SpeedController climberOne; 
	WPI_TalonSRX climberOne; 
	WPI_TalonSRX climberTwo; 
	
	Talon claw; 


	
	
	public Climber(){
		climberOne = new WPI_TalonSRX(RobotMap.CLIMBER_ONE);
		climberTwo = new WPI_TalonSRX(RobotMap.CLIMBER_TWO); 
		
		claw = new Talon(RobotMap.CLAW); 
		
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void climb(){
    	climberOne.set(ControlMode.PercentOutput,RobotMap.CLIMB_SPEED);
    	climberTwo.set(ControlMode.PercentOutput,RobotMap.CLIMB_SPEED);

    }
    
    public void stop(){
    	climberOne.set(ControlMode.PercentOutput,0.0);
    	climberTwo.set(ControlMode.PercentOutput,0.0);

    }
    
    public void expandClaw(){
    	claw.set(0.60); 
    }
    
    public void retractClaw(){
    	claw.set(-0.60);
    }
}

