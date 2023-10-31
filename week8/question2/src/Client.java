/*
 * Title: Lab Week 8 - Question 2
 * Author: Vimalnath Nambiar
 * Date: 31-10-2023
 * File: Client.java
 * 
 * Purpose: 
 * - A client program class to store information about 4 babies
 * 
 * Assumptions/Conditions:
 * - Enter details for patient (name, age and identification number) - Patient object
 * - Enter details for baby (name, age) - Baby object
 * - Enter details for baby (name, age) - Playgroup object
 * - Enter details for baby (name, age) - Baby object
 * - Output details of patient (name, age, and identification number) - and output baby sound
 * - Output details of Playgroup (name, age) - and output baby sound
 * - Output all information stored (including baby sound) to a file (Baby.txt)
 */

 // Import java libraries
 import java.io.*;

public class Client {
    // Initialise global, static, or final variables
    static final int arraySize = 4;
    static Baby[] babyArray = new Baby[arraySize];

    /*
     * Main Method
     */
    public static void main(String[] args) {
        // Initialise array with baby records
        initArray();

        // Display Patient records
        System.out.print("\nPatient Records\n---");
        displayRecord("Patient");

        // Display Playgroup records
        System.out.print("\nPlaygroup Records\n---");
        displayRecord("Playgroup");

        // Display all records
        System.out.print("\nAll Records\n---");
        displayRecord("All");

        // Write records to file
        writeToFile();
    }

    /*
     * Method to initialise baby objects to the arrays
     */
    private static void initArray(){
        babyArray[0] = new Patient("Vimal", 2, 100);
        babyArray[1] = new Baby("John", 1);
        babyArray[2] = new Playgroup("Mary", 3);
        babyArray[3] = new Baby("Jacob", 4);
    }

    /*
     * Method to display records of a specific baby type object (Baby, Patient, Playgroup)
     */
    private static void displayRecord(String babyType){
        for(Baby baby : babyArray){
            if(babyType == "Patient"){
                if(baby instanceof Patient){
                    System.out.println("\nName: " + baby.getName() + "\nAge: " + baby.getAge() + "\nIdentification Number: " + ((Patient) baby).getIdentificationNumber());
                    baby.babySound();
                }
            } else if(babyType == "Playgroup"){
                if(baby instanceof Playgroup){
                    System.out.println("\nName: " + baby.getName() + "\nAge: " + baby.getAge());
                    baby.babySound();
                }
            } else if(babyType == "Baby"){
                if(baby instanceof Playgroup){
                    System.out.println("\nName: " + baby.getName() + "\nAge: " + baby.getAge());
                    baby.babySound();
                }
            } else if(babyType == "All"){
                System.out.println("\nName: " + baby.getName() + "\nAge: " + baby.getAge());
                baby.babySound();
            }
        }
    }

    /*
     * Method to write records to file
     */
    private static void writeToFile(){
        try{
            PrintWriter outputWriter = new PrintWriter(new FileWriter("Baby.txt"));

            // Write records to file
            for(Baby baby: babyArray){
                if(baby instanceof Patient){
                    outputWriter.println("Name: " + baby.getName() + "\nAge: " + baby.getAge() + "\nIdentification Number: " + ((Patient) baby).getIdentificationNumber() + "\nSound: " + baby.getBabySound() + "\n");
                } else{
                    outputWriter.println("Name: " + baby.getName() + "\nAge: " + baby.getAge() + "\nSound: " + baby.getBabySound() + "\n");
                }
            }
            outputWriter.close();
        } catch(IOException e){
            System.out.println("Error writing to file!");
            System.out.println(e.getMessage());
        } catch (Exception e){
            System.out.println("An error occurred");
            System.out.println(e.getMessage());
        }
    }
}
