package frc.robot.launcher.feeder;

import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FeederSubsystem extends SubsystemBase {
    private final TalonFX motor = new TalonFX(FeederConst.MOTOR_ID, FeederConst.CAN_BUS);

    public FeederSubsystem() {
        motor.getConfigurator().apply(FeederConfig.motorConfig);
    }

    /**
     * sets motor speed
     *
     * @param speed
     */
    private void moveMotorSpeed(double speed) {
        motor.set(speed);
    }

    /** sets motor speed to MOTOR_SPEED */
    public void start() {
        moveMotorSpeed(FeederConfig.MOTOR_SPEED);
    }

    /** stops motor */
    public void stop() {
        moveMotorSpeed(0.0);
    }

    /** reverses motor */
    public void reverse() {
        moveMotorSpeed(FeederConfig.REVERSE_MOTOR_SPEED);
    }

    /**
     * returns motor speed
     *
     * @return
     */
    public double getMotorSpeed() {
        return motor.get();
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty("motor speed", () -> getMotorSpeed(), this::moveMotorSpeed);
    }
}
