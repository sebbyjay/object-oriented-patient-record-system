public class MeasurementObservationType extends ObservationType{
    
    //attributes
    private String unit;
    
    //constructors
    public MeasurementObservationType(String code, String name, String unit){
        super(code, name);
        this.unit = unit;
    }
    //retrieve code
    public String getCode(){
        return super.getCode();
    }

    //retrieve name
    public String getName(){
        return super.getName();
    }

    //retrieve unit
    public String getUnit(){
        return unit;
    }

    //convert unit and its inherited attributes to a string
    public String toString() {
        return super.toString() + ", Unit: " + unit;
    }
}