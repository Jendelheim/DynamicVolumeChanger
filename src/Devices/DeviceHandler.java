    package Devices;

    import Positions.Mapper;
    import Positions.Room;

    import java.util.ArrayList;
    import java.util.Arrays;

    public class DeviceHandler {

        Mapper mapper; //  = new Mapper();

        ArrayList<Device> devices = new ArrayList<Device>();

        public DeviceHandler(Mapper mapper){
            this.mapper = mapper;
        }

        public DeviceHandler(){

        }

        public ArrayList<Device> getDevices(){
            return devices;
        }

        public int deviceAmount(){
            return devices.size();
        }

        public void addDevice(Device newDevice, String roomName){

            devices.add(newDevice);
            System.out.println("PRINTING DEVICES-SIZE:::: " + devices.size());

            System.err.print(roomName);
            //System.err.print(mapper.getRoom(roomName));

           //mapper.getRoom(roomName);

          //  System.out.println("PRINTING ROOM : " + room);
          //  room.linkDevice(newDevice);


        }

        public void addDemoDevices(){
            devices.add(new Device("northEast"));
            devices.add(new Device("northWest"));
            devices.add(new Device("southEast"));
            devices.add(new Device("southWest"));
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
                if(d.getSerial() == serial){
                    devices.remove(d);
                }
            }
        }

        public void printDevices(){

            System.out.println("Printing all devices: ");
            for(Device device : devices){
                System.out.println(device);
            }
        }

       public Integer[] getSignalStrengthArray(Device device, int indexes){

            Integer[] array = new Integer[10];

            for(int i = 0; i < indexes; i++){
                // System.out.println(dev.getSignalStrength());
                array[i] = device.getSignalStrength();
            }

            return array;
        }

        public int pingSpeaker(Device otherSpeaker){

            Integer[] distanceArray = getSignalStrengthArray(otherSpeaker, 10);

            int sum = 0;
            for (int d : distanceArray) sum += d;

            int average = sum / distanceArray.length;

            System.out.println("Printing distanceArray: " + Arrays.toString(distanceArray));
            System.out.println("Printing average distance value: " + average);
            return average;
        }




    }
