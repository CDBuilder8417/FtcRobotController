package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TMotor {


    private DcMotor TurretMotor;

    public void init(HardwareMap hwMap) {

        TurretMotor = hwMap.get(DcMotor.class, "TMotor");
        TurretMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        TurretMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
    }

    public void setMotorSpeed(double speed) {
        TurretMotor.setPower(speed);
    }
}