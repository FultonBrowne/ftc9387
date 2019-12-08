package org.firstinspires.ftc.teamcode;

import android.graphics.Path;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.framework.Move;

import java.util.Timer;
import java.util.TimerTask;

@Autonomous(name = "6559")
public class main6559code extends OpMode {
    private TimerTask initMove, stop1, search, moveABit, stop2, hitBlock, stop3, moveOut, moveIn, hold, letGo, spin, moveATiny, forward0, forward1, stop5, stop4, underBridge, back0;
    private DcMotor motor0, motor1, motor2, motor3;
    private Timer time;
    private CRServo servo1;
    private ColorSensor colorSensor;
    private ModernRoboticsI2cRangeSensor range0;
    @Override
    public void init() {
        motor0 = hardwareMap.dcMotor.get("motor0");
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
        servo1 = hardwareMap.crservo.get("servo1");
        colorSensor = hardwareMap.colorSensor.get("color1");
        declareTimerTasks();
    }

    @Override
    public void loop() {

    }
    public void start(){

    }
    public void declareTimerTasks(){
        underBridge= new TimerTask() {
            @Override
            public void run() {
                Boolean foundColor = false;
                new Move().forward(motor0, motor1, motor2, motor3);
                telemetry.addData("while is running", "");
                while (true) {
                    boolean scan = range0.rawUltrasonic() < 40;
                    foundColor = scan;
                    if (scan) {
                        telemetry.addData("is true", "");
                        break;
                    }
                }
                new Move().stop(motor0, motor1, motor2,motor3);
            }
        };
    }
}
