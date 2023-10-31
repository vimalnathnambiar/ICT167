/*
 * Title: Lab Week 10 - question 1 and 2
 * Author: Vimalnath Nambiar
 * Date: 31-10-2023
 * File: Baby.java
 * 
 * Purpose: 
 * - General class that will represent a Baby object
 * 
 * Assumptions/Conditions:
 * - 
 */

public class Baby {
    private String name;
    private int age;

    /*
     * Constructors
     */
    // Default constructor
    public Baby() {
        this.name = "Baby";
        this.age = 1;
    }

    // Constructor that takes two parameters (String name, integer age)
    public Baby(String name, int age) {
        setName(name);
        setAge(age);
    }

    /*
     * Setters and Getters
     */
    public void setName(String name) {
        if (name.isBlank()) {
            System.out.println("Baby name can't be empty or contain whitespaces");
            System.out.println("Setting default name: Baby");

            this.name = "Baby";
        } else {
            this.name = name;
        }
    }

    public String getName() {
        return this.name;
    }

    public void setAge(int age) {
        if (!(age >= 1 && age <= 4)) {
            System.out.println("Baby's age needs to be between 1 and 4");
            System.out.println("Setting default age: 1");
            this.age = 1;
        } else {
            this.age = age;
        }
    }

    public int getAge() {
        return this.age;
    }

    /*
     * Other methods
     */

    // Method to check for identical babies
    public boolean equals(Baby baby) {
        if (this.name.equalsIgnoreCase(baby.getName()) && this.age == baby.getAge()) {
            return true;
        }
        return false;
    }
}
