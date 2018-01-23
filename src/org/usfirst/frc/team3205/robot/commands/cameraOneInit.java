package org.usfirst.frc.team3205.robot.commands;

import org.usfirst.frc.team3205.robot.RobotMap;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.FlipAxis;
import com.ni.vision.NIVision.Image;

import edu.wpi.first.wpilibj.vision.CameraServer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class cameraOneInit extends Command {
	int cameraOne, cameraTwo; 
	Image frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0); 
	
	
    public cameraOneInit() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(RobotMap.camOneStart){
    		cameraOne = NIVision.IMAQdxOpenCamera("cam0",  NIVision.IMAQdxCameraControlMode.CameraControlModeController); 
    		NIVision.IMAQdxConfigureGrab(cameraOne);
    		RobotMap.camOneStart = false; 
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	NIVision.IMAQdxStartAcquisition(cameraOne);
    	NIVision.IMAQdxGrab(cameraOne, frame, 1); 
    	NIVision.imaqFlip(frame, frame, FlipAxis.HORIZONTAL_AXIS);
    	NIVision.imaqFlip(frame, frame, FlipAxis.VERTICAL_AXIS);
    	
    	CameraServer.getInstance().setImage(frame);; 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	NIVision.IMAQdxStopAcquisition(cameraOne);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	NIVision.IMAQdxStopAcquisition(cameraOne);
    }
}
