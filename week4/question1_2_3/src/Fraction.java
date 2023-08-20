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

    // Constructors
    public Fraction() {

    }

    public Fraction(int numerator, int denominator) {
        // Check denominator input
        // If negative, swap sign of both numerator and denominator instance variables
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    // Mutator methods
    // Set numerator value
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    // Set denominator value
    // Also checks if the denominator = 0 or negative value
    public void setDenominator(int denominator) {
        // Check denominator input
        // If negative, swap sign of both numerator and denominator instance
        // variables
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

    // Other methods
    // Output fraction in the form of numerator / denominator
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
