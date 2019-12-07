package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.modernrobotics.ModernRoboticsI2cRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.I2cAddr;
import com.qualcomm.robotcore.hardware.I2cDevice;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchImpl;
import com.qualcomm.robotcore.hardware.UltrasonicSensor;

import org.firstinspires.ftc.teamcode.framework.Color;
import org.firstinspires.ftc.teamcode.framework.Move;

import java.util.Timer;
import java.util.TimerTask;
@Autonomous(name = "Cube right")
public class CubeAutoRight extends OpMode {
    private DcMotor motor0, motor1, motor2, motor3;
    private Timer time;
    private ColorSensor colorSensor;
    byte[] range1Cache; //The read will return an array of bytes. They are stored in this variable
    I2cAddr RANGE1ADDRESS = new I2cAddr(0x14); //Default I2C address for MR Range (7-bit)
    public static final int RANGE1_REG_START = 0x04; //Register to start reading
    public static final int RANGE1_READ_LENGTH = 2; //Number of byte to read

    public ModernRoboticsI2cRangeSensor range0;
    public I2cDeviceSynch RANGE1Reader;

    private TimerTask initMove, stop1, search, stop2, spin, hitBlock,moveABit, stop3, moveOut, moveIn, hold, letGo, moveATiny, underBridge, forward0, back0, stop4, stop5, forward1;

    @Override
    public void init() {
        motor0 = hardwareMap.dcMotor.get("motor0");
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
        range0 = hardwareMap.get( ModernRoboticsI2cRangeSensor.class,"range0");
        colorSensor = hardwareMap.colorSensor.get("color0");
        motor0.setDirection(DcMotorSimple.Direction.REVERSE);
        motor1.setDirection(DcMotorSimple.Direction.REVERSE);
        motor2.setDirection(DcMotorSimple.Direction.REVERSE);
        motor3.setDirection(DcMotorSimple.Direction.REVERSE);

        time = new Timer();
        declareTimerTasks();
    }

    @Override
    public void loop() {

    }

    private void declareTimerTasks() {
        stop5  = new TimerTask() {
            @Override
            public void run() {
                new Move().stop(motor0, motor1, motor2, motor3);
            }
        };
       forward0  = new TimerTask() {
            @Override
            public void run() {
                new Move().forward(motor0, motor1, motor2, motor3);
            }
        };
        forward1  = new TimerTask() {
            @Override
            public void run() {
                new Move().forward(motor0, motor1, motor2, motor3);
            }
        };
        back0  = new TimerTask() {
            @Override
            public void run() {
                new Move().back(motor0, motor1, motor2, motor3);
            }
        };
        moveOut = new TimerTask() {
            @Override
            public void run() {
                new Move().left(motor0, motor1, motor2, motor3);
            }
        };
        moveIn = new TimerTask() {
            @Override
            public void run() {
                new Move().forward(motor0, motor1, motor2, motor3);
            }
        };
        hold = new TimerTask() {
            @Override
            public void run() {
                new Move().stop(motor0, motor1, motor2, motor3);
            }
        };
        letGo = new TimerTask() {
            @Override
            public void run() {
                new Move().stop(motor0, motor1, motor2, motor3);
            }
        };
        moveATiny= new TimerTask() {
            @Override
            public void run() {
                new Move().back(motor0, motor1, motor2, motor3);
            }
        };




        initMove = new TimerTask() {
            @Override
            public void run() {
                new Move().right(motor0, motor1, motor2, motor3);
            }
        };
        moveABit = new TimerTask() {
            @Override
            public void run() {
                Boolean foundColor = false;
                new Move().back(motor0, motor1, motor2, motor3);
                telemetry.addData("while is running", "");
                while (true) {
                    boolean scan = new Color().colors(colorSensor, telemetry);
                    foundColor = scan;
                    if (!scan) {
                        telemetry.addData("is true", "");
                        break;
                    }
                }
                new Move().stop(motor0, motor1, motor2,motor3);
            }
        };
        underBridge= new TimerTask() {
            @Override
            public void run() {
                Boolean foundColor = false;
                new Move().forward(motor0, motor1, motor2, motor3);
                telemetry.addData("while is running", "");
                while (true) {
                    boolean scan = range0.rawUltrasonic() < 40;
                    foundColor = scan;
                    if (scan) {
                        telemetry.addData("is true", "");
                        break;
                    }
                }
                new Move().stop(motor0, motor1, motor2,motor3);
            }
        };
        spin= new TimerTask() {
            @Override
            public void run() {
                new Move().spinOtherWay(motor0,motor1, motor2, motor3);
            }
        };
        hitBlock= new TimerTask() {
            @Override
            public void run() {
                new Move().right(motor0, motor1, motor2, motor3);
            }
        };
        stop1 = new TimerTask() {
            @Override
            public void run() {
                new Move().stop(motor0, motor1, motor2, motor3);
            }
        };
        stop2 = new TimerTask() {
            @Override
            public void run() {
                new Move().stop(motor0, motor1, motor2, motor3);
            }
        };
        search = new TimerTask() {
            @Override
            public void run() {

                new Move().back(motor0, motor1, motor2, motor3);
                telemetry.addData("while is running", "");
                while (true) {
                    boolean scan = new Color().colors(colorSensor, telemetry);
                    if (scan) {
                        telemetry.addData("is true", "");
                        break;
                    }
                }
                new Move().stop(motor0, motor1, motor2,motor3);


            }
        };
        stop3 = new TimerTask() {
            @Override
            public void run() {
                new Move().stop(motor0, motor1, motor2, motor3);
            }
        };
        stop4 = new TimerTask() {
            @Override
            public void run() {
                new Move().stop(motor0, motor1, motor2, motor3);
            }
        };
    }
    public void start(){
        time.schedule(initMove, 0);
        time.schedule(stop1, 2700);
        time.schedule(search, 2701);
        time.schedule(stop2, 7000);
        time.schedule(spin, 7075);
        time.schedule(moveABit, 7100);
        time.schedule(moveATiny, 9500);
        time.schedule(hitBlock, 10000);
        time.schedule(forward1, 11000);
        time.schedule(hold, 11800);
        time.schedule(moveOut, 14200);
        time.schedule(underBridge,16000);
        time.schedule(stop5, 22400);
        time.schedule(forward0, 22500);
        time.schedule(letGo, 23500);
        time.schedule(back0,25700);
        time.schedule(stop4, 26700);
    }


}
