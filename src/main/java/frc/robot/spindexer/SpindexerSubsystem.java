package frc.robot.spindexer;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class SpindexerSubsystem extends SubsystemBase {
    private final TalonFX motor = new TalonFX(SpindexerConst.MOTOR_ID);

    public SpindexerSubsystem() {
        motor.getConfigurator().apply(SpindexerConfig.motorConfig);
    }

    /**
     * sets motor speed
     *
     * @param speed
     */
    public void moveMotorSpeed(double speed) {
        motor.set(speed);
    }

    /** spins motor */
    public void start() {
        moveMotorSpeed(SpindexerConfig.MOTOR_SPEED);
    }

    /** stops motor */
    public void stop() {
        moveMotorSpeed(0.0);
    }

    /**
     * returns current motor speed
     *
     * @return
     */
    public double getMotorSpeed() {
        return motor.get();
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty(
                "angular velocity", () -> motor.getVelocity().getValueAsDouble(), null);
        builder.addDoubleProperty("motor speed (frac)", this::getMotorSpeed, this::moveMotorSpeed);
    }
}
