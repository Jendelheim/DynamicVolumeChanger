package Positions;

import Devices.Device;
import Devices.DeviceHandler;

import java.util.ArrayList;

public class Floor {

    int id;
    int level;

    // Varje våning har x antal rum kopplade till respektive våning.
    ArrayList<Room> FloorRooms = new ArrayList<>();

    public Floor(int level){
        this.id = setId();
        this.level = level;
    }

    // I stunden fångar den inte upp dubletter vilka kan uppstå när ett floor tagits bort och man försöker addera ett nytt
    public int setId(){
        Mapper mp = new Mapper();

        int value = (mp.floors.size());

        return ++value;
    }


    public String toString(){
        return "Floor: " + level + " with ID : " + id;
    }







}
