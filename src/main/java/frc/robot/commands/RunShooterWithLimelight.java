// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LimelightSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RunShooterWithLimelight extends CommandBase {

  private ShooterSubsystem shooterSubsystem;
  private XboxController joystick;
  private LimelightSubsystem limelightSubsystem;
  

  /** Creates a new RunShooterWithJoystick. */
  public RunShooterWithLimelight(ShooterSubsystem shooterSubsystem, LimelightSubsystem limelightSubsystem, XboxController joystick) {
    // Use addRequirements() here to declare subsystem dependencies.
    this.shooterSubsystem = shooterSubsystem;
    this.joystick = joystick;
    this.limelightSubsystem = limelightSubsystem;
    addRequirements(shooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    shooterSubsystem.coast();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double distance = limelightSubsystem.getDistance();
    
    //Shooting with bumper
    
    //if (joystick.getRightTriggerAxis()!=0)
    //{
    //  shooterSubsystem.setShooterPower(joystick.getRightTriggerAxis());
    //} else if (joystick.getLeftTriggerAxis()!=0){
    //  shooterSubsystem.setShooterPower(-joystick.getLeftTriggerAxis());
    //}
    
    //0.55 speed, running to shoot

  
    /*if (joystick.getYButton()) {
        shooterSubsystem.setShooterPower(power);
    }*/
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.setShooterPower(0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}