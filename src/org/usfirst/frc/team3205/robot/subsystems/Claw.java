package org.usfirst.frc.team3205.robot.subsystems;

import org.usfirst.frc.team3205.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	DoubleSolenoid solenoid; 

	public Claw(){
		solenoid = new DoubleSolenoid(0, 1); 
	}
	
	public void open(){
		solenoid.set(DoubleSolenoid.Value.kForward);
		RobotMap.open = true;
	}
	
	public void close(){
		solenoid.set(DoubleSolenoid.Value.kReverse);
		RobotMap.open = false;
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

