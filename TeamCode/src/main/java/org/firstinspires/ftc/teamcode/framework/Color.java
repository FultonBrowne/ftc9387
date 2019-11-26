package org.firstinspires.ftc.teamcode.framework;

import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.robocol.TelemetryMessage;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Color {
    public boolean colors(ColorSensor colorSensor, Telemetry t ){
        t.addData(Integer.toString(colorSensor.argb()), "");
        colorSensor.enableLed(true);
        return true;
    }
}
