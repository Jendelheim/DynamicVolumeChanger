package Positions;

import Devices.Device;

import java.util.ArrayList;

public class Room {


    private int level;
    private String roomName;
    private int[] dimensions = new int[4];

    // Varje Rum har x antal devies länkade till respektive rum.
    ArrayList<Device> linkedDevices = new ArrayList<>();

    public Room(String roomName, int level){
        this.roomName = roomName;
        this.dimensions = new int[]{0,0,0,0};
        this.level = level;
    }


    // I stunden fångar den inte upp dubletter vilka kan uppstå när ett room tagits bort och man försöker addera ett nytt
    public int setId(){
        Mapper mp = new Mapper();

        int value = (mp.rooms.size());

        return ++value;
    }

    public int[] getDimensions(){
        return dimensions;
    }

    public int getLevel (){
        return level;
    }

    public String getRoomName(){
        return roomName;
    }
    public ArrayList<Device> getLinkedDevices() {
        return linkedDevices;
    }

    public void linkDevice(Device device){
        linkedDevices.add(device);
    }

    public String toString(){
        return "Room: " + roomName + " which is located at level: " + level;
    }




}
