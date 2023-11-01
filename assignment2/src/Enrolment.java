/*
 * Title: Assignment 2
 * Author: Vimalnath Nambiar
 * Date: 01-11-2023
 * File: Enrolment.java
 * 
 * Purpose:
 * 1. This is class to store details of students and their corresponding course unit
 * 
 * Assumptions/Conditions:
 * 
 */

public class Enrolment {
    private Student student;
    private Unit unit;

    /*
     * Constructors
     */
    // Default constructor
    public Enrolment() {

    }

    // Constructor that accepts Student object and Unit object to be stored
    public Enrolment(Student student, Unit unit) {
        this.student = student;
        this.unit = unit;
    }

    /*
     * Accessors and Mutators
     */
    // No direct mutators present
    public Student getStudent() {
        return this.student;
    }

    public Unit getUnit() {
        return this.unit;
    }

}
