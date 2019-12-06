package org.firstinspires.ftc.teamcode.framework;

import com.qualcomm.robotcore.hardware.ColorSensor;
import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Color {
    public boolean colors(ColorSensor colorSensor, Telemetry t ){
        boolean toReturn = false;
        t.addData(Integer.toString(colorSensor.argb()), "all");
        t.addData(Integer.toString(colorSensor.red()), "red");
        t.addData(Integer.toString(colorSensor.green()), "green");
        t.addData(Integer.toString(colorSensor.blue()), "blue");
        t.addData(Integer.toString(colorSensor.alpha()), "alpha");
        if (colorSensor.alpha() < 30) toReturn = true;
        colorSensor.enableLed(true);
       // if (colorSensor)
        return toReturn;
    }
}
