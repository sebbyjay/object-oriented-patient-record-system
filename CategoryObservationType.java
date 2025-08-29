public class CategoryObservationType extends ObservationType{
    
    //attributes
    private String[] categories;

    //constructor
    public CategoryObservationType(String code, String name, String[] categories){
        super(code, name);
        this.categories = categories;
    }
    
    //retreive code
    public String getCode(){
        return super.getCode();
    }

    //retrieve name
    public String getName(){
        return super.getName();
    }

    //retrieve categories
    public String getCategories(){
        String c = "";
        for(int i = 0; i < categories.length; i++){ //interate through the categories array
            if(i == categories.length - 1){ //if else so that a comma doesnt get put at the end of the list
                c += categories[i];
            }
            else{
                c += categories[i] + ", ";
            }
            
        }
        return c;
    }

    

    //convert categories and its inherited attributes to a string
    public String toString() {
        String temp = "";
        for(int i = 0; i < categories.length; i++){ // iterate through the categories array, add | bars around the categories
            temp += categories[i] + " | ";
        }
        return super.toString() + ", Categories: " + "| " + temp;
    }

}