/*
 * Title: Lab Week 4 - Question 1, 2, and 3
 * Author: Vimalnath Nambiar
 * Date: 20-08-2023
 * File: Fraction.java
 * 
 * Purpose: 
 * - Designed to handle fractions
 * - Add a public method called add that adds another fraction to the calling object
 * - Add private method simplify() that converts a fraction to its simplest form
 * - Add private method gcd() to determine the Greatest Common Divisor
 * 
 * Assumptions/Conditions:
 * Question 1
 * ---
 * - add method 
 *      - Take a Fraction class object as a parameter
 *      - Add this parameter fraction to the calling object (fraction)
 *      - Return a fraction object as a result
 * 
 * Question 2
 * ---
 * - simplify() and gcd() must be private methods
 *      - Methods are not to be used by the client program
 */

// Import libraries
import java.util.Scanner;

// Fraction class
public class Fraction {
    // Instance variables called numerator and denominator
    // that are hidden
    private int numerator;
    private int denominator;

    // Constructors
    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        swapSign();
    }

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
    public void getInputNumerator(Scanner kb) {
        // Retrieve user input for numerator value
        System.out.print("Enter the numerator value: ");
        this.numerator = kb.nextInt();
    }

    // Get input denominator
    public void getInputDenominator(Scanner kb) {

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

    // Adds another fraction
    public Fraction add(Fraction frac) {
        int newNumerator = (this.numerator * frac.denominator) + (frac.numerator * this.denominator);
        int newDenominator = this.denominator * frac.denominator;

        // Simplify fraction
        Fraction result = simplify(newNumerator, newDenominator);
        return result;
    }

    // Simplify fraction to its simplest form
    private Fraction simplify(int n1, int n2) {
        int gcdValue = gcd(n1, n2);
        n1 /= gcdValue;
        n2 /= gcdValue;

        Fraction result = new Fraction(n1, n2);
        return result;
    }

    // Identify the Greatest Common Divisor
    private int gcd(int n1, int n2) {
        int c;

        while (n1 != 0 && n2 != 0) {
            c = n2;
            n2 = n1 % n2;
            n1 = c;
        }

        return n1 + n2;
    }
}
