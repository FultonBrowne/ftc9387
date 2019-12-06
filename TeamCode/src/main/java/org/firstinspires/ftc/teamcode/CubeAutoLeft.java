package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.framework.Color;
import org.firstinspires.ftc.teamcode.framework.Move;

import java.util.Timer;
import java.util.TimerTask;
@Autonomous(name = "cube left")
public class CubeAutoLeft extends OpMode {
    private DcMotor motor0, motor1, motor2, motor3;
    private Timer time;
    private ColorSensor colorSensor;

    private TimerTask initMove, stop1, search, moveABit, stop2, hitBlock, stop3, moveOut, moveIn, hold, letGo, spin, moveATiny;

    @Override
    public void init() {
        motor0 = hardwareMap.dcMotor.get("motor0");
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
        colorSensor = hardwareMap.colorSensor.get("color1");
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
        moveOut = new TimerTask() {
            @Override
            public void run() {
                new Move().right(motor0, motor1, motor2, motor3);
            }
        };
        moveIn = new TimerTask() {
            @Override
            public void run() {
                new Move().forward(motor0, motor1, motor2, motor3);
            }
        };
        hold = new TimerTask() {
            @Override
            public void run() {
                //new Move().left(motor0, motor1, motor2, motor3);
            }
        };
        letGo = new TimerTask() {
            @Override
            public void run() {
                new Move().stop(motor0, motor1, motor2, motor3);
            }
        };
        spin= new TimerTask() {
            @Override
            public void run() {
                new Move().spin(motor0,motor1, motor2, motor3);
            }
        };
        initMove = new TimerTask() {
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
        stop3 = new TimerTask() {
            @Override
            public void run() {
                new Move().stop(motor0, motor1, motor2, motor3);
            }
        };
        moveABit = new TimerTask() {
            @Override
            public void run() {
                Boolean foundColor = false;
                new Move().back(motor0, motor1, motor2, motor3);
                telemetry.addData("while is running", "");
                while (true) {
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
        hitBlock= new TimerTask() {
            @Override
            public void run() {
                new Move().left(motor0, motor1, motor2, motor3);
            }
        };
        moveATiny= new TimerTask() {
            @Override
            public void run() {
                new Move().back(motor0, motor1, motor2, motor3);
            }
        };
        search = new TimerTask() {
            @Override
            public void run() {
                Boolean foundColor = false;
                new Move().back(motor0, motor1, motor2, motor3);
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
    }
    public void start(){
        time.schedule(initMove, 0);
        time.schedule(stop1, 2700);
        time.schedule(search, 2701);
        time.schedule(stop2, 7000);
        time.schedule(spin, 7075);
        time.schedule(moveABit, 7100);
        time.schedule(moveATiny, 9750);
        time.schedule(hitBlock, 10000);
        time.schedule(stop3, 11000);
        time.schedule(hold, 11100);
        time.schedule(moveOut, 11600);
        time.schedule(moveIn,13400);
        time.schedule(letGo, 13500);}


}

