package Positions;

import Devices.Device;

import java.util.ArrayList;

public class Mapper {

    ArrayList<Floor> floors = new ArrayList<>();
    ArrayList<Room> rooms = new ArrayList<>();

    public void addFloor(Floor fl){
        floors.add(fl);
    }


    public Floor getFloor(int level){
        Floor floor = null;
        for(Floor fl : floors){
            if(fl.getLevel() == level){
                floor = fl;
            }
        }
        return floor;
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



    public void addRoom(Room room){
        System.out.println("adding....");

        rooms.add(room);

        System.out.println(room);
    }

    public void connectRoomToFloor(Room room){
        Floor fl = getFloor(room.getLevel());
        fl.floorRooms.add(room);
    }


    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public void printRooms(){
        for(Room ro : getRooms()){
            System.out.println(ro);
        }
    }

    public Room getRoom(String str){
        Room roomToReturn = null;

        System.out.println("HELLELELEEEL");
        System.out.println(rooms);
        for(Room room : rooms){
            if (room.getRoomName().equals("Kitchen")) {
                System.out.println("Hiterino!!!!");
                return room;
            }
        }
        System.out.println("No Hiterino!!!");
        return roomToReturn;
    }
    public void removeRoom(){

    }

    public void setupRoom(ArrayList<Device> devices){ // A, B, C, D

        ArrayList<Integer[]> tempArrays = new ArrayList<>(); // aArray, bArray, cArray, dArray

        for(int i = 0; i < devices.size(); i++){
            tempArrays.add(new Integer[4]);
        }

        System.out.println(tempArrays.size());



    }




}
