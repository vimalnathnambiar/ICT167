/*
 * Title: Lab Week 3 - Question 1, 2, and 3
 * Author: Vimalnath Nambiar
 * Date: 13-08-2023
 * File: TestFraction.java
 * 
 * Purpose: 
 * - A client class to use Fraction class methods or instance variables to get inputs and display fractions
 * 
 * Assumptions/Conditions:
 * Question 1
 * ---
 * - Use a loop for getting fractions
 * - Stop loop when a negative value entered for the numerator
 * 
 * Question 2
 * ---
 * - Ensure input values representing fractions are stored with denominators that are positive integers
 * - User should not be restricted to only enter positive integer
 * - Swap the sign of both numerator and denominator instance variables
 * 
 * Other:
 * - Write pseudocode before coding the class and the client program
 */

// TestFraction class
public class TestFraction {
    // Main method
    public static void main(String[] args) {
        // Create an object instance of class Fraction
        // frac is an object referencing to class Fraction
        Fraction frac = new Fraction();

        while (true) {
            // Get user input for numerator
            frac.getInputNumerator();

            // Check if a negative value was inputted by user for numerator
            // If negative, break out of loop to exit program
            if (frac.getNumerator() < 0) {
                System.out.println("\nExiting program now");
                break;
            }

            // Get user input for denominator
            frac.getInputDenominator();

            // Output fraction
            System.out.println("Fraction: " + frac.outputFraction());
        }
    }

}
