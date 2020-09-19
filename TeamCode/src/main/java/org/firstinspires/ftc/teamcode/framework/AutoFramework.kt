package org.firstinspires.ftc.teamcode.framework
import com.qualcomm.robotcore.hardware.*
/**
* Shared code for auto modes
* GPL 3.0 licensed
**/
class AutoFramework(
   val motor0:DcMotor,
   val motor1:DcMotor,
   val motor2:DcMotor,
   val motor3:DcMotor
){
   val move = Move()
   fun forward(){
      move.forward(
         motor0,
         motor1,
         motor2,
         motor3
      )
   }

   fun left(){
      move.left(
         motor0,
         motor1,
         motor2,
         motor3
      )

   }

   fun right(){
      move.right(
         motor0,
         motor1,
         motor2,
         motor3
      )

   }

   fun back(){
      move.back(
         motor0,
         motor1,
         motor2,
         motor3
      )

   }

   fun stop(){
      move.stop(
         motor0,
         motor1,
         motor2,
         motor3
      )

   }

   fun height(): Short{
      // this will return 0, 1, or 2
      return 0
   }

   fun initMove(){
      //TODO
   }

   fun spinDropSpin(){

   }

   fun drop(){

   }

}
