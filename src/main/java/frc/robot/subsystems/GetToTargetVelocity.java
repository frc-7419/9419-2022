package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants.PIDConstants;

public class GetToTargetVelocity extends CommandBase {

  private ShooterSubsystem shooterSubsystem; 

  private double bKp, tKp;

  private double topTargetVelocity;
  // private double bottomTargetVelocity;

  public GetToTargetVelocity(ShooterSubsystem shooterSubsystem, double topTargetVelocity) {
    this.shooterSubsystem = shooterSubsystem;
    this.topTargetVelocity = topTargetVelocity;
    // this.bottomTargetVelocity = bottomTargetVelocity;
    addRequirements(shooterSubsystem);
  }

  @Override
  public void initialize() {
    shooterSubsystem.setPIDF(0, 0, 0, 0);
    // shooterSubsystem.setBottomPIDF(0, 0, 0, 0);
  }

  @Override
  public void execute() {
    // bKp = PIDConstants.BottomShooterkP;
    tKp = PIDConstants.TopShooterkP;

    shooterSubsystem.setPIDF(0, 0, 0, 0);
    // shooterSubsystem.setBottomPIDF(0, 0, 0, 0);
    shooterSubsystem.setClosedLoopVelocity(topTargetVelocity);
    // shooterSubsystem.setBottomClosedLoopVelocity(bottomTargetVelocity);
  }

  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.off();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
