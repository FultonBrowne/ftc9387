package org.firstinspires.ftc.teamcode.framework;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@Autonomous(name = "basic")
public class BasicAuto extends LinearOpMode {
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
        motor0.setDirection(DcMotorSimple.Direction.REVERSE);
        motor1.setDirection(DcMotorSimple.Direction.REVERSE);
        motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        motor3.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        //move claw in correct position//move to blocks
        new Move().back(motor0, motor1, motor2, motor3);
        sleep(200);
        new Move().stop(motor0, motor1, motor2, motor3);
    }
}
