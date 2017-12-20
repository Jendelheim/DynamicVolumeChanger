package Devices;

import Positions.Position;

import java.util.ArrayList;
import java.util.Random;

public class Device {
    DeviceHandler dh = new DeviceHandler();

    private int serial;
    private String nickname = "deviceExample";
    private Position position = null;

    // Stores the distances between each device, in this case, device = A stores distance: AB, AC, AD so forth.
    // Probably needs to be adjusted to become a HashMap instead of ArrayList. (where K = ID, V = Distance)
    ArrayList<Double> deviceDistances = new ArrayList<>();

    // For each update of Mobile-device position the differator updates if the signal has increased/decreased/unchanged
    public enum differator {
        DECREASE, NEUTRAL, INCREASE;
    }

    // Checks what kind of device it is
    public enum type {
        MOBILE, TELLSTICK;
    }


    public Device(){
        this.serial = setSerial();
    }

    public int setSerial(){
        int value = dh.deviceAmount();
        return ++value;
    }

    public int getSerial(){
        return serial;
    }

    public void setNickname(String nickname){
        this.nickname = nickname;
    }

    public String getNickname(){
        return nickname;
    }

    public Position setPosition(){
        Position pos = null;
        return pos;
    }

    public Position getPosition() {
        return position;
    }

    public String toString(){
        return "Device (" + serial + ") nickname: " + nickname + " (Position: " + position + ")";
    }

    public int getSignalStrength(){ // Är random tills vi fixat RSSI, motsvarar nu procent
        Random ran = new Random();
        int x = ran.nextInt(100) + 0;
        return x;
    }
}
