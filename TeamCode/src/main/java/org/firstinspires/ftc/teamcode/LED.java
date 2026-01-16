package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class LED {
    private Servo Light;

    public void init(HardwareMap hwMap) {
        Light = hwMap.get(Servo.class, "Endgame Servo 1");
    }

    public void setServoPos(double angle) {
        Light.setPosition(angle);
    }


}