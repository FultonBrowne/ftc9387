package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.Disabled
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import com.qualcomm.robotcore.hardware.*
import org.firstinspires.ftc.teamcode.framework.*
@Autonomous( name = "Auto Blue 2020")
class AutoBlue : OpMode() {
   var motor0:DcMotor? = null 
   var motor1:DcMotor? = null 
   var motor2:DcMotor? = null 
   var motor3:DcMotor? = null 
   var autotools:AutoFramework? = null
   override fun init(){
        motor0 = hardwareMap.dcMotor["motor0"]
        motor1 = hardwareMap.dcMotor["motor1"]
        motor2 = hardwareMap.dcMotor["motor2"]
        motor3 = hardwareMap.dcMotor["motor3"]
        motor0!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor1!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor2!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor3!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        autotools = AutoFramework(
           motor0!!,
           motor1!!,
           motor2!!,
           motor3!!
        )
   }


   override fun loop(){

   }

   override fun start(){
      autotools!!

   }
}
