/**
 *
 * Created by Maddie, FTC Team 4962, The Rockettes
 * version 1.0 Aug 11, 2016
 *
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.robot.Robot;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;


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
@TeleOp(name = "RR_tele_op_2018", group = "Concept")
//@Disabled
public class ConceptHolonomicDrive extends OpMode {

    DcMotor motorFrontRight;
    DcMotor motorFrontLeft;
    DcMotor motorBackRight;
    DcMotor motorBackLeft;
   // DcMotor motorMotorarm;
    //DcMotor motorMotorRealarm;
    CRServo servo1;
    Servo servo0;

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
        motorFrontLeft = hardwareMap.dcMotor.get("motor0");
        motorBackLeft = hardwareMap.dcMotor.get("motor1");
        motorBackRight = hardwareMap.dcMotor.get("motor2");
        //motorMotorarm = hardwareMap.dcMotor.get("motor4");
        //motorMotorRealarm = hardwareMap.dcMotor.get("motor5");
        servo1 = hardwareMap.crservo.get("servo1");
        servo0 = hardwareMap.servo.get ("servo0");
        
        //These work without reversing (Tetrix motors).
        //AndyMark motors may be opposite, in which case uncomment these lines:
        motorFrontLeft.setDirection(DcMotor.Direction.REVERSE);
        motorBackLeft.setDirection(DcMotor.Direction.REVERSE);
        motorFrontRight.setDirection(DcMotor.Direction.REVERSE);
        motorBackRight.setDirection(DcMotor.Direction.REVERSE);

    }

    @Override
    public void loop() {


        // left stick controls direction
        // right stick X controls rotation

        float gamepad1LeftY = -gamepad1.left_stick_y;
        float gamepad1LeftX = gamepad1.left_stick_x;
        float gamepad1RightX = gamepad1.right_stick_x;
        float gamepad2LeftX = gamepad2.left_stick_x;
        float gamepad2LeftY = gamepad2.left_stick_y;
        float gamepad2RightY = gamepad2.right_stick_y;
        float gamepad2RightX = gamepad2.right_stick_x;
        float gamepad2RightTr = gamepad2.right_trigger;
        float gamepad2LeftTr = gamepad2.left_trigger;
        boolean gamepad2a = gamepad2.a;
        boolean gamepad2b = gamepad2.b;
        boolean gamepad2x = gamepad2.x;
        boolean gamepad2y = gamepad2.y;
        boolean gamepad2Dpad_Up = gamepad2.dpad_up;
        boolean gamepad2DpadDown = gamepad2.dpad_down;
        boolean gamepad2DpadLeft = gamepad2.dpad_right;
        boolean gamepad2DpadRight = gamepad2.dpad_left;
        


        // holonomic formulas

        float FrontLeft = -gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        float FrontRight = gamepad1LeftY - gamepad1LeftX - gamepad1RightX;
        float BackRight = gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
        float BackLeft = -gamepad1LeftY + gamepad1LeftX - gamepad1RightX;
       // float motorRealarm = gamepad2RightX;
        //float motorarm = ;
        
        if (gamepad2.dpad_up){
           //motorMotorarm.setPower(1.0);
            
            
        }
        if (gamepad2.dpad_down){
            //motorMotorarm.setPower(-1.0);
            
            
        }
        if (gamepad2.dpad_down==false && gamepad2.dpad_up==false){
            //motorMotorarm.setPower(0.0);
            
            
        }
        // test new drive
        /*if (gamepad1.dpad_down == false && gamepad1.dpad_left == false && gamepad1.dpad_right == false && gamepad1.dpad_up == false){
            motorBackLeft.setPower(0.0);
            motorBackRight.setPower(0.0);
            motorFrontLeft.setPower(0.0);
            motorFrontRight.setPower(0.0);
            
            
            
        }
        if (gamepad1.dpad_up == true){
            motorBackLeft.setPower(1.0);
            motorBackRight.setPower(-1.0);
            motorFrontLeft.setPower(1.0);
            motorFrontRight.setPower(-1.0);
        }*/
       
        // end test new drive
        if (gamepad1.left_bumper){
        servo1.setPower(0.0);
        
        
        }
        if (gamepad1.right_bumper){
            servo1.setPower(1.0);
            ;
            
        }

        if (gamepad2.dpad_left){
          // motorMotorRealarm.setPower(1.0);
            
            
        }
        
        
        
        if (gamepad2.dpad_right){
           //motorMotorRealarm.setPower(-1.0);
            
            
        }
        if (gamepad2.dpad_left==false && gamepad2.dpad_right==false){
            //motorMotorRealarm.setPower(0.0);
            
            
        }
        if (gamepad2.x){
             //servo1.setPower(1.0);
        }
        if (gamepad2.b){
            // servo1.setPower(-1.0);
             
             
        }
         if (gamepad2.b==false && gamepad2.x==false){
            //servo1.setPower(0.0);
         }
        

        // clip the right/left values so that the values never exceed +/- 1
        FrontRight = Range.clip(FrontRight, -1, 1);
        FrontLeft = Range.clip(FrontLeft, -1, 1);
        BackLeft = Range.clip(BackLeft, -1, 1);
        BackRight = Range.clip(BackRight, -1, 1);
        //motorarm = Range.clip(motorarm, -1, 1);
        //motorRealarm = Range.clip(motorRealarm, -1, 1);
        
        
        //boolean part
        // write the values to the motors
        motorFrontRight.setPower(FrontRight);
        motorFrontLeft.setPower(FrontLeft);
        motorBackLeft.setPower(BackLeft);
        motorBackRight.setPower(BackRight);
        //motorMotorarm.setPower(motorarm);
       // motorMotorRealarm.setPower(motorRealarm);
        



        /*
         * Telemetry for debugging
         */
        telemetry.addData("Text", "*** Robot Data***");
        telemetry.addData("Joy XL YL XR",  String.format("%.2f", gamepad1LeftX) + " " +
                String.format("%.2f", gamepad1LeftY) + " " +  String.format("%.2f", gamepad1RightX));
        telemetry.addData("f left pwr",  "front left  pwr: " + String.format("%.2f", FrontLeft));
        telemetry.addData("f right pwr", "front right pwr: " + String.format("%.2f", FrontRight));
        telemetry.addData("b right pwr", "back right pwr: " + String.format("%.2f", BackRight));
        telemetry.addData("b left pwr", "back left pwr: " + String.format("%.2f", BackLeft));
        

    }

    @Override
    public void stop() {

    }

    /*
     * This method scales the joystick input so for low joystick values, the
     * scaled value is less than linear.  This is to make it easier to drive
     * the robot more precisely at slower speeds.
     */
    double scaleInput(double dVal)  {
        double[] scaleArray = { 0.0, 0.05, 0.09, 0.10, 0.12, 0.15, 0.18, 0.24,
                0.30, 0.36, 0.43, 0.50, 0.60, 0.72, 0.85, 1.00, 1.00 };

        // get the corresponding index for the scaleInput array.
        int index = (int) (dVal * 16.0);

        // index should be positive.
        if (index < 0) {
            index = -index;
        }

        // index cannot exceed size of array minus 1.
        if (index > 16) {
            index = 16;
        }

        // get value from the array.
        double dScale = 0.0;
        if (dVal < 0) {
            dScale = -scaleArray[index];
        } else {
            dScale = scaleArray[index];
        }

        // return scaled value.
        return dScale;
    }

}
