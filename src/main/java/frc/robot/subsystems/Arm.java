// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  private CANSparkMax wall = MotorControllerFactory.createSparkMax(Constants.MotorPort.kArmID, MotorConfig.NEO);
  private RelativeEncoder encoder = wall.getEncoder();
  //public static double forwardBackward = 0.2;
  /** Creates a new Arm. */
  public Arm() {}

  /*
  public void swap(){
    forwardBackward = -forwardBackward;
    SmartDashboard.putNumber("wanted motor direction", forwardBackward);
  }
  */
  public void reset(){
    encoder.setPosition(0);
  }

  public void autoMove(){
    wall.set(Constants.Arm.kArmDownSpeed);
  }
 
  public void up(){
    wall.set(Constants.Arm.kArmUpSpeed);
    SmartDashboard.putNumber("moving motor direction", Constants.Arm.kArmUpSpeed);
  }

  public void down(){
    wall.set(Constants.Arm.kArmDownSpeed);
    SmartDashboard.putNumber("moving motor direction", Constants.Arm.kArmUpSpeed);
  }


  public void stop(){
    wall.set(0);
  }

  public double getRotations(){
    return encoder.getPosition();
  }

  @Override
  public void periodic() {
  }
}
