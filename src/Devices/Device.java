package Devices;

import Positions.Position;

public class Device {
    DeviceHandler dh = new DeviceHandler();

    public int serial;
    public String nickname;
    Position position = null;

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

    public Position setPosition(){
        Position pos = null;
        return pos;
    }
}
