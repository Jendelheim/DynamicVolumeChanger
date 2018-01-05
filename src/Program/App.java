package Program;

import Devices.Device;
import Devices.DeviceHandler;
import Positions.Mapper;
import Positions.Room;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class App extends Mapper {


    Boolean autopilot = false;
    DeviceHandler dh = new DeviceHandler();

    private static Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    Tasks tsks = new Tasks();
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public void initializing(){
        System.out.println("Starting application..");

        command();
    }



    public void command(){
        System.out.println("Command: ");

        while (sc.hasNext() && !autopilot) {

            String inputCommand = sc.nextLine().toLowerCase();

            if (inputCommand.equals("add floor")) {
                addFloorButton();
            } else if (inputCommand.equals("list floors")){
                listFloors();
            } else if (inputCommand.equals("add room")) {
                addRoomButton();
            } else if (inputCommand.equals("list rooms")){
                listRooms();
            } else if (inputCommand.equals("list connected rooms")){
                listConnectedRooms();
            } else if (inputCommand.equals("add device")) {
                addDeviceButton();
            } else if (inputCommand.equals("exit")) {
                exit();
            } else if (inputCommand.equals("toggle autopilot")){

                System.err.print(autopilot);
                toggleAutopilot(autopilot);
            } else if (inputCommand.equals("setup room")){
                setupRoom();
            } else if (inputCommand.equals("add demo data")){
                tsks.runTests();
            }
            else {
                System.out.println("Option does not exist.");
                }
            }
        }

    public void setupRoom(){
        tsks.setupRoom();
    }

    public void addFloorButton(){
        System.out.print("Enter floor: ");
        tsks.addFloor(sc.nextInt());
    }

    public void listFloors(){
        tsks.listFloors();
    }

    public void addRoomButton(){
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter floor: ");
        int floor = sc.nextInt();

        tsks.addRoom(name, floor);

    }

    public void addDeviceButton(){
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Connect to room: ");
        String connecting = sc.nextLine();

        tsks.addDevice(name, connecting);
    }

    public void listRooms(){
        tsks.listRooms();
    }

    public void listConnectedRooms(){
        System.out.print("Enter level to show connected rooms: ");
        tsks.printRoomsLinkedToFloor(sc.nextInt());
    }

    public void toggleAutopilot(boolean isOn){

            if(isOn){
                autopilot = false;
            }
            else if(!isOn){
                autopilot = true;
                startTimer();
            }

            System.out.println("new result: " + autopilot);
    }

    public void exit() {
        sc.close();
        System.out.println("exit - intiated");
        System.exit(0);
    }

    public int[] sendAutoProgress(String roomName){
        int[] array = new int[4];
           int count = 0;



           System.out.println("HEllo world!");
           System.out.println(tsks.getConnectedDevicesForSpecificRoom(roomName).size());
            for(Device dev : tsks.getConnectedDevicesForSpecificRoom(roomName)){
                array[count] = dh.pingSpeaker(dev);
                count++;
            }

            System.out.println(Arrays.toString(array));

        return array;
    }

    public void startTimer(){

        Runnable helloRunnable = new Runnable() {
            public void run() {
                if(autopilot){
                    System.out.println("OH HERREGUD");
                    sendAutoProgress("Livingroom");
                }
            }
        };
        executor.scheduleAtFixedRate(helloRunnable, 0, 2, TimeUnit.SECONDS);
    }

}
