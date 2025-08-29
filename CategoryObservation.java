public class CategoryObservation extends Observation{

    //attributes
    private String value;

    //constructor
    public CategoryObservation(ObservationType oType, String value){
        super(oType);
        this.value = value;
    }
    //retrieve value
    public String getValue(){
        return value;
    }

    //retrieve code
    public ObservationType getOType(){
        return super.getOType();
    }
    
    //convert value and its inherited attributes to a string
    public String toString(){
        return super.toString() + ", Value: " + value;
    }
}