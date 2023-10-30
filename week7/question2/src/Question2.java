/*
 * Title: Lab Week 7 - Question 2
 * Author: Vimalnath Nambiar
 * Date: 30-10-2023
 * File: Question2.java
 * 
 * Purpose: 
 * - Ask user for the name of input file
 * - Read 10 records that consist of a name and score between 0 and 100 (inclusive)
 * - Calculate average, largest and smallest score
 * - Output stats and all records to output.csv
 * 
 * Assumptions/Conditions:
 * - Input file as text file
 * - 10 records in input file
 * - Records consist of a name and score
 * - Score between 0 and 100 (inclusive)
 * - Records to be stored in an array of type Score
 * - Output file is csv format
 * - First line of output consist of number of records, average score, largest score and the smallest score 
 * - Output is comma-separated
 * - Content of Score array in the subsequent lines
 */

 // Import libraries
import java.io.*;
import java.util.*;

public class Question2 {
    /*
     * Main Method
     */
    public static void main(String[] args) throws Exception {
        // Initialise array to store score records
        Score[] scoreArray = new Score[10];

        try{
            // Initialise scanner to accept user input
            Scanner kb = new Scanner(System.in);

            // Ask user for input file name
            String inputFileName = Helper.readFileName(kb);

            // Initialise buffered reader to read from input file
            BufferedReader inputReader = new BufferedReader(new FileReader(inputFileName));

            // Store records in array
            scoreArray = Helper.readRecord(inputReader, scoreArray);
            inputReader.close();

            // Process and output data to file
            PrintWriter outputWriter = new PrintWriter(new FileWriter("output.csv"));
            Helper.outputData(outputWriter, scoreArray);
            outputWriter.close();
        } catch(IOException e) {
            System.out.println("Caught an IO exception");
            System.out.println(e.getMessage());
        } catch(Exception e){
            System.out.println("Caught an exception");
            System.out.println(e.getMessage());
        }
    }
}
