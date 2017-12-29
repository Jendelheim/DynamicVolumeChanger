package Positions;

import Devices.Device;
import Devices.DeviceHandler;

import java.util.ArrayList;
import java.util.Arrays;

public class Mapper extends DeviceHandler{

    ArrayList<Floor> floors = new ArrayList<>();
    ArrayList<Room> rooms = new ArrayList<>();

    Room connector = null;

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
    //    System.out.println("adding....");

        rooms.add(room);

     //   System.out.println(room);
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

    public void getRoom(String str){
        System.out.println("HELLELELEEEL");
        System.out.println(rooms);
        for(Room room : rooms){
            if (room.getRoomName().equals("Kitchen")) {
                System.out.println("Hiterino!!!!");
                System.err.println(room);
                connector = room;
            }
        }
        System.out.println("No Hiterino!!!");
        //return roomToReturn;
    }
    public void removeRoom(){

    }

    public void setupRoom(ArrayList<Device> devices){ // A, B, C, D

        // checking devies size
        System.err.println(devices.size());

        // creating the tempArrays
        ArrayList<Integer[]> tempArrays = returnTempArrays(devices);

        // Kontrollerar antalet tempArrays
        System.out.println(tempArrays.size());

        // Skriver ut värdena av tempArrays
        System.out.println("Skriver ut värdena från tempArrays");

        int counter = 0;
        for(Integer[] array : tempArrays){
            System.out.println(++counter + " " + Arrays.toString(array));
        }

        // Lägger in värden i tempArrays
        for(int i = 0; i < devices.size(); i++){
            pingDistances(devices.get(i),devices);
        }

    }

    public ArrayList<Integer[]> returnTempArrays(ArrayList<Device> devices){
        ArrayList<Integer[]> tempArrays = new ArrayList<>();
        for(int i = 0; i < devices.size(); i++){
            tempArrays.add(new Integer[3]);
        }
        return tempArrays;
    }

    public void pingDistances(Device pingingSpeaker, ArrayList<Device> devices){
        Integer[] values = new Integer[3];

        //System.out.println("Devices.size() " + devices.size());
        for(Device dev : devices){
            if(!dev.getNickname().equals(pingingSpeaker.getNickname())){
               // pingSpeaker(dev);
                System.out.println("OH HERREGUD!");
            }
        }

    }

    public void pingSpeakers(){

    }
}
