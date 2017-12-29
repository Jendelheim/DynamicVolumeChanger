package Program;

import Devices.Device;
import Devices.DeviceHandler;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class App {


    Boolean autopilot = false;
    DeviceHandler dh = new DeviceHandler();

    private static Scanner sc = new Scanner(System.in).useLocale(Locale.US);
    Tasks tsks = new Tasks();
    private ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

    public void initializing(){
        System.out.println("Starting application..");

        command();

       // tsks.runTests();
    }



    public void command(){
        System.out.println("Command: ");

        while (sc.hasNext() && !autopilot) {

            String inputCommand = sc.nextLine().toLowerCase();

            if (inputCommand.equals("add floor")) {
                addFloorButton();
            } else if (inputCommand.equals("add room")) {
                addRoomButton();
            } else if (inputCommand.equals("add device")) {
                addDeviceButton();
            } else if (inputCommand.equals("exit")) {
                exit();
            } else if (inputCommand.equals("toggle autopilot")){

                System.err.print(autopilot);
                toggleAutopilot(autopilot);
            } else if (inputCommand.equals("setup room")){
                setupRoom();
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

    public int[] sendAutoProgress(){
        int[] array = new int[4];
           int count = 0;

           System.out.println(tsks.getDevicesFromDh().size());
            for(Device dev : tsks.getDevicesFromDh()){
                array[count] = dh.pingSpeaker(dev);
                count++;
            }

            System.out.println(Arrays.toString(array));

        return array;
    }

    public void startTimer(){

        Device device = new Device("Demo");
        Runnable helloRunnable = new Runnable() {
            public void run() {
                if(autopilot){
                    System.err.println("OH HERREGUD");
                    sendAutoProgress();
                //    dh.pingSpeaker(device);
                }
            }
        };
        executor.scheduleAtFixedRate(helloRunnable, 0, 2, TimeUnit.SECONDS);
    }

}
