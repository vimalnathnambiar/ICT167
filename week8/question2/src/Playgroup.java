/*
 * Title: Lab Week 8 - Question 2
 * Author: Vimalnath Nambiar
 * Date: 31-10-2023
 * File: Playgroup.java
 * 
 * Purpose: 
 * - Class to represent Playgroup records
 * 
 * Assumptions/Conditions:
 * - Derived from class Baby
 * - Has name and age (inherited from Baby)
 * - Has necessary constructors and accessor methods
 * - Has an equal method for Playgroup class
 *      - Considered equal if name and age are the same
 * - babySound method will print "Baby sound is HAPPY"
 */

public class Playgroup extends Baby{
    // Default constructor
    public Playgroup(){
        super();
    }

    // Constructor with two parameters
    public Playgroup(String name, int age){
        super(name,age);
    }

    // No Accessor and Getter methods
    // Can inherit method from parent

    // Equal method
    // Can inherit from parent

    // Method to print baby sound
    public void babySound(){
        System.out.println("Baby sound is HAPPY");
    }

    // Method to return baby sound
    public String getBabySound(){
       return "Baby sound is HAPPY";
    }  
}
