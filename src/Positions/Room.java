package Positions;

import Devices.Device;

import java.util.ArrayList;

public class Room {

    int id;
    String roomName;

    // Varje Rum har x antal devies länkade till respektive rum.
    ArrayList<Device> linkedDevices = new ArrayList<>();

    public Room(String roomName){
        this.id = setId();
        this.roomName = roomName;
    }


    // I stunden fångar den inte upp dubletter vilka kan uppstå när ett room tagits bort och man försöker addera ett nytt
    public int setId(){
        Mapper mp = new Mapper();

        int value = (mp.floors.size());

        return ++value;
    }

    public String toString(){
        return "Room: " + roomName + " with ID : " + id;
    }


}
