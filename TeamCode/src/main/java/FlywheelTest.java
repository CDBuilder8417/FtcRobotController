import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.opMode;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.telemetry;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;

import org.firstinspires.ftc.teamcode.FlyWheel;

//@TeleOp (name = "TeleOp", group = "Main")
//public class FlywheelTest {
//    private DcMotor flywheelMotor;
//
//    @Override
//    public void init() {
//        HardwareMap hardwareMap = opMode.hardwareMap;
//        flywheelMotor = hardwareMap.get(DcMotorEx.class, "LauncherMotor");
//        flywheelMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
//        flywheelMotor.setDirection(DcMotorSimple.Direction.FORWARD);
//
//        PIDFCoefficients pidfCoefficients= new PIDFCoefficients(21,0,0,650);
//        flywheelMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_USING_ENCODER, pidfCoefficients);
//
//        telemetry.addLine("Init complete");
//
//    }
//
//    public void start() {
//
//
//    }
//}
