package Positions;

import Devices.Device;
import Devices.DeviceHandler;

import java.util.ArrayList;

public class Floor {

    int level;

    // Varje våning har x antal rum kopplade till respektive våning.
    ArrayList<Room> floorRooms = new ArrayList<>();

    public Floor(int level){
        this.level = level;
    }

    // I stunden fångar den inte upp dubletter vilka kan uppstå när ett floor tagits bort och man försöker addera ett nytt
    public int setId(){
        Mapper mp = new Mapper();

        int value = (mp.floors.size());

        return ++value;
    }

    public int getLevel(){
        return level;
    }


    public String toString(){
        return "Floor: " + level;
    }

    public ArrayList<Room> getFloorRooms(){
        return floorRooms;
    }





}
