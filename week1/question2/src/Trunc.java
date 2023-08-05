
// Imported libraries
import java.util.Scanner;

/*
 * Title: Lab Week 1 - Question 2
 * Author: Vimalnath Nambiar
 * Date: 31-07-2023
 * File: Trunc.java
 * 
 * Purpose: 
 * - Acquire floating point number
 * - Display both the number and running total to the nearest whole number
 * 
 * Assumptions/Conditions:
 * - Input to accept a floating point number
 * - Use loop to receive input
 * - Output is to display both the number inputted by user and the running total to the nearest whole number
 * - Uses an out of range number (<-100 or >100) to exit the program
 */

// Trunc Class
public class Trunc {
    // Main Method
    public static void main(String[] args) {
        // Initialise scanner object for input
        Scanner input = new Scanner(System.in);

        // Initialise variables to store total and flag for loop
        double total = 0;
        boolean flag = true;

        System.out.println("Use an out of range entry <-100 or >100 to quit.");

        // Start of loop to acquire user input
        while (flag) {
            // Retrieve user input using input scanner object
            // Accepts floating point number
            System.out.println("Enter a number on a line:");
            double d = input.nextDouble();

            // Condition to check if d inputted by user falls out of range
            // If true, set flag = false
            // Else display d and total to the nearest whole number
            if (outOfRange(d)) {
                flag = false;
            } else {
                dispWholeNum("The number value is: ", d);
                total = total + d;
                dispWholeNum("The total is: ", total);

                System.out.println();
                System.out.println("Next.");
            }
        }
        input.close();
        System.out.println("You quit.");
    }

    /*
     * Method to check if the user inputted number (d) falls out of range
     */
    static boolean outOfRange(double d) {
        // Returns true if d is lesser than -100
        if (d < -100)
            return true;

        // Returns true if d is greater than 100
        if (d > 100)
            return true;

        // Returns false if d does not meet the above two conditions
        return false;

        // Can also be written as follows:
        // return d < -100 || d > 100;
    }

    /*
     * Method to display on screen the message msg
     * Followed by num correct to the nearest whole number
     */
    static void dispWholeNum(String msg, double num) {
        // Record whether num is negative
        boolean neg = (num < 0);

        // Make a positive version of the number
        double posNum = num;
        if (neg)
            posNum = -num;

        // Add 0.5 to the posNum, so that truncating nPlus
        // is equivalent to rounding posNum
        double nPlus = posNum + 0.5;

        // Extract the whole number part of the number
        int whole = (int) nPlus;

        // Assign negative sign to whole number if num was a negative
        String sign = "";
        if (neg)
            sign = "-";
        // whole = -whole;

        // Display the message, sign, the whole number
        System.out.println(msg + "" + sign + whole);
        // System.out.println(msg + "" + whole);
    }
}