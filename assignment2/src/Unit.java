/*
 * Title: Assignment 2
 * Author: Vimalnath Nambiar
 * Date: 01-11-2023
 * File: Unit.java
 * 
 * Purpose:
 * 1. This is a base class for Unit
 * 
 * Assumptions/Conditions:
 * 1. Has the following
 *      - Enrolment type: "C" for course work enrolment and "R" for research enrolment
 *      - reportFinalGrade() method
 *          - Displays "NA" for not available
 */

public class Unit {
    /*
     * Global variables
     */
    private char enrolmentType;

    /*
     * Constructors
     */
    // Default constructor
    public Unit() {

    }

    // Constructor with one parameter value to initialise enrolment type
    public Unit(char enrolmentType) {
        this.enrolmentType = enrolmentType;
    }

    /*
     * Accessors & Mutators
     */
    public void setEnrolmentType(char enrolmentType) {
        this.enrolmentType = enrolmentType;
    }

    public char getEnrolmentType() {
        return this.enrolmentType;
    }

    /*
     * Methods
     */
    // reportFinalGrade to display the final grade
    public void reportFinalGrade() {
        System.out.println("\nNA");
    }

}
