package Devices;

import java.util.ArrayList;

public class DeviceHandler {

    ArrayList<Device> devices = new ArrayList<Device>();

    public int deviceAmount(){
        return devices.size();
    }

    public void addDevice(){
        Device newDevice = new Device();

        devices.add(newDevice);
    }

    public Device getDevice(int serial){
       Device device = null;
        for(Device d : devices){
            if(d.getSerial() == serial){
                System.out.println("Hit hit hit!");
                device = d; // Hur bryter man sig ur for-loopen samt if-satsen snyggast när man identifierat?
                }
        }
        return device;
    }

    public void removeDevice(int serial){
        for(Device d : devices){
            if(d.serial == serial){
                devices.remove(d);
            }
        }
    }



}
