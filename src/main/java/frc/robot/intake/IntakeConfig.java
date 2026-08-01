package frc.robot.intake;

import static edu.wpi.first.units.Units.Rotations;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class IntakeConfig {
    public static final TalonFXConfiguration deployConfig = new TalonFXConfiguration();
    public static final TalonFXConfiguration rollerConfig = new TalonFXConfiguration();

    static {
        // current limits and motor directions are placeholders until tested on the robot
        // TO:DO
        deployConfig.CurrentLimits.StatorCurrentLimit = -1;
        deployConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        deployConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
        deployConfig.Feedback.SensorToMechanismRatio = IntakeConst.DEPLOY_GEAR_RATIO;

        deployConfig.SoftwareLimitSwitch.ForwardSoftLimitEnable = true;
        deployConfig.SoftwareLimitSwitch.ForwardSoftLimitThreshold =
                IntakeConst.MAX_ANGLE.in(Rotations);
        deployConfig.SoftwareLimitSwitch.ReverseSoftLimitEnable = true;
        deployConfig.SoftwareLimitSwitch.ReverseSoftLimitThreshold =
                IntakeConst.MIN_ANGLE.in(Rotations);

        // TO:DO
        rollerConfig.CurrentLimits.StatorCurrentLimit = -1;
        rollerConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        rollerConfig.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;
    }
}
