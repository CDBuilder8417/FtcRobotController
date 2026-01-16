package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class EndgameMotor {
    private DcMotor motor;

    public void init(HardwareMap hwMap){
        motor = hwMap.get(DcMotor.class, "Endgame Motor");
        motor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        motor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setMotorSpeed(double speed) {
        motor.setPower(speed);
    }
}
