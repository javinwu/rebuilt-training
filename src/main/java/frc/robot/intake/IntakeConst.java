package frc.robot.intake;

import static edu.wpi.first.units.Units.Degrees;

import edu.wpi.first.units.measure.Angle;

public class IntakeConst {
    // placeholder values must be found through testing
    public static final int DEPLOY_MOTOR_ID = -1;
    public static final int ROLLER_MOTOR_ID = -1;
    public static final double ROLLER_SPEED = -1.0;
    public static final double ROLLER_REVERSE_SPEED = -ROLLER_SPEED;

    public static final double DEPLOY_GEAR_RATIO = 96.0;
    public static final Angle MIN_ANGLE = Degrees.of(0.0);
    public static final Angle MAX_ANGLE = Degrees.of(128.26);
}
