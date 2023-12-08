// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;
import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.Autonomous;
import edu.wpi.first.math.MathUtil;

public class Drivetrain extends SubsystemBase {
  private CANSparkMax leftMotor = MotorControllerFactory.createSparkMax(Constants.MotorPort.kLeftDriveID, MotorConfig.NEO);
  private CANSparkMax rightMotor = MotorControllerFactory.createSparkMax(Constants.MotorPort.kRightDriveID, MotorConfig.NEO);
  private XboxController controller;
  public boolean isTank = true;
  public boolean isAuto = true;

  public Drivetrain(XboxController controller) {this.controller = controller;}

  public void tank(double leftY, double rightY){
    leftMotor.set(leftY * leftY * Constants.Drivetrain.kLeftSlowdown);
    rightMotor.set(-(rightY * rightY * Constants.Drivetrain.kRightSlowdown));
  }

  public void arcade(double speed, double turn){
    speed = speed * speed * Constants.Drivetrain.kSpeedSlowdown;
    turn = turn * turn * Constants.Drivetrain.kTurnSlowdown;
    double left = speed + turn;
    double right = speed - turn;

    leftMotor.set(left);
    rightMotor.set(right);
  }
  
  @Override
  public void periodic() {
    isAuto = Autonomous.isAuto();
    if (isTank && !isAuto){
      tank(MathUtil.applyDeadband(Constants.Drivetrain.kDeadbandRange, 0 - controller.getLeftY()), MathUtil.applyDeadband(Constants.Drivetrain.kDeadbandRange, 0 - controller.getRightY()));
    }
    else if (!isTank && !isAuto){
      arcade(MathUtil.applyDeadband(Constants.Drivetrain.kDeadbandRange, 0 - controller.getLeftY()), MathUtil.applyDeadband(Constants.Drivetrain.kDeadbandRange, 0 - controller.getRightX()));
    }
    else{
      return ;
    }
  }
}
