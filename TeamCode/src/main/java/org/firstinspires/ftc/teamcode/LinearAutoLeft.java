package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.framework.Color;
import org.firstinspires.ftc.teamcode.framework.Move;
@Autonomous(name = "red")
public class LinearAutoLeft extends LinearOpMode
{


    @Override
    public void runOpMode() {
        //get the motors
        DcMotor motor0 = hardwareMap.dcMotor.get("motor0");
        DcMotor motor1 = hardwareMap.dcMotor.get("motor1");
        DcMotor motor2 = hardwareMap.dcMotor.get("motor2");
        DcMotor arm = hardwareMap.dcMotor.get("motor4");
        DcMotor arm2 = hardwareMap.dcMotor.get("motor5");
        DcMotor motor3 = hardwareMap.dcMotor.get("motor3");
        //set break
        motor0.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor3.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        //servo for the arm
        Servo servo1 = hardwareMap.servo.get("servo1");
        //sensors
        ModernRoboticsI2cRangeSensor range0 = hardwareMap.get(ModernRoboticsI2cRangeSensor.class, "range0");
        ColorSensor colorSensor = hardwareMap.colorSensor.get("color1");
        //directions
        motor0.setDirection(DcMotorSimple.Direction.REVERSE);
        motor1.setDirection(DcMotorSimple.Direction.REVERSE);
        motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        motor3.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        //ensure position is correct
        //move to blocks
        new Move().left(motor0, motor1, motor2, motor3);
        sleep(2900);
        //start looking for block
        new Move().back(motor0, motor1, motor2, motor3);
        telemetry.addData("while is running", "");
        while (true) {
            //find the block
            boolean scan = new Color().colors(colorSensor, telemetry);
            if (scan) {
                telemetry.addData("is true", "");
                break;
            }
        }
        new Move().stop(motor0, motor1, motor2, motor3);
        sleep(2000);
        // find yellow
        new Move().back(motor0, motor1, motor2, motor3);
        telemetry.addData("while is running", "");
        while (true) {
            boolean scan = new Color().colors(colorSensor, telemetry);
            if (!scan) {
                telemetry.addData("is true", "");
                break;
            }
        }
        //move in and get the block
        sleep(400);
        new Move().spinOtherWay(motor0, motor1, motor2, motor3);
        sleep(25);
        new Move().left(motor0, motor1, motor2, motor3);
        sleep(1300);
        new Move().forward(motor0, motor1, motor2, motor3);
        sleep(700);
        new Move().stop(motor0, motor1, motor2, motor3);
        new Move().arm(0.0, servo1);
        sleep(2000);
        new Move().elevator(arm, arm2, 0.5);
        sleep(450);
        new Move().elevator(arm, arm2, 0.0);
        //move out with block
        new Move().right(motor0, motor1, motor2, motor3);
        sleep(2100);
        new Move().stop(motor0, motor1, motor2, motor3);
        new Move().forward(motor0, motor1, motor2, motor3);
        //look for over hang
        telemetry.addData("while is running", "");
        while (true) {
            boolean scan = range0.rawUltrasonic() < 40;
            if (scan) {
                telemetry.addData("is true", "");
                break;
            }
        }
        // place on the platform
        sleep(3000);
        new Move().back(motor0, motor1, motor2, motor3);
        new Move().arm(1.0, servo1);
        sleep(3000);
        new Move().stop(motor0, motor1, motor2, motor3);
    }
}
