/*
 * Title: Lab Week 3 - Question 1, 2, and 3
 * Author: Vimalnath Nambiar
 * Date: 13-08-2023
 * File: Fraction.java
 * 
 * Purpose: 
 * - Designed to handle fractions
 * 
 * Assumptions/Conditions:
 * Question 1
 * ---
 * - Contains two instance variables
 *      - numerator (int) and denominator (int)
 *      - publicly accessible
 * - Should never store a value of 0 for the denominator
 * - Supply an output method to print out a fraction (as two separate integers) (numerator / denominator)
 * 
 * Question 3
 * ---
 * - Ensure instance variables are hidden
 * - Implement appropriate accessor and mutator methods
 * 
 * 
 * Other:
 * - Write pseudocode before coding the class and the client program
 * - Understand why your client class can't compile when instance variable is switched to hidden
 */

// Fraction class
public class Fraction {
    // // Two instance variables called numerator and denominator
    // // that are publicly available
    // public int numerator;
    // public int denominator;

    // Two instance variables called numerator and denominator
    // that are hidden
    private int numerator;
    private int denominator;

    // Mutator methods
    // Set numerator value
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    // Set denominator value
    // Also checks if the denominator = 0 or negative value
    public void setDenominator(int denominator) {
        // Check denominator input
        // If negative, swap sign of both numerator and denominator instance variables
        if (denominator < 0) {
            setNumerator(-numerator);
            denominator = -denominator;
        }
        this.denominator = denominator;
    }

    // Accessor Methods
    // Returns numerator value
    public int getNumerator() {
        return numerator;
    }

    // Return denominator value
    public int getDenominator() {
        return denominator;
    }

    // Return fraction in the form of numerator / denominator
    public String outputFraction() {
        return this.numerator + " / " + this.denominator + "\n";
    }
}
