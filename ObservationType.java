public class ObservationType{
    
    //attributes
    private String code;
    private String name;

    //constructor
    public ObservationType(String code, String name){
        this.code = code;
        this.name = name;
    }

    //retrieve code
    public String getCode(){
        return code;
    }

    //retrieve name
    public String getName(){
        return name;
    }

    //convert code and name to a string
    public String toString() {
        return "Code: " + code + ", Name: " + name;
    }
    
}