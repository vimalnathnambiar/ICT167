/*
 * Title: Assignment 2
 * Author: Vimalnath Nambiar
 * Date: 01-11-2023
 * File: Unit_Course.java
 * 
 * Purpose:
 * 1. This is a base class for Course Units
 * 
 * Assumptions/Conditions:
 * 1. Derived from Unit class
 * 2. Has the following information
 *      - unit ID (String type)
 *      - unit level (integer type)
 * 3. Has two assignments
 *      - Each marked out of maximum of 100 marks and equally weighted
 *      - Marks are recorded separately
 *      - int type (Assuming marks are given as a whole number)
 * 4. There is one final examination
 *      - Marked out of maximum of 100 marks
 *      - Also recorded separately
 *      - int type (Assuming marks are given as a whole number)
 * 5. There is an overall mark (calculated within the class)
 *      - int type (Assuming marks are given as a whole number)
 *      - Formula = (((Assignment 1 mark / 100) * 25) + ((Assignment 2 mark / 100) * 25) + ((Final examination mark / 100) * 50))
 * 6. There is a final grade (String type)
 *      - Awarded on the basis of overall mark
 *      - overall mark >= 80 (HD)
 *      - overall mark >= 70 && < 80 (D)
 *      - overall mark >= 60 && < 70 (C)
 *      - overall mark >= 50 && < 60 (P)
 *      - overall mark < 50 (N)
 */

public class Unit_Course extends Unit {
    /*
     * Global variables
     */
    private String unitID;
    private int unitLevel;
    private int assignmentMark1;
    private int assignmentMark2;
    private int finalExamMark;
    private int overallMark;
    private String finalGrade;

    /*
     * Constructors
     */
    // Default constructor that sets default values for the instances
    public Unit_Course() {
        super('C');
        this.unitID = "NA";
        this.unitLevel = 0;
        this.assignmentMark1 = 0;
        this.assignmentMark2 = 0;
        this.finalExamMark = 0;
        calculateOverallMark();
    }

    // Constructor that accepts parameter values to initialise the instances
    public Unit_Course(String unitID, int unitLevel, int assignmentMark1, int assignmentMark2, int finalExamMark) {
        super('C');
        this.unitID = unitID;
        this.unitLevel = unitLevel;
        this.assignmentMark1 = assignmentMark1;
        this.assignmentMark2 = assignmentMark2;
        this.finalExamMark = finalExamMark;
        calculateOverallMark();
    }

    /*
     * Accessors & Mutators
     */
    public void setUnitID(String unitID) {
        this.unitID = unitID;
    }

    public String getUnitID() {
        return this.unitID;
    }

    public void setUnitLevel(int unitLevel) {
        this.unitLevel = unitLevel;
    }

    public int getUnitLevel() {
        return this.unitLevel;
    }

    public void setAssignmentMark1(int assignmentMark1) {
        this.assignmentMark1 = assignmentMark1;
    }

    public int getAssignmentMark1() {
        return this.assignmentMark1;
    }

    public void setAssignmentMark2(int assignmentMark2) {
        this.assignmentMark2 = assignmentMark2;
    }

    public int getAssignmentMark2() {
        return this.assignmentMark2;
    }

    public void setFinalExamMark(int finalExamMark) {
        this.finalExamMark = finalExamMark;
    }

    public int getFinalExamMark() {
        return this.finalExamMark;
    }

    public int getOverallMark() {
        return this.overallMark;
    }

    public String getFinalGrade() {
        return this.finalGrade;
    }

    /*
     * Methods
     */
    // calculateOverallMark
    public void calculateOverallMark() {
        double mark = (((this.assignmentMark1 / 100.0) * 25)
                + ((this.assignmentMark2 / 100.0) * 25)
                + ((this.finalExamMark / 100.0) * 50));
        this.overallMark = (int) mark;

        setFinalGrade();
    }

    // setFinalGrade to set the final grade
    public void setFinalGrade() {
        if (this.overallMark >= 80 && this.overallMark <= 100) {
            this.finalGrade = "HD";
        } else if (this.overallMark >= 70 && this.overallMark < 80) {
            this.finalGrade = "D";
        } else if (this.overallMark >= 60 && this.overallMark < 70) {
            this.finalGrade = "C";
        } else if (this.overallMark >= 50 && this.overallMark < 60) {
            this.finalGrade = "P";
        } else {
            this.finalGrade = "N";
        }
    }
}
