package org.firstinspires.ftc.teamcode.framework;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Base framework for movement
 * Note I use per method motor params for flexibility reasons
 * */
public class Move {

    public void stop(DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3
      ){
        motor0.setPower(0.0);
        motor1.setPower(0.0);
        motor2.setPower(0.0);
        motor3.setPower(0.0);
    }
    // TODO add speed params
    public void forward(DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3
      ){
        motor0.setPower(0.5);
        motor1.setPower(0.5);
        motor2.setPower(-0.5);
        motor3.setPower(-0.5);
        //motor1.setPower(-1.0);
        //motor3.setPower(1.0);
        ;
    }
    public void spin(
          DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3
   ){
        motor0.setPower(0.5);
        motor1.setPower(0.5);
        motor2.setPower(0.5);
        motor3.setPower(0.5);
        //motor1.setPower(-1.0);
        //motor3.setPower(1.0);
        ;
    }
    public void spinOtherWay(
          DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3
   ){
        motor0.setPower(-0.5);
        motor1.setPower(-0.5);
        motor2.setPower(-0.5);
        motor3.setPower(-0.5);
        //motor1.setPower(-1.0);
        //motor3.setPower(1.0);
        ;
    }
    public void back(DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3
   ){
        motor0.setPower(-0.5);
        motor1.setPower(-0.5);
        motor2.setPower(0.5);
        motor3.setPower(0.5);
        //motor1.setPower(1.0);
        //motor3.setPower(-1.0);
    }
    public void right(DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3
   ){

        motor0.setPower(0.5);
        motor1.setPower(-0.5);
        motor2.setPower(-0.5);
        motor3.setPower(0.5);
        //motor0.setPower(1.0);
        //motor2.setPower(-1.0);
    }
    public void left(DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3
   ){
        motor0.setPower(-0.5);
        motor1.setPower(0.5);
        motor2.setPower(0.5);
        motor3.setPower(-0.5);
        //motor0.setPower(-1.0);
        //motor2.setPower(1.0);
    }


    public void forward(DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3,
          float speed
      ){
        motor0.setPower(speed);
        motor1.setPower(speed);
        motor2.setPower(-speed);
        motor3.setPower(-speed);
        //motor1.setPower(-1.0);
        //motor3.setPower(1.0);
        ;
    }
    public void spin(
          DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3,
          float speed

   ){
        motor0.setPower(speed);
        motor1.setPower(speed);
        motor2.setPower(speed);
        motor3.setPower(speed);
        //motor1.setPower(-1.0);
        //motor3.setPower(1.0);
        ;
    }
    public void spinOtherWay(
          DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3,
          float speed

   ){
        motor0.setPower(-speed);
        motor1.setPower(-speed);
        motor2.setPower(-speed);
        motor3.setPower(-speed);
        //motor1.setPower(-1.0);
        //motor3.setPower(1.0);
        ;
    }
    public void back(DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3,
          float speed

   ){
        motor0.setPower(-speed);
        motor1.setPower(-speed);
        motor2.setPower(speed);
        motor3.setPower(speed);
        //motor1.setPower(1.0);
        //motor3.setPower(-1.0);
    }
    public void right(DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3,
          float speed

   ){

        motor0.setPower(speed);
        motor1.setPower(-speed);
        motor2.setPower(-speed);
        motor3.setPower(speed);
        //motor0.setPower(1.0);
        //motor2.setPower(-1.0);
    }
    public void left(DcMotor motor0,
          DcMotor motor1,
          DcMotor motor2,
          DcMotor motor3,
          float speed

   ){
        motor0.setPower(-speed);
        motor1.setPower(speed);
        motor2.setPower(speed);
        motor3.setPower(-speed);
        //motor0.setPower(-1.0);
        //motor2.setPower(1.0);
    }

    public void crON(CRServo crServo, double power){
        crServo.setPower(power);
    }
    public void openClaw(CRServo servo0){
        servo0.setPower(-1.0);
    }
    public void closeClaw(CRServo servo0){
        servo0.setPower(1.0);
    }
    public void arm(double pos, Servo servo){
        servo.setPosition(pos);
    }
    public void elevator(DcMotor motor0,
      DcMotor motor1,
      Double speed
      ){
        motor0.setPower(speed);
        motor1.setPower(speed);
    }
}
