package SignalReceiver;

public class Plausibility {

    Boolean plaus = null;


    // Om differensen från tidigare punkt är större x
    // så är det icke troligt att hämtningen är korrekt.

    public boolean calcPlausibility(int prevArrayInt, int arrayInt){

        int tempValue = -1;

        if(prevArrayInt > arrayInt){
            tempValue = prevArrayInt - arrayInt;

            plaus = calculator(tempValue);

        } else if(arrayInt > prevArrayInt){
            tempValue = arrayInt - prevArrayInt;

            plaus = calculator(tempValue);

        }

        return plaus;
    }


    public boolean calculator(int tempValue){
        boolean bool;
        if(tempValue > 25){
             bool = false;
        }   else{
             bool = true;
        }

        return bool;
    }

    public boolean getPlaus(){
        return plaus;
    }

    public String toString(){
        return "The plausibility for this change is: " + plaus;
    }
}
