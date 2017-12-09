package Devices;

import Positions.Position;

public class Device {
    DeviceHandler dh = new DeviceHandler();

    public int serial;
    Position position;

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

    public Position setPosition(){
        Position pos = null;
        return pos;
    }
}
