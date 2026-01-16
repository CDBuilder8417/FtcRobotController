package org.firstinspires.ftc.teamcode;

import androidx.annotation.NonNull;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

public class EndgameTouch {

    private TouchSensor touchSensor;

    public void init(@NonNull OpMode opMode) {
        HardwareMap hardwareMap = opMode.hardwareMap;
        touchSensor = (TouchSensor) hardwareMap.get(TouchSensor.class, "touch_sensor");

    }

    public boolean touchSensorPressed() {
        return touchSensor.isPressed();
    }

    public boolean touchSensorReleased() {
        return touchSensor.isPressed();
    }
}
