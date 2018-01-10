package Devices;

import Positions.Position;
import Positions.Room;

import java.util.ArrayList;
import java.util.Random;

public class Device extends DeviceHandler {
    DeviceHandler dh = new DeviceHandler();

    private int serial;
    private String nickname = "deviceExample";
    private Position position = null;
    private Room room;

    // Stores the distances between each device, in this case, device = A stores distance: AB, AC, AD so forth.
    // Probably needs to be adjusted to become a HashMap instead of ArrayList. (where K = ID, V = Distance)
    ArrayList<Double> deviceDistances = new ArrayList<>();

    public Device (){

    }

    public Device(String name, Room room){
        this.serial = setSerial();
        this.nickname = name;
        this.room = room;
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

    public Room getRoom(){
        return room;
    }
/*

    public Position getPosition() {
        return position;
    }
*/

    public String toString(){
        return "Device (" + serial + ") nickname: " + nickname + " (connected to room: " + room.getRoomName() + ")";
    }

    public int getSignalStrength(){ // Är random tills vi fixat RSSI, motsvarar nu procent
        Random ran = new Random();
        int x = ran.nextInt(100) + 0;
        return x;
    }
}
