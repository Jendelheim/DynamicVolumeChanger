package Positions;

import java.util.ArrayList;

public class Mapper {

    ArrayList<Floor> floors = new ArrayList<>();
    ArrayList<Room> rooms = new ArrayList<>();


    public void addFloor(int id, int level){
        Floor floor = new Floor(level);
        floors.add(floor);
    }

    public ArrayList<Floor> getFloors(){
        return floors;
    }

    public void printFloors(){
        for(Floor fl : getFloors()){
            System.out.println(fl);
        }
    }

    public void removeFloor(){

    }

    public void addRoom(String roomName){
        Room room = new Room(roomName);
        rooms.add(room);
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void removeRoom(){

    }
}
