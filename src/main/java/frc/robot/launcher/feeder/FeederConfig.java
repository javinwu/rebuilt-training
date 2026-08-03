package frc.robot.launcher.feeder;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

public class FeederConfig {
    public static final TalonFXConfiguration motorConfig = new TalonFXConfiguration();

    // TODO: get actual speed
    public static final double MOTOR_SPEED = 0.5;
    public static final double REVERSE_MOTOR_SPEED = -0.5;

    // TODO: get from robot later
    static {
        motorConfig.CurrentLimits.StatorCurrentLimit = -1;

        motorConfig.MotorOutput.NeutralMode = NeutralModeValue.Coast;
        // positive
        motorConfig.MotorOutput.Inverted = InvertedValue.Clockwise_Positive;
    }
}
