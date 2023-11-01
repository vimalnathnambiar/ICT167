/*
 * Title: Assignment 2
 * Author: Vimalnath Nambiar
 * Date: 01-11-2023
 * File: Unit_Research.java
 * 
 * Purpose:
 * 1. This is a base class for Research Unit
 * 
 * Assumptions/Conditions:
 * 1. Renamed from Research to Unit_Research to provide standardization in class names
 * 2. Derived from Unit class
 * 3. Has proposal mark 
 *      - Marked out of a maximum of 100
 *      - Marks are recorded separately
 *      - int type (Assuming marks are given as a whole number)
 * 4. Has dissertation mark
 *      - Marked out of a maximum of 100
 *      - Marks are recorded separately
 *      - int type (Assuming marks are given as a whole number)
 * 5. There is an overall mark (calculated within the class)
 *      - int type (Assuming marks are given as a whole number)
 *      - Formula = (((proposal mark / 100) * 35) + ((dissertation mark / 100) * 65))
 * 6. There is a final grade (String type)
 *      - Awarded on the basis of overall mark
 *      - overall mark >= 80 (HD)
 *      - overall mark >= 70 && < 80 (D)
 *      - overall mark >= 60 && < 70 (C)
 *      - overall mark >= 50 && < 60 (P)
 *      - overall mark < 50 (N)
 */

public class Unit_Research extends Unit {
    /*
     * Global variables
     */
    private int proposalMark;
    private int dissertationMark;
    private int overallMark;
    private String finalGrade;

    /*
     * Constructors
     */
    // Default constructor that sets default values for the instances
    public Unit_Research() {
        super('R');
        this.proposalMark = 0;
        this.dissertationMark = 0;
        calculateOverallMark();
    }

    // Constructor that accepts parameter values to initialise the instances
    public Unit_Research(int proposalMark, int dissertationMark) {
        super('R');
        this.proposalMark = proposalMark;
        this.dissertationMark = dissertationMark;
        calculateOverallMark();
    }

    /*
     * Accessors & Mutators
     */
    public void setProposalMark(int proposalMark) {
        this.proposalMark = proposalMark;
    }

    public int getProposalMark() {
        return this.proposalMark;
    }

    public void setDissertationMark(int dissertationMark) {
        this.dissertationMark = dissertationMark;
    }

    public int getDissertationMark() {
        return this.dissertationMark;
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
        double mark = (((this.proposalMark / 100.0) * 35)
                + ((this.dissertationMark / 100.0) * 65));
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
