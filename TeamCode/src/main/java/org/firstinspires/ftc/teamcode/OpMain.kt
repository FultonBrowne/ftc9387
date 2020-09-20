package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.eventloop.opmode.Disabled
import com.qualcomm.robotcore.eventloop.opmode.OpMode
import org.firstinspires.ftc.teamcode.framework.*
import com.qualcomm.robotcore.hardware.*
@TeleOp( name = "TeleOp 2020")
class OpMain : OpMode() {
   var motor0:DcMotor? = null 
   var motor1:DcMotor? = null 
   var motor2:DcMotor? = null 
   var motor3:DcMotor? = null 
   val move = Move()
   override fun init(){
        motor0 = hardwareMap.dcMotor["motor0"]
        motor1 = hardwareMap.dcMotor["motor1"]
        motor2 = hardwareMap.dcMotor["motor2"]
        motor3 = hardwareMap.dcMotor["motor3"]
        motor0!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor1!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor2!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
        motor3!!.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE)
   }

   override fun loop(){
      if(gamepad1.left_stick_y > 0.1 || gamepad1.left_stick_y < -0.1){
         move.forward(
            motor0, 
            motor1,
            motor2,
            motor3,
            gamepad1.left_stick_y
         )


      }

      else if(gamepad1.left_stick_x > 0.1 || gamepad1.left_stick_x < -0.1){
         move.left(
            motor0, 
            motor1,
            motor2,
            motor3,
            gamepad1.left_stick_x
         )

      }

      else if(gamepad1.right_stick_x > 0.1 || gamepad1.right_stick_x < -0.1){
         move.spin(
            motor0,
            motor1,
            motor2,
            motor3,
            gamepad1.right_stick_x
         )
      }

      else{
         move.stop(
            motor0, 
            motor1,
            motor2,
            motor3
         )
      }

      if(gamepad1.y){
         //TODO load
      }

      if(gamepad1.a){
         //TODO FIRE!!!!!
      }

      if(gamepad1.b){
         //TODO pick up goal
      }

      else if (gamepad1.x){
         //TODO unload goal
      }


      if(gamepad1.left_bumper){
         move.stop(
            motor0, 
            motor1,
            motor2,
            motor3
         )
      }

   }


}
