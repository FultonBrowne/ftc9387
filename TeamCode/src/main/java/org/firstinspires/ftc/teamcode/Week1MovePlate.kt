package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.hardware.CRServo
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.Servo
import org.firstinspires.ftc.teamcode.framework.Move
import java.util.*

@Autonomous(name = "move da plate")
class Week1MovePlate: OpMode() {
    private var motor0: DcMotor? = null; private  var motor1:DcMotor? = null;
    private  var motor2:DcMotor? = null
    private  var motor3:DcMotor? = null
    private  var motor4:DcMotor? = null
    var servo0:CRServo? = null
     var time1: Timer? = null
    private var initMove: TimerTask? = null
    private  var stop1:TimerTask? = null
    private var forward:TimerTask? = null
    private var back:TimerTask? = null
    private var servo:TimerTask? = null
    private var servoStop:TimerTask? = null
    private var stop2:TimerTask? = null
    private var back2:TimerTask? = null
    override fun init() {
        super.init()
        motor0 = hardwareMap.dcMotor["motor0"]
        motor1 = hardwareMap.dcMotor["motor1"]
        motor2 = hardwareMap.dcMotor["motor2"]
        motor3 = hardwareMap.dcMotor["motor3"]
        servo0 = hardwareMap.crservo["servo0"]
        time1 = Timer()
        declareTimerTasks()


    }
    private fun declareTimerTasks() {
        initMove = object : TimerTask() {
            override fun run() {
                Move().left(motor0, motor1, motor2, motor3)
            }
        }
        stop1 = object : TimerTask() {
            override fun run() {
                Move().stop(motor0, motor1, motor2, motor3)
            }
        }
        stop2 = object : TimerTask() {
            override fun run() {
                Move().stop(motor0, motor1, motor2, motor3)
            }
        }
        forward = object : TimerTask() {
            override fun run() {
                Move().forward(motor0,motor1,motor2,motor3)
            }
        }
        back = object : TimerTask() {
            override fun run() {
                Move().back(motor0, motor1, motor2, motor3)
            }
        }
        back2 = object : TimerTask() {
            override fun run() {
                Move().back(motor0, motor1, motor2, motor3)
            }
        }
        servo = object : TimerTask() {
            override fun run() {
                Move().moveCrServo(servo0)
            }
        }
        servoStop = object : TimerTask() {
            override fun run() {
                Move().StopCrServo(servo0)
            }
        }
    }
    override fun loop() {

    }
    override fun start() {

        time1?.schedule(initMove, 0)
        time1?.schedule(stop1, 1000)
        time1?.schedule(forward, 1001)
        time1?.schedule(stop2, 5000)
        time1?.schedule(servo, 6000)
        time1?.schedule(servoStop,7000)
        time1?.schedule(back2, 12000)
    }
}