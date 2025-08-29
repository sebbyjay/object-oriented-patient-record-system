public class Observation{

    //attributes
    private ObservationType oType;
    
    //constructor
    public Observation(ObservationType oType){
        this.oType = oType;
    }

    //retrieve oType
    public ObservationType getOType(){
        return oType;
    }

    //convert oType and its inherited attributes to a string
    public String toString() {
        return "Observation Type: " + oType;
    }
}