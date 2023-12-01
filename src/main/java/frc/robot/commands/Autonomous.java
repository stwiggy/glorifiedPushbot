// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Arm;

public class Autonomous extends CommandBase {
  Drivetrain drivetrain;
  Arm arm;
  private final Timer time = new Timer();
  
  public Autonomous(Drivetrain dt) {
    addRequirements(drivetrain = dt);
  }

  @Override
  public void initialize() {
    time.start();
    drivetrain.tank(0.5, 0.5);
    //new MoveArm(arm);
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {
    drivetrain.tank(0, 0);
  }

  @Override
  public boolean isFinished() {
    return time.get() > 5;
  }
}
