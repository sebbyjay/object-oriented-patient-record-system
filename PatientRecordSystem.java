import java.io.*;
import java.util.*;

public class PatientRecordSystem{

    //attributes
    private Patient[] patients;
    private int pCount;
    private ObservationType[] obType;
    private int obCount;

    //constructor
    public PatientRecordSystem(){
        patients = new Patient[100];
        pCount = 0;
        obType = new ObservationType[50];
        obCount = 0;
    }

    //add measurement observation type to obtype array
    public void addMeasurementObservationType(String code, String name, String unit){ 
        obType[obCount++] = new MeasurementObservationType(code, name, unit);
    }
    //add measurement observation to a patient array
    public void addMeasurementObservation(String patientID, String code, int value){ 
        for(int i = 0; i < pCount; i++){
            if (patients[i].getID().equals(patientID)){ //find the patient in the patients array that matches the patientID variable
                for(int j = 0; j < obCount; j++){
                    if(obType[j].getCode().equals(code)){
                        patients[i].addMeasurementObservation(patientID, code, value);
                    }
                }
            }
        }
    }
    //add a patient with attributes id and name to patients array
    public void addPatient(String ID, String name) throws IOException{
        boolean b = false;
        for(int i = 0; i < pCount; i++){
            if(patients[i].getID().equals(ID)){
                b = true;
                break;
            }
        }
        if(b == false){
            patients[pCount++] = new Patient(ID, name);
            b = false;
        }
        else{
            throw new IOException("Warning: " + ID + "is already a patient.");
        }
        
    }

    //add category observation type to obtype array
    public void addCategoryObservationType(String code, String name, String[] categories){ 
        obType[obCount++] = new CategoryObservationType(code, name, categories);
    }

    //add category observation to a patient
    public void addCategoryObservation(String patientID, String code, String value){ 
        for(int i = 0; i < pCount; i++){
            if (patients[i].getID().equals(patientID)){
                for(int j = 0; j < obCount; j++){
                    if(obType[j].getCode().equals(code)){
                        patients[i].addCategoryObservation(patientID, code, value);
                    }
                }
            }
        }
    }

    public void saveData() throws Exception{ //save data collected in the record system to separate text files based on their types
        
        /* ---------------------------------WORKS flawlessly----------------------------------------- */
        
        //make new files, object for each
        FileWriter mOTFile = new FileWriter("PRS-MeasurementObservationTypes.txt");
        FileWriter cOTFile = new FileWriter("PRS-CategoryObservationTypes.txt");
        for(int i = 0; i < obCount; i++){
            //save measurement observation type data to file mOTFile
            if(obType[i] instanceof MeasurementObservationType){
                MeasurementObservationType save = (MeasurementObservationType)obType[i];
                mOTFile.write(save.getCode() + "; " + save.getName() + "; " + save.getUnit() + "\n");
            }
            //save category observation type data to file cOTFile
            if(obType[i] instanceof CategoryObservationType){
                CategoryObservationType save = (CategoryObservationType)obType[i];
                cOTFile.write(save.getCode() + "; " + save.getName() + "; " + save.getCategories() + "\n");
            }
        }
        //close the files that have been written
        mOTFile.close();
        cOTFile.close();

        //make new file, for the patients, etc
        FileWriter pFile = new FileWriter("PRS-Patients.txt");
        FileWriter mOFile = new FileWriter("PRS-MeasurementObservations.txt");
        FileWriter cOFile = new FileWriter("PRS-CategoryObservations.txt");
        for(int i = 0; i < pCount; i++){
            //save patients data to file
            Patient save = patients[i];
            Observation[] o = save.getObArray();
            pFile.write(save.getID() + "; " + save.getName() + "\n");
            for(int j = 0; j < save.getOCount(); j++){
                //save measurement observations to file
                if(o[j] instanceof MeasurementObservation){
                    MeasurementObservation m = (MeasurementObservation)o[j];
                    mOFile.write(save.getID() + "; " + m.getOType().getName() + "; " + m.getValue() + "\n"); //get id from patient, oType and value from measurement observation
                }
                //save category observations to file
                if(o[j] instanceof CategoryObservation){
                    CategoryObservation c = (CategoryObservation)o[j];
                    cOFile.write(save.getID() + "; " + c.getOType().getName() + "; " + c.getValue() + "\n"); //same for categories, but from category observations
                }
            }
        }
        //close written files
        pFile.close();       
        mOFile.close();
        cOFile.close();
    }

    public void loadData() throws Exception{

        //initialise scanners for each file being read
        Scanner mOTReader = new Scanner(new File("PRS-MeasurementObservationTypes.txt"));
        Scanner cOTReader = new Scanner(new File("PRS-CategoryObservationTypes.txt"));
        Scanner pReader = new Scanner(new File("PRS-Patients.txt"));
        Scanner mOReader = new Scanner(new File("PRS-MeasurementObservations.txt"));
        Scanner cOReader = new Scanner(new File("PRS-CategoryObservations.txt"));

        //go through each line, split it, turn it into a string, feed it into a new measurement observation type
        while(mOTReader.hasNextLine()) {
            String line = mOTReader.nextLine().replace("; ", ";");
            String[] split = line.split(";");
            String a = split[0];
            String b = split[1];
            String c = split[2];
            addMeasurementObservationType(a, b, c);
        }
        //do the same for category observation type
        while(cOTReader.hasNextLine()) {
            String line = cOTReader.nextLine().replace("; ", ";");
            String[] split = line.split(";");
            String a = split[0];
            String b = split[1];
            String[] c = split[2].split(",");
            addCategoryObservationType(a, b, c);
        }//and patient
        while(pReader.hasNextLine()) {
            String line = pReader.nextLine().replace("; ", ";");
            String[] split = line.split(";");
            String a = split[0];
            String b = split[1];
            addPatient(a, b);
        }
        while(mOReader.hasNextLine()) {
            String line = mOReader.nextLine().replace("; ", ";");
            String[] split = line.split(";");
            String a = split[0];
            String b = split[1];
            int c = Integer.valueOf(split[2]);
            addMeasurementObservation(a, b, c);
        }
        while(cOReader.hasNextLine()) {
            String line = cOReader.nextLine().replace("; ", ";");
            String[] split = line.split(";");
            String a = split[0];
            String b = split[1];
            String c = split[2];
            addCategoryObservation(a, b, c);
        }

    }

    public String toString(){ //convert the record system to string
        String temp = "";
        String temp2 = "";
        for(int i = 0; i < obCount; i++){ //interate through obtype array
            temp += obType[i].toString() + " \n";
        }
        for(int i = 0; i < pCount; i++){ //iterate through patients array
            temp2 += patients[i].toString() + " \n";
            }
        
        return "OBSERVATIONS:\n"+ temp + "\n" + "PATIENTS:\n" + temp2;
    }
    
}