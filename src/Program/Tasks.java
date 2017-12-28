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
        System.out.println("Starting tests..");

        addFloor(2); // done
        System.err.println("addFloor() completed! ");


        addRoom("Livingroom", 1); // done
        System.err.println("addRoom() completed! ");

        printRoomsLinkedToFloor(1);
        System.err.println("printRoomsLinkedToFloor() completed! ");

        printRooms();
        System.err.println("printRooms() completed! ");

/*
        addDevices();
        System.err.println("addDevices() completed! ");
*/

        receiveRSSI();
        System.err.println("receiveRSSI() completed! ");

  /*      testSignalRandomValue();
        System.err.println("testSignalRandomValue() completed! ");
*/
        saveRSSI();
        System.err.println("saveRSSI() completed! ");

/*
        getAverageRSSI();
        System.err.println("getAverageRSSI() completed! ");
*/

    //    getCombinedAverageRSSI();
        System.err.println("getCombinedAverageRSSI() completed! ");

        setupRoom();
        System.err.println("addFloor() completed! ");

        System.out.println("All test-methods are completed.");
    }

    public void addFloor(int level){

        Floor floor = new Floor(level);
        mapper.addFloor(floor);

        System.err.println("Added: " + floor);

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

    public void addRoom(String name, int level){

        Room room = new Room(name, level);
        mapper.addRoom(room);

        System.err.println("Added: " + room);

        /*   System.out.println("ADDING ROOMS : ");
        Room r1 = new Room("Kitchen", 1);
        mapper.addRoom(r1);
        mapper.connectRoomToFloor(r1);

        Room r2 = new Room("Livingroom", 1);
        mapper.addRoom(r2);
        mapper.connectRoomToFloor(r2);

        Room r3 = new Room("chillzone", 1);
        mapper.addRoom(r3);
        mapper.connectRoomToFloor(r3);


        // printing to check the room is added to the list of rooms.
        System.out.println("Printing all rooms: ");
        mapper.printRooms();*/
    }

    public void printRoomsLinkedToFloor(int level){

        System.out.println("Printing rooms linked to level: ");
        Floor fl = mapper.getFloor(level);
        ArrayList<Room> rooms = fl.getFloorRooms();

        for(Room room : rooms){
            System.out.println(room);
        }
    }

    public void printRooms(){
        System.out.println("PRINTROOMS(); ");
        System.out.println(mapper.getRooms());
        System.out.println(mapper.getRooms().size());
    }

    public void addDevice(String name, String connecting){
        Device device = new Device(name);

        mapper.addDevice(device, connecting);


        System.err.println("Added: " + device);

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



    public void setupRoom(){

        System.out.println("initializing setup .. ");

        System.out.println("creating demo devices");
        dh.addDemoDevices();

        System.out.println("Getting room  .. ");
     //   Room room = mapper.getRoom("Kitchen");


        System.out.println("Starting setup in retreived room .. ");
        mapper.setupRoom(dh.getDevices());


    }
}
