package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import java.util.TimerTask;
import java.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;

@Autonomous (name="pit", group="Autonomous")
@Disabled
public class TimePitSide extends OpMode {
 public DcMotor motor0, motor1, motor2, motor3, motor4;
    public Servo servo0;
    public TimerTask moveArm, moveArm1, moveBack, stop, stop1, stop2, move, rotate, dumpjim,jimarmup;
    public Timer time;
    
        public void init(){
        motor0 = hardwareMap.dcMotor.get("motor0");
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
        motor4 = hardwareMap.dcMotor.get("motor4");
        servo0 = hardwareMap.servo.get("servo0");
        
        
        time = new Timer();
        declareTimerTasks();
        }
        
            public void start(){
        scheduleAutonomous();
    }
    
    public void loop(){
    }
    
public void declareTimerTasks(){
        moveArm = new TimerTask(){
          public void run(){
              motor4.setPower(0.0d);
          }
      };
      moveArm1 = new TimerTask(){
          public void run(){
              motor4.setPower(0.5d);
          }
      };
      stop = new TimerTask(){
          public void run(){
              motor0.setPower(0.0d);
              motor1.setPower(0.0d);
              motor2.setPower(0.0d);
              motor3.setPower(0.0d);
          }
      };
      moveBack = new TimerTask(){
          public void run(){
              motor0.setPower(-0.5d);
              motor1.setPower(-0.5d);
              motor2.setPower(0.5d);
              motor3.setPower(0.5d);
          }
      };
      stop1 = new TimerTask(){
          public void run(){
              motor0.setPower(0.0d);
              motor1.setPower(0.0d);
              motor2.setPower(0.0d);
              motor3.setPower(0.0d);
          }
      };
      move = new TimerTask(){
          public void run(){
              motor0.setPower(-1.0d);
              motor1.setPower(1.0d);
              motor2.setPower(1.0d);
              motor3.setPower(-1.0d);
          }
      };
}
      public void scheduleAutonomous(){
        //REMBER TO DECLAIR @ TOP
        time.schedule(moveArm1, 1);
        //FLEX TAPE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        time.schedule(moveArm, 6999);
        time.schedule(moveBack, 7000);
        time.schedule(stop,7500 );
        time.schedule(move,7501 );
        time.schedule(stop1,15500 );
        
         
        
        
      
    
    
    


}    
}
