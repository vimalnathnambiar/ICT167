/*
 * Title: Lab Week 10 - question 1 and 2
 * Author: Vimalnath Nambiar
 * Date: 31-10-2023
 * File: Helper.java
 * 
 * Purpose: 
 * - Helper class to handle menu execution and array handling
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Helper {
    private static ArrayList<Baby> babyArray = new ArrayList<>();

    /*
     * Method to populate initial array
     */
    public static void populateArray() {
        babyArray.add(new Baby("Emma", 3));
        babyArray.add(new Baby("Noah", 2));
        babyArray.add(new Baby("Olivia", 4));
        babyArray.add(new Baby("Liam", 1));
        babyArray.add(new Baby("Ava", 3));
        babyArray.add(new Baby("William", 2));
        babyArray.add(new Baby("Sophia", 4));
        babyArray.add(new Baby("Benjamin", 1));
        babyArray.add(new Baby("Mia", 3));
        babyArray.add(new Baby("Elijah", 2));
    }

    /*
     * Method to add a new baby
     */
    public static void addBaby(Scanner kb){
        // Get user input
        System.out.print("\nEnter baby's name: ");
        String name = kb.next();
        
        System.out.print("Enter baby's age: ");
        int age = kb.nextInt();

        Baby baby = new Baby(name, age);

        // Check for duplicates
        boolean duplicateStatus = checkDuplicates(baby);
        if(duplicateStatus){
            System.out.println("\nError! Duplicate entry detected - Record not added.");
        } else{
            addBabyToRecord(baby);
        }
    }

    /*
     * Method to check for duplicate baby objects
     */
    private static boolean checkDuplicates(Baby baby){
        for(Baby b: babyArray){
            if (b.getName().equalsIgnoreCase(baby.getName()) && b.getAge() == baby.getAge()){
                return true;
            }
        }
        return false;
    }

    /*
     * Method to add baby to record
     */
    private static void addBabyToRecord(Baby baby){
        babyArray.add(baby);
    }
    
    /*
     * Method to get for user confirmation (Y/N)
     */
    public static boolean getConfirmation(Scanner kb){
        while(true){
            System.out.print("\nWould you like to add more data: ");
            char confirm = kb.next().toLowerCase().charAt(0); 
            
            if(confirm == 'y'){
                return true;
            } else if(confirm == 'n'){
                return false;
            } else{
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    /*
     * Method to display menu
     */
    public static void displayMenu(Scanner kb) throws IOException {
        while(true){
            System.out.println("\nMain Menu\n---");
            System.out.println("a. Calculate and display the average age of all babies on record");
            System.out.println("b. Remove a baby from the record");
            System.out.println("c. Add a new baby");
            System.out.println("d. Output details of all baby on record");
            System.out.println("e. Sort and output baby records to a CSV file");
            System.out.println("f. Quit program");

            System.out.print("\nEnter an option to execute: ");
            char option = kb.next().toLowerCase().charAt(0);

            boolean status = executeOptions(kb, option);
            if(!status){
                break;
            }
        }
    }

    /*
     * Method to process Menu options
     */
    private static boolean executeOptions(Scanner kb, char option) throws IOException {
        switch(option){
            case 'a':
                displayAverageAge();
                break;
            case 'b':
                removeBaby(kb);
                break;
            case 'c':
                addBaby(kb);
                break;
            case 'd':
                outputRecordDetails();
                break;
            case 'e':  
                sortRecords();
                break;
            case 'f':
                System.out.println("\nProgram exited successfully\n");
                return false;

            default:
                System.out.println("Invalid input. Please try again.");
        }
        
        return true;

    }

    /*
     * Method to display average age of all babies in array
     */
    private static void displayAverageAge(){
        int totalAge= 0;

        for(Baby baby: babyArray){
            totalAge += baby.getAge();
        }

        double average = (double)totalAge/babyArray.size();
        System.out.println("\nThe average age of all babies is " + average);
    }

    /*
     * Method to remove baby of a specific name from the array
     */
    private static void removeBaby(Scanner kb){
        System.out.print("\nEnter the baby name of the record you would like to remove: ");
        String name = kb.next();

        Iterator<Baby> iterator = babyArray.iterator();

        while(iterator.hasNext()){
            Baby baby = iterator.next();

            if(baby.getName().equals(name)){
                iterator.remove();
            }
        }
    }

    /*
     * Method to remove baby of a specific name from the array
     */
    private static void outputRecordDetails(){
        for(Baby baby: babyArray){
            System.out.println("\nName: " + baby.getName() + "\nAge: " + baby.getAge());
        }
    }

    /*
     * Method to remove baby of a specific name from the array
     */
    private static void sortRecords() throws IOException {
        Collections.sort(babyArray, new Comparator<Baby>() {
            @Override
            public int compare(Baby baby1, Baby baby2) {
                return baby1.getName().compareTo(baby2.getName());
            }
        });

        writeToCSV();
    }

    /*
     * Method to output records to CSV
     */
    private static void writeToCSV() throws IOException {
        PrintWriter outputWriter = new PrintWriter(new FileWriter("sortedbabylist.csv"));

        // Write header row
        outputWriter.println("Name, Age");

        // Write data rows
        for(Baby baby: babyArray){
            outputWriter.println(baby.getName() + ", " + baby.getAge());
        }
        outputWriter.close();
    }
}
