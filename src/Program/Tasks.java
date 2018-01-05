package Program;

import Devices.Device;
import Devices.DeviceHandler;
import Positions.Floor;
import Positions.Mapper;
import Positions.Room;

import java.util.ArrayList;
import java.util.Arrays;

public class Tasks{

    Mapper mapper = new Mapper();
    DeviceHandler dh = new DeviceHandler(mapper);

    public void runTests(){
        System.out.println("Starting to add testdata..");


        addDemoFloors();

        addDemoRooms();

        addDemoDevices();

        printDemoFloors();

        printDemoRooms();

        printDemoDevices();

        testConnectedDevices();

/*

        printRoomsLinkedToFloor(1);
        System.err.println("printRoomsLinkedToFloor() completed! ");

        listRooms();
        System.err.println("printRooms() completed! ");

*/
/*
        addDevices();
        System.err.println("addDevices() completed! ");
*//*


        receiveRSSI();
        System.err.println("receiveRSSI() completed! ");

  */
/*      testSignalRandomValue();
        System.err.println("testSignalRandomValue() completed! ");
*//*

        saveRSSI();
        System.err.println("saveRSSI() completed! ");

*/
/*
        getAverageRSSI();
        System.err.println("getAverageRSSI() completed! ");
*//*


    //    getCombinedAverageRSSI();
        System.err.println("getCombinedAverageRSSI() completed! ");

        setupRoom();
        System.err.println("addFloor() completed! ");
*/

        System.out.println("All test-methods are completed.");
    }

    // Test-classes

    public void addDemoFloors(){
        System.out.println("Starting to add floors..");
        addFloor(1);
        addFloor(2);
        addFloor(3);
        System.err.println("addDemoFloors() completed! ");
    }

    public void addDemoRooms(){

        System.out.println("Starting to add rooms..");
        addRoom("Livingroom", 1);
        addRoom("Kitchen", 1);
        addRoom("Bedroom", 2);
        addRoom("Gameroom", 2);
        addRoom("Saferoom", 3);
        addRoom("Walk-in closet", 3);
        System.err.println("addDemoRooms() completed! ");
    }

    public void addDemoDevices(){


        System.out.println("Starting to add devices");
        addDevice("NorthEast", "Livingroom");
        addDevice("NorthWest", "Livingroom");
        addDevice("SouthEast", "Livingroom");
        addDevice("SouthWest", "Livingroom");

        addDevice("NorthEast", "Kitchen");
        addDevice("NorthWest", "Kitchen");
        addDevice("SouthEast", "Kitchen");
        addDevice("SouthWest", "Kitchen");


        addDevice("NorthEast", "Bedroom");
        addDevice("NorthWest", "Bedroom");
        addDevice("SouthEast", "Bedroom");
        addDevice("SouthWest", "Bedroom");

        addDevice("NorthEast", "Gameroom");
        addDevice("NorthWest", "Gameroom");
        addDevice("SouthEast", "Gameroom");
        addDevice("SouthWest", "Gameroom");


        addDevice("NorthEast", "Saferoom");
        addDevice("NorthWest", "Saferoom");
        addDevice("SouthEast", "Saferoom");
        addDevice("SouthWest", "Saferoom");

        addDevice("NorthEast", "Walk-in closet");
        addDevice("NorthWest", "Walk-in closet");
        addDevice("SouthEast", "Walk-in closet");
        addDevice("SouthWest", "Walk-in closet");

        System.err.println("addDemoDevices() completed");

    }

    public void printDemoFloors(){
        listFloors();
    }

    public void printDemoRooms(){
        listRooms();
    }

    public void printDemoDevices(){
        mapper.printDevices();
    }

    public void testConnectedDevices(){
        System.out.println("Print devices connected to room: Livingroom");
        System.out.println(getConnectedDevicesForSpecificRoom("Livingroom")
    );}


    // Test-classes ends.


    public void addFloor(int level){

        Floor floor = new Floor(level);
        mapper.addFloor(floor);


        System.out.println("Floor: " + level + " added!");

//        // test-floors
//        Floor fl1 = new Floor(1);
//        mapper.addFloor(fl1);
//
//        Floor fl2 = new Floor(2);
//        mapper.addFloor(fl2);
//
//        Floor fl3 = new Floor(3);
//        mapper.addFloor(fl3);


        // printing to check the floor is added to the list of floors.
//        System.out.println("Printing all floors: ");
//        mapper.printFloors();
    }

    public void listFloors(){
        System.out.println(mapper.getFloors());
    }

    public ArrayList<Device> getDevicesFromDh(){
        return dh.getDevices();
    }

    public void addRoom(String name, int level){

        Room room = new Room(name, level);


        System.out.println("Init connect.");
        boolean toAddRoom = mapper.connectRoomToFloor(room);

        if(toAddRoom){
            mapper.addRoom(room);


            System.out.println("Room: " + name + " added!");
        } else {
            System.err.println("Cannot add since there are no floor called level: " + level);
        }
    }

    public void printRoomsLinkedToFloor(int level){

        System.out.println("Printing rooms linked to level: ");
        Floor fl = mapper.getFloor(level);
        ArrayList<Room> rooms = fl.getFloorRooms();

        for(Room room : rooms){
            System.out.println(room);
        }
    }

    public void listRooms(){
        //System.out.println("PRINTROOMS(); ");
        System.out.println(mapper.getRooms());
        //System.out.println(mapper.getRooms().size());
    }

    public void addDevice(String name, String connecting){

        Room room = mapper.getRoom(connecting);

        Device device = new Device(name, room);

        mapper.addDevice(device, connecting);

        //System.err.println("Added: " + device);

    }

/*    public void addDevices(){

        dh.addDevice("A", "chillzone");
        dh.addDevice("B", "Kitchen");
        dh.addDevice("C", "Kitchen");
        dh.addDevice("D", "Kitchen");

        dh.printDevices();
    }*/

    public void receiveRSSI(){
         Device device = dh.getDevice(1);
         double rssi = device.getSignalStrength();

         System.out.println("test signalstrength: " + rssi);
    }

   public void testSignalRandomValue(Device device){
         Integer[] array = dh.getSignalStrengthArray(device, 10);

         System.out.println(Arrays.toString(array));
    }

    public void saveRSSI(){

    }

    public void getAverageRSSI(){
        dh.pingSpeaker(dh.getDevice(1));


    }

    public void getCombinedAverageRSSI(){

    }

    public ArrayList<Device> getConnectedDevicesForSpecificRoom(String roomName){
        return mapper.returnConnectedDevicesForSpecificRoom(roomName);
    }



    public void setupRoom(){

        System.out.println("initializing setup .. ");

        System.out.println("creating demo devices");

        System.out.println("Getting room  .. ");

        System.out.println("Starting setup in retreived room .. ");
        mapper.setupRoom("Livingroom");


    }
}
