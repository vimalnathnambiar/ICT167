/*
 * Title: Lab Week 5 - Question 2, 3 & 4
 * Author: Vimalnath Nambiar
 * Date: 08-09-2023
 * File: Baby.java
 * 
 * Purpose: 
 * - General class that will represent a Baby object
 * 
 * Assumptions/Conditions:
 * Question 3
 * ---
 * 1. Has name of type String
 * 2. Has age of type integer
 * 3. Require 2 constructors
 *      - Default constructor that sets default values for name and age
 *      - Constructor that takes two parameters (String name, int age)
 * 4. Provide setters and getters for name and age
 * 5. Class should not contain any I/O methods
 *      - Uses set method or constructor to set value 
 *      - Instance variables for output to use get method
 * 6. Set method for name need to ensure value passed isn't empty or contain whitespaces
 *      - Set default value if fail condition
 * 7. Set method for age should ensure age is between 1 and 4
 *      - Set default value if fail condition
 * 8. "equals" method to determine if Baby object is the same
 *      - Name and age is identical
 *      - Name should not be case sensitive
 *      - Take Baby type as parameter, and use the calling object for comparison
 *      - Return type boolean
 *      - Use String comparison methods
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
