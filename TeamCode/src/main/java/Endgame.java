import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.EndgameMotor;
import org.firstinspires.ftc.teamcode.Endgame_Servos;
import org.firstinspires.ftc.teamcode.EndgameTouch;


@TeleOp
public class Endgame extends OpMode {
    EndgameMotor motorbench = new EndgameMotor();
    EndgameTouch touchbench = new EndgameTouch();


    @Override
    public void init() {
        motorbench.init(hardwareMap);
        touchbench.init(this);
    }

    @Override
    public void loop() {
        double motorSpeed = gamepad1.left_stick_y;
        motorbench.setMotorSpeed(motorSpeed);

        if (touchbench.touchSensorPressed()) {
            motorbench.setMotorSpeed(Range.clip(motorSpeed, 0.0, 1.0));
        }
        else {
            motorbench.setMotorSpeed(motorSpeed);
        }

    }

}