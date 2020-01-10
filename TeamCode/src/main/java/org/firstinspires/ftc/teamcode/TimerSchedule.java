// thx team 6559!!!!!!!!!!!!
//DO NOT REMOVE
package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.TouchSensor;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import java.util.Set;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import java.util.Timer;
import java.util.TimerTask;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.CRServo;
import java.util.concurrent.TimeUnit;
import android.app.Activity;
import android.view.View;
import android.graphics.Color;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.SwitchableLight;
import com.qualcomm.robotcore.hardware.I2cDevice;



@Autonomous (name="depo", group="Autonomous")
@Disabled

public class TimerSchedule extends OpMode {

    public DcMotor motor0, motor1, motor2, motor3, motor4;
    public Servo servo0, servo2;
    public TimerTask moveArm, sample, moveArm1, moveBack, stop, stop1, stop2, move, rotate, dumpjim,jimarmup,sample2;
    public Timer time;
    public ColorSensor color1;
    int red, green, blue;
    boolean paddle;
    public DigitalChannel touch1;
    
     float hsvValues[] = {0F,0F,0F};


    public void init(){
        motor0 = hardwareMap.dcMotor.get("motor0");
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
        motor4 = hardwareMap.dcMotor.get("motor4");
        servo2 = hardwareMap.servo.get("servo2");
        color1 = hardwareMap.get(ColorSensor.class, "color1");
        //touch1 =  hardwareMap.touchSensor.get("touch1");
        touch1 = hardwareMap.get(DigitalChannel.class, "touch1");
        
    
        time = new Timer();
        declareTimerTasks();
        //touch1.setMode(DigitalChannel.Mode.INPUT);
    }
    
    public void colors () { 


int red  =  color1.red(); 

int green = color1.green(); 

int blue = color1.blue(); 

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
      sample = new TimerTask(){
    
          public void run(){
           
            telemetry.addData("hi",color1.red() );
            telemetry.addData("hi",color1.green() );
            if (color1.blue() > 10 && color1.blue() < 40 && color1.alpha() < 15 ){
                motor0.setPower(0.0);
                motor1.setPower(0.0);
                motor2.setPower(0.0);
                motor3.setPower(0.0);
            }
            else {
                motor0.setPower(1.0);
                motor1.setPower(1.0);
                motor2.setPower(1.0);
                motor3.setPower(1.0);
                
            }



}} ;
sample2 = new TimerTask(){
    
          public void run(){
           servo2.setPosition(90);
           if (touch1.getState() == true){
                motor0.setPower(0.5);
                motor1.setPower(0.5);
                motor2.setPower(0.5);
                motor3.setPower(0.5);
                boolean paddle = false;
                servo2.setPosition(0);


                
            }
            
        
            else {
                motor0.setPower(0.0);
                motor1.setPower(0.0);
                motor2.setPower(0.0);
                motor3.setPower(0.0);
                boolean paddle = true;
                servo2.setPosition(0);
                
            }
            if (paddle == false ){
                servo2.setPosition(90);
                if (touch1.getState() == true){
                motor0.setPower(0.5);
                motor1.setPower(0.5);
                motor2.setPower(0.5);
                motor3.setPower(0.5); 
                 servo2.setPosition(0);   
                }
                else{
                motor0.setPower(0.0);
                motor1.setPower(0.0);
                motor2.setPower(0.0);
                motor3.setPower(0.0);
                servo2.setPosition(0);
                    
                }
                
            }

}


        


        

          }
          //commet here
      ;

      stop1 = new TimerTask(){
          public void run(){
              motor0.setPower(0.0d);
              motor1.setPower(0.0d);
              motor2.setPower(0.0d);
              motor3.setPower(0.0d);
          }
      };
      stop2 = new TimerTask(){
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
      dumpjim = new TimerTask(){
          public void run(){
              servo0.setPosition(90);
              
          }
      };
      jimarmup = new TimerTask(){
          public void run(){
              servo0.setPosition(0);
              
          }
      };
      rotate = new TimerTask(){
          public void run(){
              motor0.setPower(0.5d);
              motor1.setPower(0.5d);
              motor2.setPower(0.5d);
              motor3.setPower(0.5d);
          }
      };
      move = new TimerTask(){
          public void run(){
              motor0.setPower(-0.5d);
              motor1.setPower(0.5d);
              motor2.setPower(0.5d);
              motor3.setPower(-0.5d);
          }
      };
      
    }

      
    
    public void scheduleAutonomous(){
        //REMBER TO DECLAIR @ TOP
        time.schedule(moveArm1, 1); 
        //FLEX TAPE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        time.schedule(moveArm, 6999);
        time.schedule(moveBack, 7000);
        time.schedule(stop, 7500);
        time.schedule(move, 7501);
        time.schedule(stop1, 11000);
        time.schedule(rotate, 11001);
        time.schedule(stop2, 13500);
        time.schedule(dumpjim, 14510);
        time.schedule(jimarmup, 15510);
         //time.schedule(sample2, 15511);
        

        
        
       
    }
    
}
