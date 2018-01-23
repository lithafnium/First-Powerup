package org.usfirst.frc.team3205.robot.subsystems;

import org.usfirst.frc.team3205.robot.commands.readNetworkTables;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Vision extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public NetworkTable table; 
	
	public NetworkTableEntry areaTable; 
	public NetworkTableEntry centerXTable; 
	public NetworkTableEntry centerYTable; 
	public NetworkTableEntry widthTable; 
	public NetworkTableEntry heightTable; 

	public double[] area; 
	public double[] centerX; 
	public double[] centerY; 
	public double[] height; 
	public double[] width; 
	
	public Vision(){
		table = table.getSubTable("GRIP/myContoursReport");
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new readNetworkTables()); 
    }
}

