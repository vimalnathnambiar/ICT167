/*
 * Title: Assignment 2
 * Author: Vimalnath Nambiar
 * Date: 01-11-2023
 * File: Client.java
 * 
 * Purpose:
 * 1. This is the Client class that will be used for main program execution
 * 
 * Assumptions/Conditions:
 * 1. Allow entry of data for several different student into an ArrayList for analysis and queries
 * 2. Provide user with menu to perform some operations
 *      - Quit (exit program)
 *      - Add to ArrayList (By reading another CSV file)
 *      - Remove a student (Provided student number (ID)) with confirmation
 *      - Output all details in ArrayList
 *      - Determine number of course work student that obtained an overall mark to or above the average overall mark, and 
 *        how many obtained below the average (Only for course work)
 *      - Report grade information of student based on student number (ID), and display error message if not found
 *      - Sort ArrayList (ascending order of student ID), and output sorted array (Implement Insertion Sort algorithm)
 *      - Output sorted ArrayList to CSV file (Available only after array list is sorted) - Include identification of student's enrolment type
 * 3. Program should loop till user selects the first option (Quit)
 * 4. Set up student ArrayList of 10 student objects in CSV file. 
 *      - Use 5 course work students and 5 research students in test
 *      - Consider all possible enrolment types
 * 5. Should also include a studentInfo() method that displays student details
 * 7. A student is enrolled to a single unit at any given time
 * 8. Course work student average is calculated across all course work courses and not unit specific
 */

// Import libraries
import java.io.*;
import java.util.*;

public class Client {
    /*
     * main() method
     */
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);

        // Display student information
        studentInfo();

        // Load initial data
        System.out.println("\nPopulating Array\n---");
        try {
            Helper.readCSV("student.csv");

            // Display menu
            Helper.displayMenu(kb);
        } catch (IOException e) {
            System.out.println("Error occured: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error occured: " + e.getMessage());
        } finally {
            System.out.println("\nExiting program now");
        }
    }

    /*
     * studentInfo() method to display student information
     */
    private static void studentInfo() {
        System.out.println("\nStudent Details\n---"
                + "\nName: Vimalnath Nambiar"
                + "\nStudent ID: 01234567"
                + "\nEnrolment Type: Full-time"
                + "\nTutor: Vimalnath Nambiar"
                + "\nTutorial Session: Monday (14:30 - 16:30) | Wednesday (16:30 - 18:30)");
    }
}
