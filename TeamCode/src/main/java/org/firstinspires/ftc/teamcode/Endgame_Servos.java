package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Endgame_Servos {
    private Servo servo1;
    private Servo servo2;
    private Servo servo3;
    private Servo servo4;

    public void init(HardwareMap hwMap) {
        servo1 = hwMap.get(Servo.class, "Endgame Servo 1");
        servo2 = hwMap.get(Servo.class, "Endgame Servo 2");
        servo3 = hwMap.get(Servo.class, "Endgame Servo 3");
        servo4 = hwMap.get(Servo.class, "Endgame Servo 4");
    }

    public void setServoPos(double angle) {
        servo1.setPosition(angle);
        servo2.setPosition(angle);
        servo3.setPosition(angle);
        servo4.setPosition(angle);
    }


}
