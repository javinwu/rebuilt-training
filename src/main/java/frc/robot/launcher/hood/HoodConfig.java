package frc.robot.launcher.hood;

import com.ctre.phoenix6.configs.TalonFXConfiguration;

public class HoodConfig {
    public static final TalonFXConfiguration motorConfig = new TalonFXConfiguration();

    static {
        motorConfig.Feedback.SensorToMechanismRatio = HoodConst.ROTOR_TO_MECH;
    }
}
