package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Components;
import frc.robot.Constants;
import frc.robot.IO;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

import com.ctre.phoenix.motorcontrol.ControlMode;


public class Drive extends Command {
	DatagramPacket dataPacket;
	DatagramSocket dataSocket;
	
	boolean reverse = false;

	public Drive() {
		requires(Components.chassis);
	}

	public void execute(){
		

		double leftPower;
		double rightPower;
		if(IO.xboxDrive.getAButton()) {
			reverse = reverse ? false : true;
		}
		double xboxX = Math.abs(IO.xboxDrive.getRightX()) * IO.xboxDrive.getRightX();
		double xboxY = Math.abs(IO.xboxDrive.getRightY()) * IO.xboxDrive.getRightY();


		leftPower = (xboxY - xboxX) * (reverse ? -1 : 1);
		rightPower = (xboxY + xboxX) * (reverse ? -1 : 1);

		Components.motorR1.set(ControlMode.PercentOutput, Constants.Drive.slowModifier*rightPower);
		Components.motorR2.set(ControlMode.PercentOutput, Constants.Drive.slowModifier*rightPower);
		Components.motorR3.set(ControlMode.PercentOutput, Constants.Drive.slowModifier*rightPower);
		Components.motorL1.set(ControlMode.PercentOutput, -Constants.Drive.slowModifier*leftPower);
		Components.motorL2.set(ControlMode.PercentOutput, -Constants.Drive.slowModifier*leftPower);
		Components.motorL3.set(ControlMode.PercentOutput, -Constants.Drive.slowModifier*leftPower);
		
		
		}

	protected void initialize() {
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}

	public static void alignShooter(){
		
		//Components.sparkWheelFR.setPower(Constants.Chassis.driveLongRadius*error*PIDConst);
		//Components.sparkWheelFL.setPower(Constants.Chassis.driveLongRadius*error*PIDConst);
		//Components.sparkWheelBL.setPower(Constants.Chassis.driveLongRadius*error*PIDConst);
		//Components.sparkWheelBR.setPower(Constants.Chassis.driveLongRadius*error*PIDConst);
		
	
	}
}
