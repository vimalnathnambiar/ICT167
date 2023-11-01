/*
 * Title: Assignment 2
 * Author: Vimalnath Nambiar
 * Date: 01-11-2023
 * File: Student.java
 * 
 * Purpose:
 * 1. This is a base class for Student
 * 
 * Assumptions/Conditions:
 * 1. Will consist of the following private variables: first name (given name), last name (family name/surname), student number (ID)
 * 2. Student number is an integer number of type long
 * 3. Have the following constructors and methods:
 *      - Two constructors: one without parameters (Default) and one with parameters to give initial values to all the instance variables
 *      - Necessary setters and getters
 *      - reportGrade() method
 *          - Nothing to report here. Print "There is no grade here".
 *          - To be overriden by child class
 *          - No return type
 *      - equals() method
 *          - Compares two student objects, returns true if have same student number(ID)
 *          - Has a return type of boolean
 */

public class Student {
    /*
     * Global variables
     */
    private String firstName;
    private String lastName;
    private long studentID;

    /*
     * Constructors
     */
    // Default constructor that sets default values for the instances
    public Student() {
        this.firstName = "NA";
        this.lastName = "NA";
        this.studentID = 0;

    }

    // Constructor with parameters to give initial values
    public Student(String firstName, String lastName, long studentID) {
        // Initialise instances
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentID = studentID;
    }

    /*
     * Accessors & Mutators
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setStudentID(long studentID) {
        this.studentID = studentID;
    }

    public long getStudentID() {
        return this.studentID;
    }

    /*
     * Methods
     */
    // reportGrade method to display report
    public void reportGrade() {
        System.out.println("\nThere is no grade here.");
    }

    // equals method to compare to Student objects
    // based on their student number (ID)
    public boolean equals(Student student) {
        return this.getStudentID() == student.getStudentID();
    }

}
