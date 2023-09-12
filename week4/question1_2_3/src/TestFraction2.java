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

// Import libraries
import java.util.Scanner;

// TestFraction2 class
public class TestFraction2 {
    // Main method
    public static void main(String[] args) {
        // Initialise Scanner object
        Scanner kb = new Scanner(System.in);

        // Initialise object of Fraction class
        Fraction fracTotal = new Fraction();
        Fraction frac = new Fraction();

        // Start loop to accept user input
        while (true) {
            // Get user input for numerator
            frac.getInputNumerator(kb);

            // Check if a numerator is 0 for zero fraction
            if (frac.getNumerator() == 0) {
                System.out.println("\nExiting program now");
                break;
            }

            // Get user input for denominator
            frac.getInputDenominator(kb);

            // Add fraction
            fracTotal = fracTotal.add(frac);

            // Display running total
            System.out.println("Running total: " + fracTotal.outputFraction());
        }
        kb.close();
    }
}
