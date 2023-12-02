// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Arm;

public class MoveArm extends CommandBase {
  Arm arm;
  public MoveArm(Arm a) {
    addRequirements(arm = a);
  }

  @Override
  public void initialize() {
    arm.setPosition();
    arm.move();
    SmartDashboard.putNumber("target rotations", Constants.Arm.kArmUpSpeed);
  }

  @Override
  public void execute() {
    SmartDashboard.putNumber("current rotations", arm.getRotations());
  }

  @Override
  public void end(boolean interrupted) {
    arm.stop();
  }

  @Override
  public boolean isFinished() {
    return arm.getRotations() >= Constants.Arm.kArmUpTarget;
  }
}