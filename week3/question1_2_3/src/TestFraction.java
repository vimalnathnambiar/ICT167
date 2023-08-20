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

// Import libraries/dependencies
import java.util.*;

// TestFraction class
public class TestFraction {
    // Main method
    public static void main(String[] args) {

        // Initialise scanner object to retrieve user input
        Scanner kb = new Scanner(System.in);

        // Create an object instance of class Fraction
        // frac is an object referencing to class Fraction
        Fraction frac = new Fraction();

        while (true) {
            // Retrieve user input for numerator and denominator value
            System.out.print("Enter the numerator value: ");
            int numerator = kb.nextInt();

            // Check if a negative value was inputted by user for numerator
            // If negative, break out of loop to exit program
            if (numerator < 0) {
                System.out.println("\nExiting program now");
                break;
            }

            System.out.print("Enter the denominator value: ");
            int denominator = kb.nextInt();

            // Check if denominator equals 0
            if (denominator != 0) {
                // Set numerator and denominator values to object frac
                frac.setNumerator(numerator);
                frac.setDenominator(denominator);

                // Get numerator and denominator values stored in the object reference
                System.out.println("Numerator stored: " + frac.getNumerator());
                System.out.println("Denominator stored: " + frac.getDenominator());

                // Output fraction
                System.out.println("Fraction: " + frac.outputFraction());
            } else {
                System.out.println("\nDenominator cannot be zero. Please enter a valid fraction value.\n");
            }
        }
        // Close scanner object
        kb.close();
    }

}
