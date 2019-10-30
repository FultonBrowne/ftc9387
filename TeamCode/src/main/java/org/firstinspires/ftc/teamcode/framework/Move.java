package org.firstinspires.ftc.teamcode.framework;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class Move {

    public void stop(DcMotor motor0, DcMotor motor1, DcMotor motor2, DcMotor motor3){
        motor0.setPower(0.0);
        motor1.setPower(0.0);
        motor2.setPower(0.0);
        motor3.setPower(0.0);
    }
    public void forward(DcMotor motor0, DcMotor motor1, DcMotor motor2, DcMotor motor3){
        motor0.setPower(-0.5d);
        motor1.setPower(0.5d);
        motor2.setPower(0.5d);
        motor3.setPower(-0.5d);;
    }
    public void back(DcMotor motor0, DcMotor motor1, DcMotor motor2, DcMotor motor3){
        motor0.setPower(0.0);
        motor1.setPower(-0.5);
        motor2.setPower(-0.5);
        motor3.setPower(0.0);
    }
    public void right(DcMotor motor0, DcMotor motor1, DcMotor motor2, DcMotor motor3){
        motor0.setPower(-0.5d);
        motor1.setPower(-0.5d);
        motor2.setPower(0.5d);
        motor3.setPower(0.5d);
    }
    public void left(DcMotor motor0, DcMotor motor1, DcMotor motor2, DcMotor motor3){
        motor0.setPower(0.0);
        motor1.setPower(0.0);
        motor2.setPower(-0.5);
        motor3.setPower(-0.5);
    }
    public void setServoPos(Servo servo,Double pos){
        servo.setPosition(pos);
    }
}
