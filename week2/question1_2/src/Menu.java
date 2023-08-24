/*
 * Title: Lab Week 2 - Question 1 & 2
 * Author: Vimalnath Nambiar
 * Date: 06-08-2023
 * File: MenuAlgorithm.java
 * 
 * Purpose: 
 * - Implement pseudo-code (Question 1)
 * - Add option "f" to the menu program (Question 2)
 * 
 * Assumptions/Conditions:
 * - Use while loop and switch-case statement
 * - Use one of the provided methods to read character from keyboard
 * - Tasks performed under each option is to be implemented as separate methods (One method per task).  
 * - Option a - hard coded names (student and tutor)
 * - Option b - receive 3 double numbers (x, y and z)
 *            - output the largest and the smallest number
 * - Option c - receive 2 integer numbers (m and n), display all numbers between m and n (inclusive of m and n) with 5 numbers per line
 *            - check input to see which of m and n is smallest (m should be smaller)
 *            - line may have less than 5 numbers
 *            - display the sum of all odd numbers between m and n (inclusive of m and n)
 * - Option d - receive 3 integer numbers
 *            - display the numbers together with a message indicating whether the numbers form a triangle
 *            - sum of two sides must be greater than the third side to form a triangle
 * - Option e - receive integer number (n)
 *            - determine whether n is a prime number
 *            - a prime number is greater than 1 and has no divisors other than 1 and itself
 * - Option q - exit loop
 * - Other options will result in an error message
 * - Option f - prompt user to enter 10 integers that is stored in an array
 *            - display the average of the 10 numbers entered, the highest number entered and the lowest number entered
 *            - have separate methods to perform each of the required calculations.
 */

// Imported libraries
import java.util.*;

// MenuAlgorithm class
public class Menu {

    // Static variables
    public static Scanner kb = new Scanner(System.in);

    // Main method
    public static void main(String[] args) throws Exception {
        // Object instantiation
        // Initialising an object instance of class type Menu
        MenuOptions menu = new MenuOptions();

        // Initialise flag to determine status of loop
        boolean flag = true;

        while (flag) {
            // Display the options available to the user to choose from
            menu.displayOptions();

            // Receive user choice
            System.out.print("Enter your choice: ");
            char choice = kb.next().trim().toLowerCase().charAt(0);
            System.out.println();

            // Process user input
            flag = menu.processInput(flag, choice);
        }
        System.out.println("Menu exited successfully");
        kb.close();
    }
}
