package frc.robot.intake;

import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.Rotations;

import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.util.sendable.SendableBuilder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
    private final TalonFX deployMotor = new TalonFX(IntakeConst.DEPLOY_MOTOR_ID);
    private final TalonFX rollerMotor = new TalonFX(IntakeConst.ROLLER_MOTOR_ID);

    private Angle targetAngle;

    public IntakeSubsystem() {
        deployMotor.getConfigurator().apply(IntakeConfig.deployConfig);
        rollerMotor.getConfigurator().apply(IntakeConfig.rollerConfig);

        deployMotor.setPosition(IntakeConst.MAX_ANGLE);
        targetAngle = IntakeConst.MAX_ANGLE;
    }

    /**
     * sets roller speed
     *
     * @param speed
     */
    public void moveRollerSpeed(double speed) {
        rollerMotor.set(speed);
    }

    /** sets roller to ROLLER_SPEED */
    public void rollersOn() {
        moveRollerSpeed(IntakeConst.ROLLER_SPEED);
    }

    /** turns off rollers */
    public void rollersOff() {
        moveRollerSpeed(0.0);
    }

    /** reverses rollers */
    public void rollersReverse() {
        moveRollerSpeed(IntakeConst.ROLLER_REVERSE_SPEED);
    }

    /**
     * sets angle
     *
     * @param angle
     */
    public void moveAngle(Angle angle) {
        targetAngle =
                Rotations.of(
                        MathUtil.clamp(
                                angle.in(Rotations),
                                IntakeConst.MIN_ANGLE.in(Rotations),
                                IntakeConst.MAX_ANGLE.in(Rotations)));
        deployMotor.setControl(new MotionMagicVoltage(targetAngle));
    }

    /** moves intake down */
    public void moveDown() {
        moveAngle(IntakeConst.MIN_ANGLE);
    }

    /** moves intake up */
    public void moveUp() {
        moveAngle(IntakeConst.MAX_ANGLE);
    }

    /** turns roller on and moves down */
    public void deploy() {
        rollersOn();
        moveDown();
    }

    /** stows intake */
    public void stow() {
        rollersOff();
        moveUp();
    }

    /**
     * gets angle
     *
     * @return
     */
    public Angle getAngle() {
        return deployMotor.getPosition().getValue();
    }

    @Override
    public void initSendable(SendableBuilder builder) {
        builder.addDoubleProperty(
                "angle (deg)", () -> getAngle().in(Degrees), angle -> moveAngle(Degrees.of(angle)));
        builder.addDoubleProperty("target angle", () -> targetAngle.in(Degrees), null);
    }
}
