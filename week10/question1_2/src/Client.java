/*
 * Title: Lab Week 10 - question 1 and 2
 * Author: Vimalnath Nambiar
 * Date: 31-10-2023
 * File: Client.java
 * 
 * Purpose: 
 * - A client program class to store information about 4 babies
 * 
 * Assumptions/Conditions:
 * - Enter details for each baby (name, age) and populate ArrayList
 * - Use ArrayList instead of Array
 * - Calculate and display average age of all babies in ArrayList
 * - Ask user to enter name of a baby and remove
 * - Allow user to add new baby to the ArrayList
 * - Output the details from the ArrayList
 * - Sort the baby names in alphabetical order and output the details to a csv file (sortedbabylist.csv)
 */

// Import libraries
import java.io.IOException;
import java.util.*;

public class Client {
    /*
     * Main Method
     */
    public static void main(String[] args) {
        // Initialise scanner to get user input
        Scanner kb = new Scanner(System.in);

        // Populate array
        Helper.populateArray();

        while(true){
            // Ask user if they would like to exit data entry
            boolean confirm = Helper.getConfirmation(kb);
            if(!confirm){
                break;
            }

            // Add new baby to record
            Helper.addBaby(kb);
        }

        try{
            // Display menu option
            Helper.displayMenu(kb);
        } catch(IOException e){
            System.out.println(e.getMessage());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}
