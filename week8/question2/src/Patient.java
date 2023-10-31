/*
 * Title: Lab Week 8 - Question 2
 * Author: Vimalnath Nambiar
 * Date: 31-10-2023
 * File: Patient.java
 * 
 * Purpose: 
 * - Class to represent Patient records
 * 
 * Assumptions/Conditions:
 * - Derived from class Baby
 * - Has name and age (inherited from Baby), and identification number (uses type int)
 * - Has necessary constructors and accessor methods
 * - Has an equal method for Patient class
 *      - Considered equal if their identification number is the same
 * - babySound method will print "Baby sound is SICK"
 */

public class Patient extends Baby{
    private int identificationNumber;

    // Default constructor
    public Patient(){
        super();
        this.identificationNumber = 0;
    }

    // Constructor that accepts name, age and identification number
    public Patient(String name, int age, int identificationNumber){
        super(name, age);
        this.identificationNumber = identificationNumber;
    }

    // Accessor and get methods
    public void setIdentificationNumber(int identificationNumber){
        this.identificationNumber = identificationNumber;
    }

    public int getIdentificationNumber(){
        return this.identificationNumber;
    }

    // Method to check for identical babies
    public boolean equals(Patient baby) {
        if (this.identificationNumber == baby.getIdentificationNumber()) {
            return true;
        }
        return false;
    }

    // Method to print baby sound
    public void babySound(){
        System.out.println("Baby sound is SICK");
    }

    // Method to return baby sound
    public String getBabySound(){
        return "Baby sound is SICK";
    }  
}
