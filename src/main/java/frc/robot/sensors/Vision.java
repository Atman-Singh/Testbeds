package frc.robot.sensors;

import edu.wpi.first.wpilibj.SerialPort;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class Vision {
    SerialPort visionData;

    public Vision(){
        visionData = new SerialPort(9600, SerialPort.Port.kUSB);
    }

    public double[] getData(){
        double[] data = new double[5];
        int c =  0;
        for (int i = 0; i < 40; i += 8){
            data[c] = ByteBuffer.wrap(Arrays.copyOfRange(visionData.read(40), i, i + 7)).getDouble();
            c++;
        }
        return data;
    }

    public double getAngleX(){
        return getData()[3];
    }

    public double getAngleY(){
        return getData()[4];
    }

    public double getDistance(){
        return getData()[2];
    }

    public double getCenterX(){
        return getData()[0];
    }

    public double getCenterY(){
        return getData()[1];
    }


}