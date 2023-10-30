/*
 * Title: Lab Week 7 - Question 2
 * Author: Vimalnath Nambiar
 * Date: 30-10-2023
 * File: Helper.java
 * 
 * Purpose: 
 * - Store general methods to be used by client program
 * 
 * Assumptions/Conditions:
 * - 
 */

import java.io.*;
import java.util.Scanner;

public class Helper {
    /*
    * Method to read user input for file names
    */
    public static String readFileName(Scanner kb){
        String fileName;

        do{
            System.out.print("Enter the name of the input file (ending with .txt): ");
            fileName = kb.nextLine();

            if(!fileName.endsWith(".txt")){
                System.out.println("Invalid input. Please try again.\n");
            }

        } while(!fileName.endsWith(".txt"));

        return fileName;
    }

    /*
     * Read records from input file and store in array
     */
    public static Score[] readRecord(BufferedReader inputReader, Score[] scoreArray) throws IOException{    
        // Loop through for records based on array size
        for(int i = 0; i < scoreArray.length; i++){
            String line = inputReader.readLine();

            // Split record data
            String[] recordData = line.split(" ");

            // Store record in array
            scoreArray[i] = new Score(recordData[0], Double.parseDouble(recordData[1]));
        }

        return scoreArray;
    }
    
    /*
     * Output data
     */
    public static void outputData(PrintWriter outputWriter, Score[] scoreArray){
        // Generate stats
        double average = findTotal(scoreArray)/scoreArray.length;
        double largest = findLargest(scoreArray);
        double smallest = findSmallest(scoreArray);

        System.out.println("\nWriting record to output file...\n");

        // Write stats to file (first line)
        outputWriter.println("Number of records: " + scoreArray.length + ", Average: " + average + ", Largest: " + largest + ", Smallest: " + smallest);

        // Display and write record data to output file (csv format)
        for(Score score : scoreArray){
            System.out.println(score.getName() + " " + score.getScore());
            outputWriter.println(score.getName() + ", " + score.getScore());
        }

        System.out.println("\nOutput file written successfully.\n");
    }

    /*
     * Find total score
     */
    public static double findTotal(Score[] scoreArray){
        double total = 0;

        for(Score score : scoreArray){
            total += score.getScore();
        }

        return total;
    }

    /*
     * Find largest score
     */
    public static double findLargest(Score[] scoreArray){
        double largest = scoreArray[0].getScore();

        for(Score score : scoreArray){
            if(score.getScore() > largest){
                largest = score.getScore();
            }
        }

        return largest;
    }

    /*
     * Find largest score
     */
    public static double findSmallest(Score[] scoreArray){
        double smallest = scoreArray[0].getScore();

        for(Score score : scoreArray){
            if(score.getScore() < smallest){
                smallest = score.getScore();
            }
        }

        return smallest;
    }
}
