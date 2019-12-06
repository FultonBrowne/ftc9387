package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.framework.Color;
import org.firstinspires.ftc.teamcode.framework.Move;

import java.util.Timer;
import java.util.TimerTask;
@Autonomous(name = "Cube right")
public class CubeAutoRight extends OpMode {
    private DcMotor motor0, motor1, motor2, motor3;
    private Timer time;
    private ColorSensor colorSensor;

    private TimerTask initMove, stop1, search, stop2, spin, hitBlock,moveABit, stop3;

    @Override
    public void init() {
        motor0 = hardwareMap.dcMotor.get("motor0");
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
        colorSensor = hardwareMap.colorSensor.get("color0");
        motor0.setDirection(DcMotorSimple.Direction.REVERSE);
        motor1.setDirection(DcMotorSimple.Direction.REVERSE);
        motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        motor3.setDirection(DcMotorSimple.Direction.REVERSE);

        time = new Timer();
        declareTimerTasks();
    }

    @Override
    public void loop() {


    }

    private void declareTimerTasks() {
        initMove = new TimerTask() {
            @Override
            public void run() {
                new Move().right(motor0, motor1, motor2, motor3);
            }
        };
        moveABit = new TimerTask() {
            @Override
            public void run() {
                Boolean foundColor = false;
                new Move().forward(motor0, motor1, motor2, motor3);
                telemetry.addData("while is running", "");
                while (!foundColor) {
                    boolean scan = new Color().colors(colorSensor, telemetry);
                    foundColor = scan;
                    if (!scan) {
                        telemetry.addData("is true", "");
                        break;
                    }
                }
                new Move().stop(motor0, motor1, motor2,motor3);
            }
        };
        spin= new TimerTask() {
            @Override
            public void run() {
                new Move().spin(motor0,motor1, motor2, motor3);
            }
        };
        hitBlock= new TimerTask() {
            @Override
            public void run() {
                new Move().left(motor0, motor1, motor2, motor3);
            }
        };
        stop1 = new TimerTask() {
            @Override
            public void run() {
                new Move().stop(motor0, motor1, motor2, motor3);
            }
        };
        stop2 = new TimerTask() {
            @Override
            public void run() {
                new Move().stop(motor0, motor1, motor2, motor3);
            }
        };
        search = new TimerTask() {
            @Override
            public void run() {
                Boolean foundColor = false;
                new Move().forward(motor0, motor1, motor2, motor3);
                telemetry.addData("while is running", "");
                while (!foundColor) {
                    boolean scan = new Color().colors(colorSensor, telemetry);
                    foundColor = scan;
                    if (scan) {
                        telemetry.addData("is true", "");
                        break;
                    }
                }
                new Move().stop(motor0, motor1, motor2,motor3);


            }
        };
        stop3 = new TimerTask() {
            @Override
            public void run() {
                new Move().stop(motor0, motor1, motor2, motor3);
            }
        };
    }
    public void start(){
        time.schedule(initMove, 0);
        time.schedule(stop1, 2500);
        time.schedule(search, 2600);
        time.schedule(stop2, 4000);
        time.schedule(moveABit, 4100);
        time.schedule(hitBlock, 5000);
        time.schedule(stop3, 6000);
    }


}
