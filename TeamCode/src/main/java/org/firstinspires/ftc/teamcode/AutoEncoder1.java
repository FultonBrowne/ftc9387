package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.framework.Color;
import org.firstinspires.ftc.teamcode.framework.Move;

import java.util.Timer;
import java.util.TimerTask;

@Autonomous(name = "red encode")
public class AutoEncoder1 extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();

    public ModernRoboticsI2cRangeSensor range0;
    public Servo servo1;
    int wheelSize = 60;


    @Override
    public void runOpMode() throws InterruptedException {
        //get the motors
        DcMotor motor0 = hardwareMap.dcMotor.get("motor0");
        DcMotor motor1 = hardwareMap.dcMotor.get("motor1");
        DcMotor motor2 = hardwareMap.dcMotor.get("motor2");
        DcMotor motor3 = hardwareMap.dcMotor.get("motor3");
        DcMotor arm = hardwareMap.dcMotor.get("motor4");
        DcMotor arm2 = hardwareMap.dcMotor.get("motor5");

        Color color = new Color();
        servo1 = hardwareMap.servo.get("servo1");
        //sensors
        range0 = hardwareMap.get( ModernRoboticsI2cRangeSensor.class,"range0");
        //set the breaks
        motor0.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor3.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //servos
        servo1 = hardwareMap.servo.get("servo1");
        //sensors
        range0 = hardwareMap.get( ModernRoboticsI2cRangeSensor.class,"range0");
        ColorSensor colorSensor = hardwareMap.colorSensor.get("color1");
        motor0.setDirection(DcMotorSimple.Direction.REVERSE);
        motor0.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motor0.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motor1.setDirection(DcMotorSimple.Direction.REVERSE);
        motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        motor3.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        new Move().arm(1.0, servo1);

        //move claw in correct position
        //move to blocks
        new Move().left(motor0, motor1, motor2, motor3);
        while (motor0.getCurrentPosition() <38000);
        new Move().back(motor0, motor1, motor2, motor3);
        telemetry.addData("while is running 1", "");
        telemetry.update();
        fiindStone(colorSensor, color);
        new Move().stop(motor0, motor1, motor2, motor3);
        sleep(2000);
        //find the yellow
        new Move().back(motor0, motor1, motor2, motor3);
        telemetry.addData("while is running 2", "");
        fiindStone2(colorSensor, color);
        //move in and get the block
        sleep(400);
        new Move().spin(motor0, motor1, motor2, motor3);
        sleep(25);
        new Move().left(motor0, motor1, motor2, motor3);
        sleep(1300);
        new Move().forward(motor0, motor1, motor2, motor3);
        sleep(700);
        new Move().stop(motor0, motor1, motor2, motor3);
        new Move().arm(0.0, servo1);
        sleep(2000);
        new Move().elevator(arm, arm2, 0.5);
        sleep(250);
        new Move().elevator(arm, arm2, 0.0);
        // pull out
        new Move().right(motor0, motor1, motor2, motor3);
        sleep(2100);
        new Move().stop(motor0, motor1, motor2, motor3);
        //find the over hang
        new Move().forward(motor0, motor1, motor2, motor3);
        telemetry.addData("while is running", "");
        while (true) {
            boolean scan = range0.rawUltrasonic() < 40;
            if (scan) {
                telemetry.addData("is true", "");
                break;
            }
        }
        // move ot drop the block and come back
        sleep(3000);
        new Move().back(motor0, motor1, motor2, motor3);
        new Move().arm(1.0, servo1);
        sleep(3000);
        new Move().stop(motor0, motor1, motor2, motor3);





    }

    private void fiindStone(ColorSensor colorSensor, Color color) {
        long currentTimeMillis = System.currentTimeMillis() + 4000;
        while (!color.colors(colorSensor, telemetry) || currentTimeMillis < System.currentTimeMillis() ) {
            telemetry.addData("is true 2", "");

        }
    }
    private void fiindStone2(ColorSensor colorSensor, Color color) {
        long currentTimeMillis = System.currentTimeMillis() + 2000;
        while (color.colors(colorSensor, telemetry) || currentTimeMillis < System.currentTimeMillis()) {
            telemetry.addData("is true 2", "");

        }
    }

}

