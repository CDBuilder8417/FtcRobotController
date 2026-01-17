package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;


public class Light {
    private Servo light;

    public void init(HardwareMap hwMap) {
        light = hwMap.get(Servo.class, "light");
    }

    public void setServoPos(double angle) {
        light.setPosition(angle);
    }


}
