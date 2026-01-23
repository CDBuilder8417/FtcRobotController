package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class WhiteLight {
        private Servo Whitelight;

        public void init(HardwareMap hwMap) {
            Whitelight = hwMap.get(Servo.class, "White Light");
        }

        public void setServoPos(double angle) {
            Whitelight.setPosition(angle);
        }


    }
