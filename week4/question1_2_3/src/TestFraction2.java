/*
 * Title: Lab Week 4 - Question 1, 2, and 3
 * Author: Vimalnath Nambiar
 * Date: 20-08-2023
 * File: TestFraction.java
 * 
 * Purpose: 
 * - A client class to use Fraction class methods or instance variables to add any number of non-zero fractions
 * - Display running total as an exact fraction (simplified form)
 * 
 * Assumptions/Conditions:
 * Question 3
 * ---
 * - Add any number of non-zero fractions
 * - Exit program by entering a fraction that represents a zero fraction
 */

// Import libraries/dependencies
import java.util.*;

// TestFraction2 class
public class TestFraction2 {
    // Main method
    public static void main(String[] args) {
        // Initialise scanner object to retrieve user input
        Scanner kb = new Scanner(System.in);

        // Initialise object of Fraction class
        Fraction fracTotal = new Fraction(0, 1);

        // Start loop to accept user input
        while (true) {
            // Retrieve user input for numerator and denominator value
            System.out.print("Enter the numerator value (Enter 0 to exit program): ");
            int numerator = kb.nextInt();

            // Check if a numerator is 0 for zero fraction
            if (numerator == 0) {
                System.out.println("\nExiting program now");
                break;
            }

            System.out.print("Enter the denominator value: ");
            int denominator = kb.nextInt();

            // Check if denominator equals 0
            if (denominator != 0) {
                // Create instance of Fraction class with given values
                Fraction frac = new Fraction(numerator, denominator);

                // Add fraction
                fracTotal = fracTotal.add(frac);

                // Display running total
                System.out.println("Running total: " + fracTotal.outputFraction());
            } else {
                System.out.println("\nDenominator cannot be zero. Please enter a valid fraction value.\n");
            }

        }
        kb.close();
    }
}
