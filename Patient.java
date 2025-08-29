public class Patient{

    //attributes
    private String ID;
    private String name;
    private Observation[] obArray;
    private int oCount;

    //constructor
    public Patient(String ID, String name){
        this.ID = ID;
        this.name = name;
        this.obArray = new Observation[50];
        this.oCount = 0;
    }

    //add a MeasurementObservation to the obarray
    public void addMeasurementObservation(String code, String name, int value){
        ObservationType o = new ObservationType(code, name);
        obArray[oCount++] = new MeasurementObservation(o, value);
    }

    //add a CategoryObservation to the obarray
    public void addCategoryObservation(String code, String name, String value){
        ObservationType c = new ObservationType(code, name);
        obArray[oCount++] = new CategoryObservation(c, value);
    }

    //retrieve ID
    public String getID(){
        return ID;
    }

    //retrieve name
    public String getName(){
        return name;
    }

    //retrieve oCount
    public int getOCount(){
        return oCount;
    }

    //retrieve obarray
    public Observation[] getObArray() {
        return obArray;
    }
    //convert id, name and observations to a string
    public String toString() {
        String temp = "";
        System.out.println(oCount);
        for(int i = 0; i < oCount; i++){ //to get the observations, iterate through obarray
           temp += obArray[i] + " \n";
            }
        return "Patient ID: " + ID + ", Name: " + name + "\nObservations: \n - " + temp;
    }
    
}