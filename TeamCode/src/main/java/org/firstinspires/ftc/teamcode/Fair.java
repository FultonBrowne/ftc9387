package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import java.util.TimerTask;
import java.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;


@Autonomous

public class Fair extends OpMode {
 public DcMotor motor0, motor1, motor2, motor3, motor4;
 public TimerTask spin;
 public Timer time;
 public void init(){
        motor0 = hardwareMap.dcMotor.get("motor0");
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
        //motor4 = hardwareMap.dcMotor.get("motor4");
       // servo0 = hardwareMap.servo.get("servo0");
        
        
        time = new Timer();
        time1();
        }
        
            public void start(){
        scheduleAutonomous();
    }
    
    public void loop(){
    }
    public void time1(){
       TimerTask spin = new TimerTask(){
           public void run(){
               motor0.setPower(1.0);
               motor1.setPower(1.0);
               motor3.setPower(1.0);
               motor2.setPower(1.0);
               
               
           }
       }
    ;}
    public void scheduleAutonomous(){
        //REMBER TO DECLAIR @ TOP
        time.schedule(spin, 1);
        }

    // todo: write your code here
}
