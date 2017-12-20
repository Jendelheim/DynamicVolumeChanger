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

        public int deviceAmount(){
            return devices.size();
        }

        public void addDevice(String nickname, String roomName){
            Device newDevice = new Device();

            newDevice.setNickname(nickname);

            System.out.println("PRINTING DEVICE:::: " + newDevice);

            devices.add(newDevice);



            System.out.println("PRINTING DEVICES-SIZE:::: " + devices.size());



            Room room = mapper.getRoom(roomName);

            System.out.println("PRINTING ROOM : " + room);
            room.linkDevice(newDevice);


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

        public Integer[] getSignalStrengthArray(int indexes){
            Device dev = new Device();
            Integer[] array = new Integer[10];

            for(int i = 0; i < indexes; i++){
                // System.out.println(dev.getSignalStrength());
                array[i] = dev.getSignalStrength();
            }

            return array;
        }

        public int pingSpeaker(Device otherSpeaker){

            Integer[] distanceArray = getSignalStrengthArray(10);

            int sum = 0;
            for (int d : distanceArray) sum += d;

            int average = sum / distanceArray.length;

            System.out.println("Printing distanceArray: " + Arrays.toString(distanceArray));
            System.out.println("Printing average distance value: " + average);
            return average;
        }




    }
