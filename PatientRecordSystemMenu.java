import java.io.*;
import java.util.*;

public class PatientRecordSystemMenu extends PatientRecordSystem{

    public static void main(String [] args) throws Exception{
        PatientRecordSystem prs = new PatientRecordSystem();
        systemMenu(prs);
    }

    //Display the menu of options for the record system
    public static void systemMenu(PatientRecordSystem prs){
        
        //make new Patient record system
        
        System.out.println(prs);

        //scanner to get input after the menu is displayed
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("=====================");
        System.out.println("Patient Record System");
        System.out.println("=====================");
        System.out.println("1. Add a measurement observation type");
        System.out.println("2. Add a category observation type");
        System.out.println("3. Add a patient");
        System.out.println("4. Add a measurement observation");
        System.out.println("5. Add a category observation");
        System.out.println("6. Display details of an observation type");
        System.out.println("7. Display a patient record by the patient id");
        System.out.println("8. Save data");
        System.out.println("9. Load data");
        System.out.println("D. Display all data for inspection");
        System.out.println("X. Exit");
        System.out.print("Please enter an option (1-9 or D or X): ");

        //get the users choice, store it as a string
        String userSelection = userInput.nextLine();

        //if statements for each selection, and an else to handle invalid inputs
        //add a measurement observation type
        if(userSelection.equals("1")){
            String a, b, c;
            System.out.print("Enter observation type code: "); //ask for user to input code etc, store responses in separate variables
            a = userInput.nextLine();
            System.out.print("Enter observation type name: ");
            b = userInput.nextLine();
            System.out.print("Enter the unit: ");
            c = userInput.nextLine();
            prs.addMeasurementObservationType(a, b, c);
            System.out.println("Success!");
            systemMenu(prs);
        }

        //add a category observation type
        else if(userSelection.equals("2")){
            String a, b, c;
            System.out.print("Enter observation type code: ");
            a = userInput.nextLine();
            System.out.print("Enter observation type name: ");
            b = userInput.nextLine();
            System.out.print("Please enter your categories, separated with commas: "); // this is wrong, didnt read the appendix before i wrote it
            c = userInput.nextLine().replace(", ", ","); //remove spaces after , (semicolon)
            String[] ctg = c.split(",");
            prs.addCategoryObservationType(a, b, ctg);
            System.out.println("Success!");
            systemMenu(prs);
        }

        //add a patient
        else if(userSelection.equals("3")){
            String a, b;
            System.out.print("Enter patient ID: ");
            a = userInput.nextLine();
            System.out.print("Enter patient name: ");
            b = userInput.nextLine();
            prs.addPatient(a, b);
            System.out.println("Success!");
            systemMenu(prs);
        
        }

        //add a measurement observation
        else if(userSelection.equals("4")){
            String a, b;
            int c;
            System.out.print("Enter patient ID: ");
            a = userInput.nextLine();
            System.out.print("Enter observation type code: ");
            b = userInput.nextLine();
            System.out.print("Enter observation type value: ");
            c = Integer.valueOf(userInput.nextLine());
            prs.addMeasurementObservation(a, b, c);
            System.out.println("Success!");
            systemMenu(prs);
        }

        //add a category observation
        else if(userSelection.equals("5")){
            String a, b, c;
            System.out.print("Please enter the patients ID: ");
            a = userInput.nextLine();
            System.out.print("Enter observation type code: ");
            b = userInput.nextLine();
            System.out.print("Enter observation type value: ");
            c = userInput.nextLine();
            prs.addCategoryObservation(a, b, c);
            System.out.println("Success!");
            systemMenu(prs);
        }

        //display details of an observation type
        else if(userSelection.equals("6")){
            String a;
            System.out.println("Enter the observation type code: ");
            a = userInput.nextLine();
        }

        //display patient record from id
        else if(userSelection.equals("7")){
            String a;
            System.out.println("Enter the patient ID: ");
            a = userInput.nextLine();
            
        }

        //save data to files //prs.saveData();
        else if(userSelection.equals("8")){
            
            try {
                prs.saveData();
                System.out.println("Success!");
            }
            catch (Exception e) { //if problems occur
                System.out.println("An error occurred while loading data: " + e.getMessage());
            }
        }

        //load data from files //prs.loadData();
        else if(userSelection.equals("9")){
            try {
                prs.loadData();
                System.out.println("Success!");
                systemMenu(prs);
            }
            catch (Exception e) { //if problems occur
                System.out.println("An error occurred while loading data: " + e.getMessage());
            }

            
        }
        else if(userSelection.equals("D") || userSelection.equals("d")){
            System.out.println("--------------------------");
            System.out.println("PATIENT RECORD SYSTEM DATA");
            System.out.println("--------------------------");
            System.out.println(prs);
            System.out.print("Press enter to continue...");
            userInput.nextLine();
            systemMenu(prs);
        }
        else if(userSelection.equals("X") || userSelection.equals("x")){
            System.out.println("Goodbye!");
        }
        else{
            System.out.println("Invalid Input: " + userSelection);
            System.out.print("Press enter to continue...");
            userInput.nextLine();
            systemMenu(prs);
        }
    }

}