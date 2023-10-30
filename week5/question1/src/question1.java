/*
 * Title: Lab Week 5 - Question 1
 * Author: Vimalnath Nambiar
 * Date: 08-09-2023
 * File: Question1.java
 * 
 * Purpose: 
 * - A program to store an array of integer random numbers
 * 
 * Assumptions/Conditions:
 * Question 1
 * ---
 * - Find out how many numbers to store in the array
 * - Generate and store that many random integers (between 1 and 999 inclusive)
 * - Determine smallest number, largest, and average of all numbers in the array
 * - Print out all numbers on the screen
 *      - 5 numbers per line with spaces in between 
 *      - Display the smallest, largest, and average after
 * - Code should be modular
 */

// Import libraries
import java.util.Random;
import java.util.Scanner;

public class Question1 {
    // Initialise static variables
    static int smallestInt = 0;
    static int largestInt = 0;
    static int average = 0;

    /*
     * Main method
     */
    public static void main(String[] args) {
        // Initialising local variables
        Scanner kb = new Scanner(System.in);

        // Loop for continuous user input
        while (true) {
            // Get user input
            System.out.print("Enter an array size for random number generation\n(Enter a value <= 0 to exit): ");
            int arraySize = kb.nextInt();
            int[] randomIntArr = new int[arraySize];

            // Conditional check for breaking loop
            if (arraySize <= 0) {
                break;
            }

            // Call method to generate random integers into the array
            randomIntArr = generateRandomInt(randomIntArr);

            // Display output
            outputArray(randomIntArr);

        }
        kb.close();
    }

    /*
     * Method to generate random integers into the array
     */
    public static int[] generateRandomInt(int[] intArray) {
        // Initialise local variables
        Random generator = new Random();

        // Store random integers into the array
        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = generator.nextInt(1, 1000);
        }

        // Determine the smallest, largest and average number in the array
        findSmallest(intArray);
        findLargest(intArray);
        findAverage(intArray);

        return intArray;
    }

    /*
     * Method to determine the smallest number in the array
     */
    public static void findSmallest(int[] intArray) {
        // Initialise local variables
        smallestInt = intArray[0];

        // Determine the smallest integer in the array
        for (int i = 0; i < intArray.length; i++) {
            smallestInt = Math.min(smallestInt, intArray[i]);
        }
    }

    /*
     * Method to determine the smallest number in the array
     */
    public static void findLargest(int[] intArray) {
        // Initialise local variables
        largestInt = intArray[0];

        // Determine the largest integer in the array
        for (int i = 0; i < intArray.length; i++) {
            largestInt = Math.max(largestInt, intArray[i]);
        }
    }

    /*
     * Method to determine the average value of the array
     */
    public static void findAverage(int[] intArray) {
        // Initialise local variables
        int sumValue = 0;

        // Calculate the sum of values
        for (int i = 0; i < intArray.length; i++) {
            sumValue += intArray[i];
        }

        // Determine the average
        average = sumValue / intArray.length;
    }

    /*
     * Method to display integer array
     */
    public static void outputArray(int[] intArray) {
        System.out.println("\nNumber of random integers generated: " + intArray.length);
        for (int i = 0; i < intArray.length; i++) {
            // Check if it is 5 numbers has been printed out per the previous line
            if (i != 0 && i % 5 == 0) {
                System.out.println();
            }

            // Display integer value
            System.out.print(intArray[i] + " ");
        }
        // Output smallest, largest and average
        System.out.println("\n\nSmallest: " + smallestInt);
        System.out.println("Largest: " + largestInt);
        System.out.println("Average: " + average + "\n");
    }
}
