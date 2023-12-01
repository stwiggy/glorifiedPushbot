// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.Autonomous;
import frc.robot.commands.MoveArm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Arm;

public class RobotContainer {
  public static final XboxController controller = new XboxController(0);
  public static final Drivetrain drivetrain = new Drivetrain(controller);
  public static final Arm arm = new Arm();
  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    JoystickButton buttonA = new JoystickButton(controller, Constants.OI.kButtonA);
    //buttonA.onTrue(new InstantCommand(arm::swap));
    //buttonA.onTrue(new MoveArm(arm));
    new JoystickButton(controller, Constants.OI.kButtonX).onTrue(new InstantCommand(() -> {drivetrain.isTank = true;}));
    new JoystickButton(controller, Constants.OI.kButtonY).onTrue(new InstantCommand(() -> {drivetrain.isTank = false;}));
  }

  public Command getAutonomousCommand() {
    return new Autonomous(drivetrain);
  }
}
