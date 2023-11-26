// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import org.carlmontrobotics.lib199.MotorConfig;
import org.carlmontrobotics.lib199.MotorControllerFactory;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
  private CANSparkMax wall = MotorControllerFactory.createSparkMax(Constants.MotorPort.kArmID, MotorConfig.NEO);
  private RelativeEncoder encoder = wall.getEncoder();
  /** Creates a new Arm. */
  public Arm() {}

  public void move(){
    wall.set(0.1);
  }

  public void stop(){
    wall.set(0);
  }

  public double getRotations(){
    return encoder.getPosition();
  }

  @Override
  public void periodic() {}
}
