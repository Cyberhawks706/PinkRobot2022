package frc.robot.subsystems;

import java.util.TimerTask;


import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Components;

import frc.robot.commands.Drive;


public class Chassis extends Subsystem {



	public void initDefaultCommand() {
		setDefaultCommand(new frc.robot.commands.Drive());
		
	}

	int valuesAdded = 0;
	double gyroTotal = 0;
	int totalValues = 10;
	
	public double extendOffset = 0;
    public double rotationOffset = 0;

	public void periodic() {

		Components.drive.execute();
	
		/* 
		if(valuesAdded < totalValues){
			//gyroTotal += (double) Components.ahrs.getYaw();
			valuesAdded++;
		}else{
			valuesAdded = 0;
			Config.gyroAngle.value = gyroTotal/ ((double) totalValues);
			gyroTotal = 0;
		}

		//if(IO.xboxDrive.getAButtonPressed())Components.ahrs.calibrate();//calibrate when needed
		//if(IO.xboxDrive.getYButtonPressed())Components.ahrs.zeroYaw();
		//DRIVE CODE!!
		double xboxX;
			double xboxY;
			double xboxT;
			if(IO.xboxDrive.getBButton()){
				
			}else{

				//Adding DeadZone
				if(Math.abs(IO.xboxDrive.getLeftX())<0.08){
					xboxX = 0;
				} else {
					xboxX = IO.xboxDrive.getLeftX();
				}
		
				if(Math.abs(IO.xboxDrive.getLeftY())<0.08){
					xboxY = 0;
				} else {
					xboxY = IO.xboxDrive.getLeftY();
				}
		
				if(Math.abs(IO.xboxDrive.getRightX())<0.08){
					xboxT = 0;
				} else {
					xboxT = IO.xboxDrive.getRightX();
				}

				double xboxXX = (xboxX)*frc.robot.subsystems.driveRLSpeed;
				double xboxYY = (xboxY)*frc.robot.subsystems.driveFBSpeed;
				double xboxTT = (xboxT)*frc.robot.subsystems.driveTSpeed;
				if(IO.xboxDrive.getRawAxis(3)>0.75)xboxTT/=3;//slow turn for Timmy on lign up
				Components.sparkWheelFR.setPower(((frc.robot.subsystems.rotationalModifier*frc.robot.subsystems.driveSpeed*frc.robot.subsystems.driveLongRadius*xboxTT)+Math.sqrt(2)*(frc.robot.subsystems.driveSpeed*(xboxXX+xboxYY)))/2000);
				Components.sparkWheelFL.setPower(((frc.robot.subsystems.rotationalModifier*frc.robot.subsystems.driveSpeed*frc.robot.subsystems.driveLongRadius*xboxTT)+Math.sqrt(2)*(frc.robot.subsystems.driveSpeed*(xboxXX-xboxYY)))/2000);
				Components.sparkWheelBL.setPower(((frc.robot.subsystems.rotationalModifier*frc.robot.subsystems.driveSpeed*frc.robot.subsystems.driveLongRadius*xboxTT)+Math.sqrt(2)*(frc.robot.subsystems.driveSpeed*(-xboxXX-xboxYY)))/2000);
				Components.sparkWheelBR.setPower(((frc.robot.subsystems.rotationalModifier*frc.robot.subsystems.driveSpeed*frc.robot.subsystems.driveLongRadius*xboxTT)+Math.sqrt(2)*(frc.robot.subsystems.driveSpeed*(-xboxXX+xboxYY)))/2000);
				Components.sparkWheelSR.setPower(((frc.robot.subsystems.rotationalModifier*frc.robot.subsystems.driveSpeed*frc.robot.subsystems.driveShortRadius*xboxTT)+frc.robot.subsystems.driveSpeed*(xboxYY))/2000);
				Components.sparkWheelSL.setPower(((frc.robot.subsystems.rotationalModifier*frc.robot.subsystems.driveSpeed*frc.robot.subsystems.driveShortRadius*xboxTT)+frc.robot.subsystems.driveSpeed*(-xboxYY))/2000);
			}
			
			
			/*double targetX = 0;
			boolean linedUp = false;
			if(Math.abs(targetX) < 1){
				linedUp = true;
			} else if (targetX > 1){
				Components.sparkWheelSL.setPower(100*Math.abs(targetX));
				Components.sparkWheelSR.setPower(-100*Math.abs(targetX));
				linedUp = false;
			} else if (targetX < 1){
				Components.sparkWheelSL.setPower(-100*Math.abs(targetX));
				Components.sparkWheelSR.setPower(100*Math.abs(targetX));
				linedUp = false;
			}
			*/

			
	}
 
	public double previousAngle = 0;

	public void zeroAllMotors() {

	}
	public void Drive(double leftSpeed, double rightSpeed) {
		
	}

	public void ShootyShoot(double leftSpeed, double rightSpeed){

	}
}
