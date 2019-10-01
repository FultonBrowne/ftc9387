package org.firstinspires.ftc.teamcode.framework;

import java.util.HashMap;
import java.util.Map;

public class blocknav {
   public int main(int currentBlock){
       return imageBlockMap.get(currentBlock);
   }
   private Map<Integer, Integer> imageBlockMap= new HashMap<Integer, Integer>(){{
       put(1,4);
       put(2,5);
       put(3,6);
       put(4,1);
       put(5,2);
       put(6,3);
   }};

}