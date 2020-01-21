package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.framework.Move;

@Autonomous(name = "plate blue")
public class Plate extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        //get the motors
        DcMotor motor0 = hardwareMap.dcMotor.get("motor0");
        DcMotor motor1 = hardwareMap.dcMotor.get("motor1");
        DcMotor motor2 = hardwareMap.dcMotor.get("motor2");
        DcMotor motor3 = hardwareMap.dcMotor.get("motor3");
        DcMotor arm = hardwareMap.dcMotor.get("motor4");
        //set the breaks
        motor0.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor3.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //servos
        Servo servo1 = hardwareMap.servo.get("servo0");
        //sensors
        motor0.setDirection(DcMotorSimple.Direction.REVERSE);
        motor1.setDirection(DcMotorSimple.Direction.REVERSE);
        motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        motor3.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        ModernRoboticsI2cRangeSensor range0 = hardwareMap.get( ModernRoboticsI2cRangeSensor.class,"range0");

        Move move = new Move();
        move.right(motor0, motor1, motor2, motor3);
        sleep(2000);
        move.back(motor0, motor1, motor2, motor3);
        sleep(3000);
        move.stop(motor0, motor1, motor2, motor3);
        servo1.setPosition(0.0);
        sleep(6000);
        move.forward(motor0, motor1, motor2, motor3);
        sleep(8000);
        servo1.setPosition(1.0);
        move.left(motor0, motor1, motor2, motor3);
        telemetry.addData("while is running", "");
        while (true) {
            boolean scan = range0.rawUltrasonic() < 40;
            if (scan) {
                telemetry.addData("is true", "");
                break;
            }
        }
        move.stop(motor0, motor1, motor2, motor3);


    }
}
