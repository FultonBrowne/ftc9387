package org.firstinspires.ftc.teamcode.framework;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

import org.jetbrains.annotations.Nullable;

public class Move {

    public void stop(DcMotor motor0, DcMotor motor1, DcMotor motor2, DcMotor motor3){
        motor0.setPower(0.0);
        motor1.setPower(0.0);
        motor2.setPower(0.0);
        motor3.setPower(0.0);
    }
    public void forward(DcMotor motor0, DcMotor motor1, DcMotor motor2, DcMotor motor3){
        motor0.setPower(-0.5);
        motor1.setPower(0.5);
        motor2.setPower(-0.5);
        motor3.setPower(0.5);
    }
    public void back(DcMotor motor0, DcMotor motor1, DcMotor motor2, DcMotor motor3){
        motor0.setPower(0.5);
        motor1.setPower(-0.5);
        motor2.setPower(0.5);
        motor3.setPower(-0.5);
    }
    public void right(DcMotor motor0, DcMotor motor1, DcMotor motor2, DcMotor motor3){

        motor0.setPower(0.5);
        motor1.setPower(-0.5);
        motor2.setPower(0.5);
        motor3.setPower(-0.5);
    }
    public void left(DcMotor motor0, DcMotor motor1, DcMotor motor2, DcMotor motor3){

        motor0.setPower(-0.5);
        motor1.setPower(0.5);
        motor2.setPower(-0.5);
        motor3.setPower(0.5);
    }
    public void setServoPos(Servo servo,Double pos){
        servo.setPosition(pos);
    }
    public void movePlate(DcMotor crServo, Double speed){
        crServo.setPower(speed);
    }
    public void crON(CRServo crServo, double power){
        crServo.setPower(power);
    }
    public void stopPlate(DcMotor crServo){
        crServo.setPower(0.0);
    }
}
