package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.framework.Color;
import org.firstinspires.ftc.teamcode.framework.Move;

@Autonomous(name = "red")

public class LinearAutoRight extends LinearOpMode{
    private ElapsedTime runtime = new ElapsedTime();

    public ModernRoboticsI2cRangeSensor range0;
    public Servo servo1;


    @Override
    public void runOpMode() throws InterruptedException {
        DcMotor motor0 = hardwareMap.dcMotor.get("motor0");
        DcMotor motor1 = hardwareMap.dcMotor.get("motor1");
        DcMotor motor2 = hardwareMap.dcMotor.get("motor2");
        DcMotor motor3 = hardwareMap.dcMotor.get("motor3");
        motor0.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motor3.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        servo1 = hardwareMap.servo.get("servo1");
        range0 = hardwareMap.get( ModernRoboticsI2cRangeSensor.class,"range0");
        ColorSensor colorSensor = hardwareMap.colorSensor.get("color0");
        motor0.setDirection(DcMotorSimple.Direction.REVERSE);
        motor1.setDirection(DcMotorSimple.Direction.REVERSE);
        motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        motor3.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        servo1.setPosition(1.0);
        new Move().right(motor0, motor1, motor2, motor3);
        sleep(2700);
        new Move().back(motor0, motor1, motor2, motor3);
        telemetry.addData("while is running", "");
        while (true) {
            boolean scan = new Color().colors(colorSensor, telemetry);
            if (scan) {
                telemetry.addData("is true", "");
                break;
            }
        }
        new Move().stop(motor0, motor1, motor2, motor3);
        sleep(2000);
        new Move().back(motor0, motor1, motor2, motor3);
        telemetry.addData("while is running", "");
        while (true) {
            boolean scan = new Color().colors(colorSensor, telemetry);
            if (!scan) {
                telemetry.addData("is true", "");
                break;
            }
        }
        sleep(540);
        new Move().spinOtherWay(motor0, motor1, motor2, motor3);
        sleep(25);
        new Move().right(motor0, motor1, motor2, motor3);
        sleep(1000);
        new Move().forward(motor0, motor1, motor2, motor3);
        sleep(700);
        new Move().stop(motor0, motor1, motor2, motor3);
        new Move().arm(0.0, servo1);
        sleep(2000);
        new Move().left(motor0, motor1, motor2, motor3);
        sleep(1800);
        new Move().stop(motor0, motor1, motor2, motor3);
        new Move().forward(motor0, motor1, motor2, motor3);
        telemetry.addData("while is running", "");
        while (true) {
            boolean scan = range0.rawUltrasonic() < 40;
            if (scan) {
                telemetry.addData("is true", "");
                break;
            }
        }
        sleep(2000);
        new Move().back(motor0, motor1, motor2, motor3);
        new Move().arm(1.0, servo1);
        sleep(2000);
        new Move().stop(motor0, motor1, motor2, motor3);





    }
}
