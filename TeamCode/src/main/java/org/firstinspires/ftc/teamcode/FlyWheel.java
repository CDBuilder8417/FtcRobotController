package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

@TeleOp
public class FlyWheel extends OpMode {
    public DcMotorEx flywheelMotor;
    public double lowVelocity=1200;


    @Override
    public void init() {
        flywheelMotor=hardwareMap.get(DcMotorEx.class, "LauncherMotor");
        flywheelMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheelMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        PIDFCoefficients pidfCoefficients= new PIDFCoefficients(19,0,0,-650);
        flywheelMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);

        telemetry.addLine("Init complete");

    }

    @Override
    public void loop() {

        flywheelMotor.setVelocity(lowVelocity);


    }
}
