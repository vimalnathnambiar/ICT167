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

// Import libraries
import java.util.Scanner;

// Fraction class
public class Fraction {
    // Private scanner object
    private Scanner kb = new Scanner(System.in);

    // Instance variables called numerator and denominator
    // that are hidden
    private int numerator;
    private int denominator;

    // Mutator methods
    // Set numerator value
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    // Set denominator value
    public void setDenominator(int denominator) {
        this.denominator = denominator;
        swapSign();
    }

    // Accessor Methods
    // Returns numerator value
    public int getNumerator() {
        return this.numerator;
    }

    // Return denominator value
    public int getDenominator() {
        return this.denominator;
    }

    // Get input numerator
    public void getInputNumerator() {
        // Retrieve user input for numerator value
        System.out.print("Enter the numerator value: ");
        this.numerator = kb.nextInt();
    }

    // Get input denominator
    public void getInputDenominator() {

        do {
            // Retrieve user input for denominator value
            System.out.print("Enter the denominator value: ");
            this.denominator = kb.nextInt();

            if (this.denominator == 0) {
                System.out.println("\nError! Denominator cannot be zero.\n");
            }
        } while (this.denominator == 0);

        swapSign();
    }

    // Swap denominator and numerator signs
    public void swapSign() {
        // If negative, swap sign of both numerator and denominator instance variables
        if (this.denominator < 0) {
            this.numerator = -this.numerator;
            this.denominator = -this.denominator;
        }
    }

    // Return fraction in the form of numerator / denominator
    public String outputFraction() {
        return this.numerator + " / " + this.denominator + "\n";
    }
}
