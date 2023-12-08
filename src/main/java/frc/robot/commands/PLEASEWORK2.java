// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Arm;


public class PLEASEWORK2 extends CommandBase {
  Arm arm;
  /** Creates a new PLEASEWORK2. */
  public PLEASEWORK2(Arm a) {
    addRequirements(arm = a);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    arm.down();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
