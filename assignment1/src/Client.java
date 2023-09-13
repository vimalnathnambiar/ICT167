/*
 * Title: Assignment 1
 * Author: Vimalnath Nambiar
 * Date: 13-09-2023
 * File: Client.java
 * 
 * Purpose:
 * 1. Read input data from user
 * 2. Display menu screen once input data is collected
 * 
 * Assumptions/Conditions:
 * 1. Use ChangeC class to store the data entered
 * 2. Use data structure to store the ChangeC class objects according to the number of persons entered
 *      - Utilise an array of ChangeC objects
 *      - Do not use ArrayList
 * 3. Input data should consist of name (one-word String) and coin value (integer)
 * 4. Users should be asked for input using a loop with a question after each loop iteration to check for more input
 * 5. Minimum of 10 data input object should be acquired
 * 6. Provide a method that hardcodes data into at least 10 ChangeC objects and store these object in an array provided by the program
 *      - Provide a call to this method (commented out) in the main function
 * 7. Check if the same name has been entered. If same name has been entered, inform user that the name exists in the system
 *      - Make sure there is hardcoded test cases 
 *      - Assumption was made that if user keyed in same name, user might want to change the coin amount for the person in the system
 */

/*
 * Libraries/Packages
 */
import java.util.Arrays;
import java.util.Scanner;

/*
 * Client class
 */
public class Client {
    /*
     * Global variables
     */
    private static Scanner kb = new Scanner(System.in);
    private static final int INITIAL_CAPACITY = 10;
    private static ChangeC[] personChange = new ChangeC[INITIAL_CAPACITY];

    /*
     * Main method
     */
    public static void main(String[] args) {
        // Display initial message
        System.out.println("\nCoin Changer Record Program\n---");
        System.out.println("Recommendation: Please enter at least 10 records to test the program");

        // Get records from client
        getRecords();

        // Execute menu
        executeMenu();

        // Display exit message
        System.out.println("\nThank you for using the Coin Changer Record Program\n");
    }

    /*
     * Method to retrieve record from user
     */
    private static void getRecords() {
        // Initialise local variables
        int counter = 0;

        // Loop to retrieve record information
        while (true) {
            // Check if personChange array has reached maximum capacity to store new inputs
            if (counter == personChange.length) {
                // Resize array
                personChange = Arrays.copyOf(personChange, (counter + INITIAL_CAPACITY));
            }

            try {
                // Get name for the record
                System.out.print("\nPlease enter the name for person " + (counter + 1) + ": ");
                String name = kb.next();

                // Check if record with the name already exist
                if (Helper.isNameExists(personChange, name)) {
                    System.out.println("\nThe name of the person you just provided already exist within the system");

                    // Check if coint amount should be changed for the person
                    char proceed;
                    while (true) {
                        try {
                            System.out.print("\nWould you like to provide a new coin amount for " + name + "? (Y/N) ");
                            proceed = kb.next().toUpperCase().charAt(0);
                            Helper.isProceedValid(proceed);
                            break;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                    }

                    // Get new coin amount for user if input is 'Y'
                    if (proceed == 'Y') {
                        // Get coin amount and ensure its value is greater than 0
                        while (true) {
                            try {
                                System.out.print("Please enter a new coin value (>= 0): ");
                                int coinAmount = kb.nextInt();
                                Helper.isCoinAmountLessThanZero(coinAmount);

                                // Set new coin amount for the person's record
                                personChange = Helper.setNewCoinAmount(personChange, name, coinAmount);
                                break;
                            } catch (java.util.InputMismatchException e) {
                                System.out.println("\nInvalid input type. Please try again...\n");
                                kb.next();
                                continue;
                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                                continue;
                            }
                        }
                    }
                } else {
                    // Get coin amount for person and ensure it is greater than 0
                    while (true) {
                        try {
                            System.out.print("Please enter a coin value for " + name + " (>= 0): ");
                            int coinAmount = kb.nextInt();
                            Helper.isCoinAmountLessThanZero(coinAmount);

                            // Create new object reference of ChangeC class
                            personChange[counter++] = new ChangeC(name, coinAmount);
                            break;
                        } catch (java.util.InputMismatchException e) {
                            System.out.println("\nInvalid input type. Please try again...\n");
                            kb.next();
                            continue;
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                            continue;
                        }
                    }
                }

                // Check if there is more records to be inputted
                char proceed;
                while (true) {
                    try {
                        System.out.print("\nDo you have more records to enter into the system? (Y/N): ");
                        proceed = kb.next().toUpperCase().charAt(0);
                        Helper.isProceedValid(proceed);
                        break;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                }
                if (proceed == 'N') {
                    break;
                }
            } catch (java.util.InputMismatchException e) {
                System.out.println("\nInvalid input type. Please try again...\n");
                continue;
            }
        }

        // Once loop is exited
        System.out
                .println(
                        "\nThank you for providing the records! You can now execute different options using the menu below...");
    }

    /* Method to execute menu */
    private static void executeMenu() {
        // Initialise local variables
        boolean flag = true;

        // Display and execute menu options using a loop
        while (flag) {
            // Display menu
            Menu.displayMenu();

            // Get user input for menu execution
            int menuOption;
            while (true) {
                try {
                    System.out.print("Please enter a valid option to be executed: ");
                    menuOption = kb.nextInt();
                    break;
                } catch (java.util.InputMismatchException e) {
                    System.out.println("\nInvalid input type. Please try again...\n");
                    kb.next();
                    continue;
                }
            }

            // Execute menu option chosen
            flag = Menu.executeMenuOptions(kb, personChange, menuOption);
        }
    }
}
