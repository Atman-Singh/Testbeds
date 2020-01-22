package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;


public class RotateHood extends CommandBase {
    private double speed;
    private double angle;
    public RotateHood(double speed, double angle) {
        this.speed = speed;
        this.angle = angle;
        addRequirements(RobotContainer.turret);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        RobotContainer.turret.setHood(speed);
    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return RobotContainer.turret.getHoodEncoder().getDistance() > angle; // calculations here
    }

    @Override
    public void end(boolean interrupted) {
        RobotContainer.turret.setHood(0);
    }
}