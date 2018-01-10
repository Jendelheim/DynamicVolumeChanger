package Program;

import Devices.Device;
import Devices.DeviceHandler;
import Positions.Mapper;
import Positions.Room;
import SignalReceiver.Definer;
import SignalReceiver.Plausibility;


import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class App extends Mapper {

    private Tasks tsks = new Tasks();
    private DeviceHandler dh = new DeviceHandler();
    private Definer def = new Definer();
    private Plausibility plaus = new Plausibility();


    private static Scanner sc = new Scanner(System.in).useLocale(Locale.US);

    private Boolean autopilot = false;
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
    private int [] prevArray = new int [4];

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
                toggleAutopilot(autopilot);
            } else if (inputCommand.equals("setup room")){
                setupRoom();
            } else if (inputCommand.equals("add demo data")){
                tsks.runTests();
            } else if(inputCommand.equals("test definer")){
                performDefiner();
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
                startTimer("Livingroom");
            }
    }

    public void exit() {
        sc.close();
        System.out.println("exit - intiated");
        System.exit(0);
    }

    public void printVolumeAdjustments(int[] array){
        System.out.println("Setting device A volume to: " + array[0] + "  The value has " + increaseDecrease(prevArray[0], array[0])+ " since last ping. (prev: " + prevArray[0] + ")");
        def.setDefinitionEnum(array[0]);
        System.out.println("Signal-strength for device A: " + def.toString());
        plaus.calcPlausibility(prevArray[0], array[0]);
        System.out.println(plaus.toString());

        System.out.println(" ");

        System.out.println("Setting device B volume to: " + array[1] + "  The value has " + increaseDecrease(prevArray[1], array[1])+ " since last ping. (prev: " + prevArray[1] + ")");
        def.setDefinitionEnum(array[1]);
        System.out.println("Signal-strength for device B: " + def.toString());
        plaus.calcPlausibility(prevArray[1], array[1]);
        System.out.println(plaus.toString());

        System.out.println(" ");

        System.out.println("Setting device C volume to: " + array[2] + "  The value has " + increaseDecrease(prevArray[2], array[2])+ " since last ping. (prev: " + prevArray[2] + ")");
        def.setDefinitionEnum(array[2]);
        System.out.println("Signal-strength for device C: " + def.toString());
        plaus.calcPlausibility(prevArray[2], array[2]);
        System.out.println(plaus.toString());

        System.out.println(" ");

        System.out.println("Setting device D volume to: " + array[3] + "  The value has " + increaseDecrease(prevArray[3], array[3])+ " since last ping. (prev: " + prevArray[3] + ")");
        def.setDefinitionEnum(array[3]);
        System.out.println("Signal-strength for device D: " + def.toString());
        plaus.calcPlausibility(prevArray[3], array[3]);
        System.out.println(plaus.toString());

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(" ");

    }

    public String increaseDecrease(int prev, int next){
        String trend = null;
        if(prev > next){
            trend = "decreased";
        } else if(next > prev){
            trend = "increased";
        }
        return trend;
    }

    private void sendAutoProgress(String roomName){

        int[] array = new int[4];
           int count = 0;
            for(Device dev : tsks.getConnectedDevicesForSpecificRoom(roomName)){
                array[count] = dh.pingSpeaker(dev);
                count++;
            }

            printVolumeAdjustments(array);
            prevArray = array;


    }

    public void startTimer(String roomName){

        Runnable helloRunnable = new Runnable() {
            public void run() {
                if(autopilot){
                    sendAutoProgress(roomName);
                }
            }
        };
        executor.scheduleAtFixedRate(helloRunnable, 0, 2, TimeUnit.SECONDS);
    }



    // Testing definer

    public int getTestRSSI(){
        return 10;
    }

    public void performDefiner(){
        def.setDefinitionEnum(getTestRSSI());

        System.out.println(def.toString());

      //  def.getSignalStrength();

    }



}
