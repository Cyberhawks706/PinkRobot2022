package frc.robot;

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.


import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.util.net.PortForwarder;
import edu.wpi.first.wpilibj.DriverStation;
//color stuff
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.util.Color;


public class Robot extends TimedRobot {

	public static boolean emergencyDisabled = false;

	Command autonomousCommand;
	SendableChooser<Command> chooser = new SendableChooser<>();


	public static NetworkTable limelightTable;
	
	
	public static boolean auto;
	public static DriverStation driverStation;
	public static TalonSRX _talon;
	////public static UsbCamera drivercam;
	////public static UsbCamera drivercam2;
	////public static UsbCamera visioncam;

	public Color detectColor;

	public static IO io;
	

	private final I2C.Port i2cport = I2C.Port.kOnboard;

	public void robotInit() {

		System.out.println("Started");
		Components.init();
		io = new IO();


	}
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		//Auton.run();
	}

	public void autonomousPeriodic() {
		//Scheduler.getInstance().run();
	}

	public void teleopInit() {
	}

	public void teleopPeriodic() {
		Scheduler.getInstance().run();	
	}

}


