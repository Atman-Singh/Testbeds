package frc.robot.subsystems;


import edu.wpi.first.wpilibj.interfaces.Gyro;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.motor.Encoder;
import frc.robot.motor.TitanSRX;

public abstract class DriveTrain extends SubsystemBase {

	public abstract void set(double speed);

//	public abstract void set(double leftSpeed, double rightSpeed);

	public abstract void stop();

	public abstract void coast();

	public abstract void resetEncoders();

	public abstract Encoder getEncoder();

//	public abstract Encoder getLeftEncoder();

//	public abstract Encoder getRightEncoder();

//	public abstract TitanSRX getLeft();

//	public abstract TitanSRX getRight();

	public abstract TitanSRX getMotor();

	public abstract Gyro getGyro();

	/**
	 * @param right True if should turn right (clockwise), false if left
	 * @param speed Speed of motors
	 */
	public abstract void turnInPlace(boolean right, double speed);

	public abstract void setLeft(double speed);

	public abstract void setRight(double speed);

	public abstract double[] getSpeed();

	public abstract void enableBrownoutProtection();

	public abstract void disableBrownoutProtection();

	public abstract boolean getPressureSwitchValue();

	public abstract void setCooling(boolean b);

//	public abstract Pose2d getPose();


}
