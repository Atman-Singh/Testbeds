/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.motor.TitanSRX;
import frc.robot.sensors.QuadEncoder;
import frc.robot.sensors.TitanButton;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
@SuppressWarnings("FieldCanBeLocal")
public class RobotContainer {

	/**
	 * The container for the robot.  Contains subsystems, OI devices, and commands.
	 */

	//Motors
	TitanSRX mainMotor;

	//Encoders
	QuadEncoder mainMotorEncoder;

	//Subsystems
	TankDrive driveTrain;

	//Sensors
	ColorSensorV3 colorSensor;

	//buttons
	TitanButton buttonOne;
	TitanButton buttonTwo;
	TitanButton buttonThree;
	TitanButton buttonFour;
	TitanButton buttonFive;

	OI oi;

	double pConstant = 4;

	public RobotContainer() {
		//motors and encoders
		mainMotor = new TitanSRX(RobotMap.MAIN_TALON, false); //could be true
		mainMotorEncoder = new QuadEncoder(mainMotor, 0,true); //could be true
		mainMotor.setEncoder(mainMotorEncoder);

		mainMotor.configPID(pConstant,0,0);

		//subsystems
		driveTrain = new TankDrive(mainMotor);

		//sensors
//		colorSensor = new ColorSensorV3(RobotMap.COLOR_SENSOR_PORT);

		//buttons
		oi = new OI();
		buttonOne = new TitanButton(oi.joystick, 1);
		buttonTwo = new TitanButton(oi.joystick, 2);
		buttonThree = new TitanButton(oi.joystick, 3);
		buttonFour = new TitanButton(oi.joystick, 4);
		buttonFive = new TitanButton(oi.joystick, 5);

		configureButtonBindings();

		//CommandScheduler
//		CommandScheduler.getInstance().registerSubsystem(driveTrain);
//		CommandScheduler.getInstance().schedule(new ExampleCommand(driveTrain));
	}

	/**
	 * Use this method to define your button->command mappings.  Buttons can be created by
	 * instantiating a {@link GenericHID} or one of its subclasses ({@link
	 * edu.wpi.first.wpilibj.Joystick Joystick} or {@link XboxController}), and then passing it to a
	 * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton JoystickButton}.
	 */
	private void configureButtonBindings() {
//		startButton.whileHeld(() -> mainMotor.setAngleTicks(480));
		buttonOne.whenPressed(() -> mainMotor.set(.1));
		buttonOne.whenReleased(() -> mainMotor.set(0));

		buttonThree.whenPressed(() -> mainMotor.set(-.1));
		buttonThree.whenReleased(() -> mainMotor.set(0));

		buttonTwo.whenPressed(() -> mainMotor.setAngleTicks(0));

		buttonFour.whenPressed(() -> {
			pConstant += .05;
			mainMotor.config_kP(0, pConstant);
		});
		buttonFive.whenPressed(() -> {
			pConstant -= .05;
			mainMotor.config_kP(0, pConstant);
		});
	}
}



