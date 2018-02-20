package org.usfirst.frc.team3205.robot.subsystems;

import org.usfirst.frc.team3205.robot.RobotMap;
import org.usfirst.frc.team3205.robot.commands.openSesame;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc.team3205.robot.commands.brakeOn;


/**
 *
 */
public class Claw extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DoubleSolenoid solenoid; 
	DoubleSolenoid brake; 
	
	public boolean brakeOn = true; 

	public Claw(){
		solenoid = new DoubleSolenoid(0, 1); 
		brake = new DoubleSolenoid(2,3); 
	}
	
	public void open(){
		solenoid.set(DoubleSolenoid.Value.kForward);
		RobotMap.open = true;
	}
	
	public void close(){
		solenoid.set(DoubleSolenoid.Value.kReverse);
		RobotMap.open = false;
	}
	
	public void brakeOff(){
		brake.set(DoubleSolenoid.Value.kForward);
	}
	
	public void brakeOn(){
		brake.set(DoubleSolenoid.Value.kReverse);

	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
//    	setDefaultCommand(new openSesame()); 
//    	setDefaultCommand(new brakeOn()); 
    }
    
    public void updateSmartDashboard(){
    	SmartDashboard.putBoolean("Open:", RobotMap.open); 
    }
}

