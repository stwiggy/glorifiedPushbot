// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static class Arm {
        public static final double kArmDownSpeed = 0.7;
        public static final double kArmUpSpeed = -kArmDownSpeed;
        public static final double kArmDownTarget = 2;
        public static final double kArmUpTarget = -kArmDownTarget;
    }
    public static class MotorPort {
        public static final int kLeftDriveID = 6;
        public static final int kRightDriveID = 5;
        public static final int kArmID = 20;
    }

    public static class Drivetrain {
        public static final double kLeftSlowdown = 0.8;
        public static final double kRightSlowdown = 0.8;
        public static final double kTurnSlowdown = 0.6;
        public static final double kSpeedSlowdown = 0.3;
        public static final double kDeadbandRange = 0.03;
    }

    public static class OI {
        public static final int kcontrollerPort = 0;
        public static final int kButtonA = 1;
        public static final int kButtonB = 2;
        public static final int kButtonX = 3;
        public static final int kButtonY = 4;
    }
}
