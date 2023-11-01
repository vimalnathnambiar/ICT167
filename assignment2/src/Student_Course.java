/*
 * Title: Assignment 2
 * Author: Vimalnath Nambiar
 * Date: 01-11-2023
 * File: Student_Course.java
 * 
 * Purpose:
 * 1. This is a base class for Course Students
 * 
 * Assumptions/Conditions:
 * 1. Derived from Student class
 * 2. Contains the following:
 *      - enrolment type
 *      - reportGrade() method
 *          - Outputs "C" to identify course work student, the name (first and last name), student number (ID), unit ID, overall mark, and the final grade
 */

public class Student_Course extends Student {
    /*
     * Global variable
     */
    private char enrolmentType = 'C';
    private Unit unit;

    /*
     * Constructors
     */
    // Default constructor
    public Student_Course() {
        super();
    }

    // Constructor that accepts three parameters to initialise student details
    public Student_Course(String firstName, String lastName, long studentID) {
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
                + "\nUnit ID: " + ((Unit_Course) this.unit).getUnitID()
                + "\nOverall Mark: " + ((Unit_Course) this.unit).getOverallMark()
                + "\nFinal Grade: " + ((Unit_Course) this.unit).getFinalGrade());

    }

    // recordDetail method to display all details of the record
    public void recordDetail() {
        System.out.println("\nEnrolment Type: " + this.enrolmentType
                + "\nStudent Name: " + super.getFirstName() + " " + super.getLastName()
                + "\nStudent Number (ID): " + super.getStudentID()
                + "\nUnit ID: " + ((Unit_Course) this.unit).getUnitID()
                + "\nUnit Level: " + ((Unit_Course) this.unit).getUnitLevel()
                + "\nAssignment 1 Mark: " + ((Unit_Course) this.unit).getAssignmentMark1()
                + "\nAssignment 2 Mark: " + ((Unit_Course) this.unit).getAssignmentMark2()
                + "\nFinal Exam Mark: " + ((Unit_Course) this.unit).getFinalExamMark()
                + "\nOverall Mark: " + ((Unit_Course) this.unit).getOverallMark()
                + "\nFinal Grade: " + ((Unit_Course) this.unit).getFinalGrade());
    }
}
