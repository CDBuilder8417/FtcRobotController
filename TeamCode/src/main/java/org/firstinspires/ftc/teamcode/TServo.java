package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TServo {
        private CRServo Tservo;

        public void init(HardwareMap hwMap) {
            Tservo = hwMap.get(CRServo.class, "Turret Servo");
        }

        public void setServoPos(double angle) {
            Tservo.setPower(angle);
        }

    }

