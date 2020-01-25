/*
 *
 * Created by Maddie, FTC Team 4962, The Rockettes
 * version 1.0 Aug 11, 2016
 *
 */

package org.firstinspires.ftc.teamcode;

import android.annotation.SuppressLint;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.teamcode.framework.Color;
import org.firstinspires.ftc.teamcode.framework.Move;


/*
    Holonomic concepts from:
    http://www.vexforum.com/index.php/12370-holonomic-drives-2-0-a-video-tutorial-by-cody/0
   Robot wheel mapping:
          X FRONT X
        X           X
      X  FL       FR  X
              X
             XXX
              X
      X  BL       BR  X
        X           X
          X       X
*/
@TeleOp(name = "test and backup system", group = "LCARS 47")
//@Disabled
public class ConceptHolonomicDrive extends OpMode {

    private DcMotor motorFrontRight;
    private DcMotor motorFrontLeft;
    private DcMotor motorBackRight;
    private DcMotor motorBackLeft;
    private DcMotor arm2;
    private DcMotor arm;
    Servo release;
    private TouchSensor touch1;
    private ColorSensor color0;
    private Servo claw;

    /**
     * Constructor
     */
    public ConceptHolonomicDrive() {

    }

    @Override
    public void init() {


        /*
         * Use the hardwareMap to get the dc motors and servos by name. Note
         * that the names of the devices must match the names used when you
         * configured your robot and created the configuration file.
         */


        motorFrontRight = hardwareMap.dcMotor.get("motor3");
        motorFrontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorFrontLeft = hardwareMap.dcMotor.get("motor0");
        motorFrontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        motorFrontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        motorFrontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBackLeft = hardwareMap.dcMotor.get("motor1");
        motorBackLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        motorBackRight = hardwareMap.dcMotor.get("motor2");
        motorBackRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        color0 = hardwareMap.colorSensor.get("color0");
        arm = hardwareMap.dcMotor.get("motor4");
        arm2 = hardwareMap.dcMotor.get("motor5");
        release = hardwareMap.servo.get("servo2");
        arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        arm2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        claw = hardwareMap.servo.get("servo1");
        touch1 = hardwareMap.touchSensor.get("touch0");


    }

    @SuppressLint("DefaultLocale")
    @Override
    public void loop() {
        // formula for motor values
        float gamepad1LeftY = -gamepad1.left_stick_y;
        float gamepad1LeftX = gamepad1.left_stick_x;
        float gamepad1RightX = gamepad1.right_stick_x;
        float FrontLeft = -gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        float FrontRight = gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        float BackRight = gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
        float BackLeft = -gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
        // move the claw in and out
        if ((gamepad2.left_bumper))  new Move().arm(1.0, claw);
        else if (gamepad2.right_bumper) new Move().arm(0.0, claw);
        //move the arm up and down
        if ((gamepad2.dpad_up))  new Move().elevator(arm, arm2, 1.0);
        else if (gamepad2.dpad_down && !touch1.isPressed()) new Move().elevator(arm, arm2, -1.0);
        else  new Move().elevator(arm, arm2, 0.0);
        if(gamepad2.y) release.setPosition(1.0);
        if(gamepad2.x) release.setPosition(0.0);
        //set powers
        motorFrontRight.setPower(FrontRight);
        motorFrontLeft.setPower(FrontLeft);
        motorBackLeft.setPower(BackLeft);
        motorBackRight.setPower(BackRight);

        /*
         * Telemetry for debugging
         */
        telemetry.addData("", motorFrontLeft.getCurrentPosition());
        telemetry.addData("", motorBackLeft.getCurrentPosition());
        telemetry.addData(String.valueOf(touch1.isPressed()), "");
        telemetry.addData("Text", "*** Robot Data***");
        telemetry.addData("Joy XL YL XR",  String.format("%.2f", gamepad1LeftX) + " " +
                String.format("%.2f", gamepad1LeftY) + " " +  String.format("%.2f", gamepad1RightX));
        telemetry.addData("f left pwr",  "front left  pwr: " + String.format("%.2f", FrontLeft));
        telemetry.addData("f right pwr", "front right pwr: " + String.format("%.2f", FrontRight));
        telemetry.addData("b right pwr", "back right pwr: " + String.format("%.2f", BackRight));
        telemetry.addData("b left pwr", "back left pwr: " + String.format("%.2f", BackLeft));
        new Color().colors(color0, telemetry);
        

    }

    @Override
    public void stop() {

    }



}
