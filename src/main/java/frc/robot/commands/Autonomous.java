// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Arm;

public class Autonomous extends CommandBase {
  Drivetrain drivetrain;
  Arm arm;
  private final Timer time = new Timer();
  private static boolean auto = false;
  
  public Autonomous(Drivetrain dt) {
    addRequirements(drivetrain = dt);
  }

  public static boolean isAuto(){
    return auto;
  }

  @Override
  public void initialize() {
    auto = true;
    time.reset();
    time.start();
    drivetrain.tank(0.5, 0.5);
  }

  @Override
  public void execute() {
    System.out.println(time.get());
  }

  @Override
  public void end(boolean interrupted) {
    drivetrain.tank(0, 0);
    auto = false;
    System.out.println("stopped");
    SmartDashboard.putString("stopped", "yes");
  }

  @Override
  public boolean isFinished() {
    return time.get() > 15;
  }
}
