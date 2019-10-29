package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.framework.Move;

@TeleOp(name = "2020main")
public class OpMode extends com.qualcomm.robotcore.eventloop.opmode.OpMode {
    private DcMotor motor0, motor1, motor2, motor3, motor4;
    private Gamepad num1, num2;

    @Override
    public void init() {
        motor0 = hardwareMap.dcMotor.get("motor0");
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
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
        if (gamepad1.left_stick_x > 0.1 || gamepad1.left_stick_x < -0.1){
            motor0.setPower(gamepad1.left_stick_x);
            motor2.setPower(gamepad1.left_stick_x);
        }
        else new Move().stop(motor0,motor1,motor2, motor3);
    }
}
