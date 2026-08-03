package frc.robot.launcher.hood;

import static edu.wpi.first.units.Units.Rotation;
import static edu.wpi.first.units.Units.Rotations;

import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class HoodSubsystem extends SubsystemBase {
    private final TalonFX motor = new TalonFX(HoodConst.MOTOR_ID, HoodConst.CAN_BUS);

    private static Angle targetPitch;

    public HoodSubsystem() {
        motor.getConfigurator().apply(HoodConfig.motorConfig);

        // safety measures
        motor.setPosition(HoodConst.MAX_PITCH);
        targetPitch = HoodConst.MAX_PITCH;
    }

    /**
     * sets pitch
     *
     * @param pitch
     */
    public void movePitch(Angle pitch) {
        targetPitch =
                Rotation.of(
                        MathUtil.clamp(
                                pitch.in(Rotations),
                                HoodConst.MIN_PITCH.in(Rotations),
                                HoodConst.MAX_PITCH.in(Rotations)));

        motor.setControl(new MotionMagicVoltage(targetPitch));
    }

    /**
     * returns pitch
     *
     * @return
     */
    public Angle getPitch() {
        return motor.getPosition().getValue();
    }

    /** stows hood */
    public void stow() {
        movePitch(HoodConst.MAX_PITCH);
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty("pitch", () -> getPitch().in(Rotations), null);
        builder.addDoubleProperty("target pitch", () -> targetPitch.in(Rotations), null);
    }
}
