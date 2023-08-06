/*
 * Title: Lab Week 1 - Question 3
 * Author: Vimalnath Nambiar
 * Date: 31-07-2023
 * File: StringReader.java
 * 
 * Purpose: 
 * - Read string from keyboard
 * - Copy characters from the strings that are vowels into an array
 * - Display the copied characters from the array
 * - Count and display number of times each vowel appears
 * - Output the index in the array where each vowel first appeared or display suitable message if a particular vowel is not in the array
 * 
 * Assumptions/Conditions:
 * - String needs to be a maximum length of 30
 * - Characters (only vowels) are to be copied into the array and should be in order of input
 * - Display of copied characters should be in order of input
 * - Only the index where each vowel first appeared should be displayed
 */

// Imported libraries
import java.util.Scanner;

// StringReader Class
public class VowelCopy {
    // Main method
    public static void main(String[] args) {
        // Initialise scanner object for input
        Scanner input = new Scanner(System.in);

        // Initialise variables
        boolean flag = true;

        // Start loop
        while (flag) {
            // Receive string (message) from user input
            System.out.println("Enter a string to a maximum length of 30:");
            String inputString = input.nextLine();

            // Check if input string length is within the maximum length of 30
            if (inputString.length() <= 30) {

                // Extract vowels from input string into an array
                char[] vowelArray = extractVowel(inputString);

                // Display vowel characters stored in the array acquired from the input string
                System.out.println("\nThe output of the second array is:");
                System.out.println(vowelArray);

                // Display number of counts for each vowel
                System.out.println("\nThe counts are as follows:");
                countVowel(vowelArray);

                // Display index of the first occurence of the vowel in the array
                System.out.println("\nThe index of the second array where each vowel first appeared:");
                displayFirstIndex(vowelArray);

                // Set flag to false to exit loop
                flag = false;

            } else {
                System.out.println("\nThe string is too long. Please enter again.\n");
            }
        }
        input.close();
        System.out.println("\nExiting the program now\n");
    }

    /*
     * Method to extract vowel characters from the input string
     */
    static char[] extractVowel(String inputString) {
        // Initialise a second character array to store character vowels
        char[] vowelArray = new char[inputString.length()];
        int index = 0;

        // Loop through input string
        for (int i = 0; i < inputString.length(); i++) {
            char ch = inputString.charAt(i);
            ch = Character.toLowerCase(ch);

            // If character is a vowel, add it to array
            if (isVowel(ch)) {
                vowelArray[index++] = ch;
            }
        }
        return vowelArray;
    }

    /*
     * Method to check if a character is a vowel
     */
    static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    /*
     * Method to count and display the number of times a vowel appears in an array
     */
    static void countVowel(char[] vowelArray) {
        int aCounter = 0;
        int eCounter = 0;
        int iCounter = 0;
        int oCounter = 0;
        int uCounter = 0;

        // Count the number of times each vowel is present in the array
        for (int i = 0; i < vowelArray.length; i++) {
            switch (vowelArray[i]) {
                case 'a':
                    aCounter++;
                    break;
                case 'e':
                    eCounter++;
                    break;
                case 'i':
                    iCounter++;
                    break;
                case 'o':
                    oCounter++;
                    break;
                case 'u':
                    uCounter++;
                    break;
            }
        }

        // Display the vowel count
        System.out.printf("a = %d\ne = %d\ni = %d\no = %d\nu = %d\n",
                aCounter, eCounter, iCounter, oCounter, uCounter);
    }

    /*
     * Method to display the first occurence of a vowel in an array
     */
    static void displayFirstIndex(char[] vowelArray) {
        // A array of type character that stores the list of vowels
        char[] vowel = new char[] { 'a', 'e', 'i', 'o', 'u' };

        // Nested loop to loop check each character in the vowel array against a vowel
        for (int i = 0; i < vowel.length; i++) {
            boolean vowelFound = false;

            for (int j = 0; j < vowelArray.length; j++) {
                // Display index of the first occurence of a vowel in the array
                if (vowelArray[j] == vowel[i]) {
                    System.out.println(vowel[i] + " = " + j);
                    vowelFound = true;
                    break;
                }
            }
            // Display suitable message if vowel is not found in the array
            if (!vowelFound) {

                System.out.println(vowel[i] + " is not in the input");
            }
        }
    }
}