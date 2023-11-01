/*
 * Title: Assignment 2
 * Author: Vimalnath Nambiar
 * Date: 01-11-2023
 * File: Student_Research.java
 * 
 * Purpose:
 * 1. This is the base class for Research Students
 * 
 * Assumptions/Conditions:
 * 1. Derived from Student class
 * 2. Contains the following:
 *      - enrolment type
 *      - reportGrade() method
 *          - Outputs "R" to identify research student, the name (first and last name), student number (ID), overall mark, and the final grade
 */

public class Student_Research extends Student {
    /*
     * Global variable
     */
    private char enrolmentType = 'R';
    private Unit unit;

    /*
     * Constructors
     */
    // Default constructor
    public Student_Research() {
        super();
    }

    // Constructor that accepts three parameter values to initialise
    // the student instances
    public Student_Research(String firstName, String lastName, long studentID) {
        super(firstName, lastName, studentID);
    }

    /*
     * Accessors and Mutators
     */
    public char getEnrolmentType() {
        return this.enrolmentType;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public Unit getUnit() {
        return this.unit;
    }

    /*
     * Methods
     */
    // reportGrade method to display student report
    @Override
    public void reportGrade() {
        System.out.println("\nEnrolment Type: " + this.enrolmentType
                + "\nStudent Name: " + super.getFirstName() + " " + super.getLastName()
                + "\nStudent Number (ID): " + super.getStudentID()
                + "\nOverall Mark: " + ((Unit_Research) this.unit).getOverallMark()
                + "\nFinal Grade: " + ((Unit_Research) this.unit).getFinalGrade());

    }

    // recordDetail method to display all details of the record
    public void recordDetail() {
        System.out.println("\nEnrolment Type: " + this.enrolmentType
                + "\nStudent Name: " + super.getFirstName() + " " + super.getLastName()
                + "\nStudent Number (ID): " + super.getStudentID()
                + "\nProposal Mark: " + ((Unit_Research) this.unit).getProposalMark()
                + "\nDissertation Mark: " + ((Unit_Research) this.unit).getDissertationMark()
                + "\nOverall Mark: " + ((Unit_Research) this.unit).getOverallMark()
                + "\nFinal Grade: " + ((Unit_Research) this.unit).getFinalGrade());
    }
}
