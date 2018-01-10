package SignalReceiver;

     enum signal_strength{
        SIGNAL_STRENGTH_NONE_OR_UNKNOWN,
        SIGNAL_STRENGTH_GREAT,
        SIGNAL_STRENGTH_GOOD,
        SIGNAL_STRENGTH_MODERATE,
        SIGNAL_STRENGTH_POOR;
    }

public class Definer {

    private signal_strength sigStr;

    public Definer(){
        sigStr = signal_strength.SIGNAL_STRENGTH_NONE_OR_UNKNOWN;
    }


    public void setDefinitionEnum(int rssi){

        // definiera vad som är en bra respektive dålig signal

        if(rssi == 99){ sigStr = signal_strength.SIGNAL_STRENGTH_NONE_OR_UNKNOWN;}
        else if (rssi > -1 && rssi < 26){
            sigStr = signal_strength.SIGNAL_STRENGTH_GREAT;}
        else if (rssi > 25 && rssi < 51){
            sigStr = signal_strength.SIGNAL_STRENGTH_GOOD;}
        else if (rssi > 50 && rssi < 76) {
            sigStr = signal_strength.SIGNAL_STRENGTH_MODERATE;}
        else if (rssi > 75 && rssi < 101){
            sigStr = signal_strength.SIGNAL_STRENGTH_POOR;}
    }

    public signal_strength getSignalStrength(){
        return sigStr;
    }

    public String toString(){
        return sigStr.toString();
    }
}
