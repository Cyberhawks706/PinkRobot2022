package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.commands.Drive;
import frc.robot.subsystems.Chassis;



public class Components {
    public static TalonSRX motorR1;
    public static TalonSRX motorR2;
    public static TalonSRX motorR3;
    public static TalonSRX motorL1;
    public static TalonSRX motorL2;
    public static TalonSRX motorL3;

    public static Chassis chassis;

    public static Drive drive;

    

    public static void init(){
        motorR1 = new TalonSRX(9);
        motorR2 = new TalonSRX(10);
        motorR3 = new TalonSRX(11);
        motorL1 = new TalonSRX(6);
        motorL2 = new TalonSRX(7);
        motorL3 = new TalonSRX(8);

        chassis = new Chassis();

        drive = new Drive();
    }
    

}
