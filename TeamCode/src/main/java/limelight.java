import com.qualcomm.hardware.limelightvision.LLResult;
import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.navigation.Pose3D;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.Light;
import org.firstinspires.ftc.teamcode.TMotor;
import org.firstinspires.ftc.teamcode.TServo;
import org.firstinspires.ftc.teamcode.WhiteLight;

import java.lang.annotation.Target;

@TeleOp (name= "limelight", group= "main")
public class limelight extends OpMode {
    TServo bench = new TServo();
    Light lightbench = new Light();

    WhiteLight WhiteLightbench = new WhiteLight();
    private Limelight3A limelight;
    private IMU imu;
    private DcMotor TurretMotor;



    private double distance;

    @Override
    public void init() {
        limelight=hardwareMap.get(Limelight3A.class, "limelight");
        limelight.pipelineSwitch(0);

        imu= hardwareMap.get(IMU.class, "imu");
        RevHubOrientationOnRobot revHubOrientationOnRobot= new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD);
        imu.initialize(new IMU.Parameters(revHubOrientationOnRobot));
        bench.init(hardwareMap);
    }

    @Override
    public void start() {
        limelight.start();
    }

    public void init(HardwareMap hwMap) {
        lightbench.init(hardwareMap);
        TurretMotor= hwMap.get(DcMotor.class, "TMotor");
        TurretMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }


    @Override
    public void loop() {
        YawPitchRollAngles orientation= imu.getRobotYawPitchRollAngles();
        limelight.updateRobotOrientation(orientation.getYaw());
        LLResult llResult= limelight.getLatestResult();
        if (llResult != null && llResult.isValid()) {
            Pose3D botpose= llResult.getBotpose_MT2();
            distance = getDistanceFromTage(llResult.getTa());
            telemetry.addData("distance", distance);
            telemetry.addData("Tx", llResult.getTx());
            telemetry.addData("Ta", llResult.getTa());
        }

        double Tx = llResult.getTx();

        if (Tx < -3) {
            telemetry.addData("Tx", "TurretLeft");
            if (Tx < -10) {
                bench.setServoPos(-1);
            }
            else {
                bench.setServoPos(-1*Tx/10);
            }
        }

        else if (Tx > 3) {
            telemetry.addData("Tx", "TurretRight");
            if (Tx > 10) {
                bench.setServoPos(1);
            }
            else {
                bench.setServoPos(1*Tx/10);
            }
        }

        else {
            telemetry.addData("Tx", "Good");
            bench.setServoPos(0);
        }

        telemetry.addData("Tx", "llresult.getTx");

        if (distance > 4) {
            lightbench.setServoPos(0.277);
        }

        else if (distance < 2 && distance > 4) {
            lightbench.setServoPos(0.500);
        }

        else {
            lightbench.setServoPos(0.388);
        }



    }


    public double getDistanceFromTage(double ta) {
        double scale= 3.085408;  // y value in equation
        double distance= (scale / ta);
        return distance;

    }


}