package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.framework.Move;

@TeleOp(name = "2020main")
public class OpMode extends com.qualcomm.robotcore.eventloop.opmode.OpMode {
    private DcMotor motor0, motor1, motor2, motor3, motor4;
    CRServo crServo0;
    private Gamepad num1, num2;

    @Override
    public void init() {
        motor0 = hardwareMap.dcMotor.get("motor0");
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
        motor3 = hardwareMap.dcMotor.get("motor4");
        motor1.setDirection(DcMotor.Direction.REVERSE);
        motor2.setDirection(DcMotor.Direction.REVERSE);




    }

    @Override
    public void loop() {
        motor0 = hardwareMap.dcMotor.get("motor0");
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");

        if (!(gamepad1.left_stick_y == 0)) {
            motor1.setPower(gamepad1.left_stick_y);
            motor3.setPower(gamepad1.left_stick_y);
        }
        else if (gamepad1.left_stick_x > 0.1 || gamepad1.left_stick_x < -0.1){
            motor0.setPower(gamepad1.left_stick_x);
            motor2.setPower(gamepad1.left_stick_x);
        }
       else  if (gamepad1.right_stick_x > 0.1 || gamepad1.right_stick_x < -0.1){
            motor0.setPower(gamepad1.right_stick_x);
            motor1.setPower(gamepad1.right_stick_x);
            motor2.setPower(gamepad1.right_stick_x);
            motor3.setPower(gamepad1.right_stick_x);
        }
        else new Move().stop(motor0,motor1,motor2, motor3);

        if(gamepad1.a){
            new Move().movePlate(motor4, 1.0);
        }
        if(gamepad1.b){
            new Move().movePlate(motor4, -1.0);
        }

        else new Move().StopCrServo(motor4);
        if (gamepad1.x) new Move().crON(crServo0, 1.0);
        else if(gamepad1.y) new Move().crON(crServo0, -1.0);
        else new Move().crON(crServo0, 0.0);
    }
}
