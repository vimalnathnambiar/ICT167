/*
 * Title: Lab Week 7 - Question 1
 * Author: Vimalnath Nambiar
 * Date: 30-10-2023
 * File: Question1.java
 * 
 * Purpose: 
 * - Ask user for the name of input file and output file
 * - Open input file as a text file and read contents line by line
 * - Open output file as text file and write to it the lines in the input file
 * 
 * Assumptions/Conditions:
 * - Input file as text file
 * - Output file as text file
 * - Line to output file prefixed by line numbers starting at 1 and includes content of input file
 */

 // Import libraries
import java.io.*;
import java.util.*;

public class Question1 {
    /*
     * Global variables
     */
    public static String line;
    public static int lineNumber = 1;
    public static int totalLines = 0;
    public static int totalWords = 0;
    public static int totalChar = 0;

    /*
     * Main method
     */
    public static void main(String[] args) {
        try{
            // Initialise scanner to accept user input
            Scanner kb = new Scanner(System.in);

            // Ask user for input file name
            String inputFileName = readFileName(kb, "input");

            // Ask user for output file name
            String outputFileName = readFileName(kb, "output");

            // Initialise buffered reader to read from input file
            BufferedReader inputReader = new BufferedReader(new FileReader(inputFileName));

            // Initialise writer to output file
            PrintWriter outputWriter = new PrintWriter(new FileWriter(outputFileName));

            // Process input file and write to output file
            processFile(inputReader, outputWriter);
            inputReader.close();
            outputWriter.close();

            // Display processing details
            displayDetails(outputFileName);
        } catch(IOException e) {
            System.out.println("Caught an IO exception");
            System.out.println(e.getMessage());
        } catch(Exception e){
            System.out.println("Caught an exception");
            System.out.println(e.getMessage());
        }
    }

    /*
     * Method to read user input for file names
     */
    public static String readFileName(Scanner kb, String fileType){
        String fileName;

        do{
            System.out.print("Enter the name of the " + fileType + " file (ending with .txt): ");
            fileName = kb.nextLine();

            if(!fileName.endsWith(".txt")){
                System.out.println("Invalid input. Please try again.\n");
            }

        } while(!fileName.endsWith(".txt"));

        return fileName;
    }

    /*
     * Method to process input file and write to output file
     */
    public static void processFile(BufferedReader inputReader, PrintWriter outputWriter) throws IOException{
        while((line = inputReader.readLine()) != null){
            // Increase number of line and char count
            totalLines++;
            totalChar += line.length();

            if(line.length() != 0){
                // Split string into separate words
                String[] words = line.split(" ");
                totalWords += words.length;
            }        

            // Output line to output file
            outputWriter.println(lineNumber + " " + line);
            lineNumber++;    
        }
    }

    /*
     * Method to output name, output file name, and processing stats
     */
    public static void displayDetails(String outputFileName){
        System.out.println("\nMy name: Vimalnath Nambiar");
        System.out.println("Name of Output file: " + outputFileName);
        System.out.println("Total number of lines in " + outputFileName + ": " + (lineNumber-1));
        System.out.println("Total number of words in " + outputFileName + ": " + totalWords);
        System.out.println("Total number of characters in " + outputFileName + ": " + totalChar + "\n");
    }
}
