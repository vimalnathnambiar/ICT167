/*
 * Title: Lab Week 5 - Question 2, 3 & 4
 * Author: Vimalnath Nambiar
 * Date: 08-09-2023
 * File: Client.java
 * 
 * Purpose: 
 * - A client program class to store information about 4 babies
 * 
 * Assumptions/Conditions:
 * Question 4
 * ---
 * 1. Use an array to store information of 4 babies
 *      - Each index = 1 baby object
 * 2. Receive details of each baby (name and age)
 *      - Used to populate array
 * 3. Output details of each baby from array
 * 4. Calculate and display the average age of all babies
 * 5. Determine whether any two babies in the array are the same
 * 6. Make use of loops to access each array elements (and use dot notation to access set and get methods)
 */

// Import libraries
import java.util.Scanner;

public class Client {
    // Initialise global, static, or final variables
    static final int arraySize = 4;
    static Baby[] babyArray = new Baby[arraySize];

    /*
     * Main Method
     */
    public static void main(String[] args) {
        // Get baby information
        setBabyDetails();

        // Output baby information
        getBabyDetails();

        // Output the average age of babies
        System.out.println("The average age of all babies:\n" + calculateAverageAge() + " years old\n");

        // Baby comparison
        babyComparison();
    }

    /*
     * Method to set baby information
     */
    public static void setBabyDetails() {
        Scanner kb = new Scanner(System.in);

        // Setting details of babies (name and age) using setter methods
        System.out.println("\nPlease enter the details of the following babies:\n");
        for (int i = 0; i < babyArray.length; i++) {
            System.out.print("Enter name of Baby " + (i + 1) + ": ");
            String babyName = kb.next();

            System.out.print("Enter age of Baby " + (i + 1) + ": ");
            int babyAge = kb.nextInt();

            babyArray[i] = new Baby(babyName, babyAge);

            System.out.println();
        }
        kb.close();
    }

    /*
     * Method to output details of babies
     */
    public static void getBabyDetails() {
        // Output details of each babies using getter methods
        System.out.println("Information of the babies are as follows:");
        for (int i = 0; i < babyArray.length; i++) {
            System.out.println("Baby " + (i + 1) + " => " + babyArray[i].getName() + "; "
                    + babyArray[i].getAge() + " years old.");
        }
        System.out.println();
    }

    /*
     * Method to calculate the average ages of all babies
     */
    public static double calculateAverageAge() {
        // Initialise sum
        int sum = 0;

        // Get sum of age
        for (int i = 0; i < babyArray.length; i++) {
            sum += babyArray[i].getAge();
        }

        // Calculate average
        double average = (double) sum / babyArray.length;
        return average;
    }

    /*
     * Method to compare babies
     */
    public static void babyComparison() {
        // Initialise flag
        boolean isDuplicate = false;

        // Check for duplicate babies
        System.out.println("Checking for duplicate babies in the system:");
        for (int i = 0; i < babyArray.length; i++) {
            for (int j = i + 1; j < babyArray.length; j++) {
                boolean result = babyArray[i].equals(babyArray[j]);

                // If babies are duplicated
                if (result) {
                    isDuplicate = true;
                    System.out.println("Baby " + (i + 1) + " is the same as Baby " + (j + 1));
                }
            }
        }

        // If no duplicate babies is found
        if (!isDuplicate) {
            System.out.println("No duplicate babies found");
        }

        System.out.println();
    }

}
