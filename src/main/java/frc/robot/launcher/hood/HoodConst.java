package frc.robot.launcher.hood;

import static edu.wpi.first.units.Units.Degrees;

import com.ctre.phoenix6.CANBus;

import edu.wpi.first.units.measure.Angle;

public class HoodConst {
    // TODO: get from robot
    public static final int MOTOR_ID = -1;
    public static final CANBus CAN_BUS = new CANBus();

    public static final Angle MIN_PITCH = Degrees.of(-1);
    public static final Angle MAX_PITCH = Degrees.of(73.606);

    public static final int ROTOR_TO_MECH = 24;
}
