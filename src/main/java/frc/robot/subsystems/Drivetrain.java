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

public class Drivetrain extends SubsystemBase {
  private CANSparkMax leftMotor = MotorControllerFactory.createSparkMax(Constants.MotorPort.kLeftDriveID, MotorConfig.NEO);
  private CANSparkMax rightMotor = MotorControllerFactory.createSparkMax(Constants.MotorPort.kRightDriveID, MotorConfig.NEO);
  private XboxController controller;
  public boolean isTank = true;
  private boolean isAuto;

  public Drivetrain(XboxController controller) {this.controller = controller;}

  public void tank(double leftY, double rightY){
    if (leftY > 0.1 && leftY < 0.1){
      leftY = 0;
    }
    if (rightY > 0.1 && rightY < 0.1){
      rightY = 0;
    }
    leftMotor.set(leftY * Constants.Drivetrain.kLeftSlowdown);
    rightMotor.set(-rightY * Constants.Drivetrain.kRightSlowdown);
  }

  public void arcade(double speed, double turn){
    speed *= Constants.Drivetrain.kSpeedSlowdown;
    turn *= Constants.Drivetrain.kTurnSlowdown;
    double left = speed + turn;
    double right = speed - turn;

    leftMotor.set(left);
    rightMotor.set(right);
  }

  @Override
  public void periodic() {
    isAuto = Autonomous.isAuto();
    if (isAuto){return;}
    if (isTank){
      tank(0 - controller.getLeftY(), 0 - controller.getRightY());
    }
    else{
      if ((0 - controller.getLeftY() < 0.1 && 0 - controller.getLeftY() > -0.1) && (0 - controller.getRightX() < 0.1 && 0 - controller.getRightX() > -0.1)){
        arcade(0,0);
      }
      else if (0 - controller.getLeftY() < 0.1 && 0 - controller.getLeftY() > -0.1){
        arcade(0, 0 - controller.getRightY());
      }
      else if (0 - controller.getRightX() < 0.1 && 0 - controller.getRightX() > -0.1){
        arcade(0 - controller.getLeftY(), 0);
      }
      else{
        arcade(0 - controller.getLeftY(), 0 - controller.getRightX());
      }
    }

  }
}
