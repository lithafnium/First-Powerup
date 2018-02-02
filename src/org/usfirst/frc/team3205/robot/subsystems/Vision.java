package org.usfirst.frc.team3205.robot.subsystems;

import org.usfirst.frc.team3205.robot.commands.readNetworkTables;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoSink;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.CameraServer;
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
	
	public UsbCamera cam0; 
	public UsbCamera cam1; 
	VideoSink server; 
	
	public boolean toggle = true; 
	
	public Vision(){
//		table = table.getSubTable("GRIP/myContoursReport");
		CameraServer cs = CameraServer.getInstance(); 
		
		cam0 = cs.startAutomaticCapture("cam0", 0); 
		cam1 = cs.startAutomaticCapture("cam1",  1); 
		
		cam0.setResolution(320, 240); 
		cam1.setResolution(320, 240); 
		
		cam0.setFPS(15); 
		cam1.setFPS(15);
		
		server = cs.getServer();
		server.setSource(cam0);
		
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
//    	setDefaultCommand(new readNetworkTables()); 
    }
    
    public void toggleCamera(){
    	if(toggle){
    		server.setSource(cam1);
    	}
    	else server.setSource(cam0);
    	
    	toggle = !toggle; 
    }
}

