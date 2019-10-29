package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.framework.Move;

import java.util.Timer;
import java.util.TimerTask;
@Autonomous(name ="AutoMode")
public class Week1AutoMode extends OpMode {
    private DcMotor motor0, motor1, motor2, motor3, motor4;
    private Timer time;
    private TimerTask initMove, stop1;

    @Override
    public void init() {
        motor0 = hardwareMap.dcMotor.get("motor0");
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
        motor4 = hardwareMap.dcMotor.get("motor4");
        time = new Timer();
        declareTimerTasks();
    }

    @Override
    public void loop() {
        time.schedule(initMove, 0);

    }
    private void declareTimerTasks(){
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



    }
    public void start(){
        time.schedule(initMove,0);
        time.schedule(stop1, 3000);
    }

}
