package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.DcMotor;


@Autonomous(name="Autonomous_Mode", group="Linear Opmode")
@Disabled

public class Autonomous1 extends LinearOpMode {
    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor leftDrive = null;
    private DcMotor rightDrive = null;
    
    @Override
    public void runOpMode() {
    
        leftDrive  = hardwareMap.get(DcMotor.class, "left_drive");
        rightDrive = hardwareMap.get(DcMotor.class, "right_drive");
        
        waitForStart();
        runtime.reset();
        
        leftDrive.setPower(1.0);
        rightDrive.setPower(-1.0);
        
        while (runtime.time() < 1){}
        
            leftDrive.setPower(0.0);
            rightDrive.setPower(0.0);

    }
    // todo: write your code here
}
