public class MeasurementObservation extends Observation{
    
    //attributes
    private int value;

    //constructor
    public MeasurementObservation(ObservationType oType, int value){
        super(oType);
        this.value = value;
    }

    //retreive code
    public ObservationType getOType(){
        return super.getOType();
    }

    //retrive value
    public int getValue(){
        return value;
    }

    //convert value and its inherited attributes to a string
    public String toString() {
        return super.toString() + ", Value: " + value;
    }
}