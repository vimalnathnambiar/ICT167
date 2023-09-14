/*
 * Title: Assignment 1
 * Author: Vimalnath Nambiar
 * Date: 13-09-2023
 * File: Menu.java
 * 
 * Purpose:
 * 1. Handles menu execution
 * 
 * Assumptions/Conditions:
 * 1. Has 6 prompts
 *      - Enter name and display change to be given for each denomination
 *      - Find name with the smallest amount and display change to be given for each denomination
 *      - Find name with the largest amount and display change to be given for each denomination
 *      - Calculate and display the total number of coins for each denomination
 *      - Calculate and display the total sum of all denominations
 *      - Exit
 * 2. Assumption was made that this class has access to the Client class to use its Scanner object for input
 */

/*
 * Libraries / Packages
 */
import java.util.Scanner;

/*
 * Menu class
 */
public class Menu {
    /*
     * Method to display menu options
     */
    public static void displayMenu() {
        System.out.println("\nMenu\n---");
        System.out.println("1. Enter a name and display change to be given for each denomination");
        System.out.println(
                "2. Find the name with the smallest amount and display change to be given for each denomination");
        System.out.println(
                "3. Find the name with the largest amount and display change to be given for each denomination");
        System.out.println("4. Calculate and display the total number of coins for each denomination");
        System.out.println("5. Calculate and display the total amount for the sum of all denominations");
        System.out.println("6. Exit");
        System.out.println();
    }

    /*
     * Method to execute menu options based on user selection
     */
    public static boolean executeMenuOptions(Scanner inputScanner, ChangeC[] coinChangeRecords, int menuOption) {
        switch (menuOption) {
            case 1:
                displayChangeForName(inputScanner, coinChangeRecords);
                break;

            case 2:
                displaySmallestCoinAmount(coinChangeRecords);
                break;

            case 3:
                displayLargestCoinAmount(coinChangeRecords);
                break;

            case 4:
                calculateTotalCoinsOfDenominations(coinChangeRecords);
                break;

            case 5:
                calculateTotalSumOfDenominations(coinChangeRecords);
                break;

            case 6:
                return false;

            default:
                System.out.println("\nInvalid input. Please try again...");
                break;
        }

        return true;
    }

    /*
     * Method to display change based on user's name inputted
     */
    private static void displayChangeForName(Scanner inputScanner, ChangeC[] coinChangeRecords) {
        while (true) {
            try {
                // Get a name to search for
                System.out.print("\nPlease enter a person's name that you would like display the change for: ");
                String name = inputScanner.next();

                // Loop through coin change records
                boolean isFound = false;
                for (ChangeC record : coinChangeRecords) {
                    // If name is found in records, display change details
                    if (record != null && record.getName().equalsIgnoreCase(name)) {
                        isFound = true;
                        System.out.println("\nCustomer:");
                        System.out.println(record.getName() + " " + record.getCoinAmount() + " pence\n");
                        displayChangeDetails(record);
                        break;
                    }
                }

                // If name is not found
                if (!isFound) {
                    System.out.println("\nName: " + name + "\nNot found");
                }
                break;

            } catch (java.util.InputMismatchException e) {
                System.out.println("Invalid input type. Please try again...");
            }
        }

    }

    /*
     * Method displaying change details of a user
     */
    private static void displayChangeDetails(ChangeC record) {
        System.out.println("Change:");

        if (record.getPound2() != 0) {
            System.out.println("£2: " + record.getPound2());
        }
        if (record.getPound1() != 0) {
            System.out.println("£1: " + record.getPound1());
        }
        if (record.getPence50() != 0) {
            System.out.println("50 pence: " + record.getPence50());
        }
        if (record.getPence20() != 0) {
            System.out.println("20 pence:" + record.getPence20());
        }
        if (record.getPence10() != 0) {
            System.out.println("10 pence:" + record.getPence10());
        }
        if (record.getPence5() != 0) {
            System.out.println("5 pence: " + record.getPence5());
        }
        if (record.getPence2() != 0) {
            System.out.println("2 pence: " + record.getPence2());
        }
        if (record.getPence1() != 0) {
            System.out.println("1 pence: " + record.getPence1());
        }
    }

    /*
     * Method to display person with the smallest coin amount
     */
    private static void displaySmallestCoinAmount(ChangeC[] coinChangeRecords) {

        // Check if records is empty
        if (coinChangeRecords[0] != null) {
            // Set the first record as the record with smallest coin amount
            ChangeC smallestCoinPerson = coinChangeRecords[0];

            // Loop through records
            for (ChangeC record : coinChangeRecords) {
                // Replace smallestCoinPerson if another record is found with smaller coin
                // amount
                if (record != null && record.getCoinAmount() < smallestCoinPerson.getCoinAmount()) {
                    smallestCoinPerson = record;
                }
            }

            // Display change details of the user
            System.out.println("\nCustomer with the smallest coin amount:");
            System.out.println(smallestCoinPerson.getName() + " " + smallestCoinPerson.getCoinAmount() + " pence\n");
            displayChangeDetails(smallestCoinPerson);

        } else {
            System.out.println("\nNo record found");
        }
    }

    /*
     * Method to display person with the largest coin amount
     */
    private static void displayLargestCoinAmount(ChangeC[] coinChangeRecords) {

        // Check if records is empty
        if (coinChangeRecords[0] != null) {
            // Set the first record as the record with smallest coin amount
            ChangeC largestCoinPerson = coinChangeRecords[0];

            // Loop through records
            for (ChangeC record : coinChangeRecords) {
                // Replace smallestCoinPerson if another record is found with smaller coin
                // amount
                if (record != null && record.getCoinAmount() > largestCoinPerson.getCoinAmount()) {
                    largestCoinPerson = record;
                }
            }

            // Display change details of the user
            System.out.println("\nCustomer with the largest coin amount:");
            System.out.println(largestCoinPerson.getName() + " " + largestCoinPerson.getCoinAmount() + " pence\n");
            displayChangeDetails(largestCoinPerson);

        } else {
            System.out.println("\nNo record found");
        }
    }

    /*
     * Method to calculate the total number of coins for each denomination across
     * all records
     */
    private static void calculateTotalCoinsOfDenominations(ChangeC[] coinChangeRecords) {
        int pound2Coin = 0;
        int pound1Coin = 0;
        int pence50Coin = 0;
        int pence20Coin = 0;
        int pence10Coin = 0;
        int pence5Coin = 0;
        int pence2Coin = 0;
        int pence1Coin = 0;

        // Loop through records to get the total number of coins for each denomination
        for (ChangeC record : coinChangeRecords) {
            if (record != null) {
                pound2Coin += record.getPound2();
                pound1Coin += record.getPound1();
                pence50Coin += record.getPence50();
                pence20Coin += record.getPence20();
                pence10Coin += record.getPence10();
                pence5Coin += record.getPence5();
                pence2Coin += record.getPence2();
                pence1Coin += record.getPence1();
            }
        }

        // Display the total coins for each denominations
        System.out.println("\nTotal number of coins for each denomination across all records:");
        displayAllDenomination(pound2Coin, pound1Coin, pence50Coin, pence20Coin, pence10Coin, pence5Coin, pence2Coin,
                pence1Coin);
    }

    /*
     * Method to display values associated to each denomination
     */
    private static void displayAllDenomination(int pound2, int pound1, int pence50, int pence20, int pence10,
            int pence5, int pence2, int pence1) {
        System.out.println("£2: " + pound2);
        System.out.println("£1: " + pound1);
        System.out.println("50 pence: " + pence50);
        System.out.println("20 pence: " + pence20);
        System.out.println("10 pence: " + pence10);
        System.out.println("5 pence: " + pence5);
        System.out.println("2 pence: " + pence2);
        System.out.println("1 pence: " + pence1);
    }

    /*
     * Method to calculate the sum amount of each denomination across all records
     */
    private static void calculateTotalSumOfDenominations(ChangeC[] coinChangeRecords) {
        int totalSum = 0;
        int pound2Sum = 0;
        int pound1Sum = 0;
        int pence50Sum = 0;
        int pence20Sum = 0;
        int pence10Sum = 0;
        int pence5Sum = 0;
        int pence2Sum = 0;
        int pence1Sum = 0;

        // Loop through records to get the sum amount of each denomination
        for (ChangeC record : coinChangeRecords) {
            if (record != null) {
                totalSum += record.getCoinAmount();
                pound2Sum += record.getPound2() * 200;
                pound1Sum += record.getPound1() * 100;
                pence50Sum += record.getPence50() * 50;
                pence20Sum += record.getPence20() * 20;
                pence10Sum += record.getPence10() * 10;
                pence5Sum += record.getPence5() * 5;
                pence2Sum += record.getPence2() * 2;
                pence1Sum += record.getPence1() * 1;
            }
        }

        // Display the sum amount of each denominations
        System.out.println("\nTotal sum amount across all records: " + totalSum + " pence\n");
        System.out.println("Breakdown of each denomination (in pence):");
        displayAllDenomination(pound2Sum, pound1Sum, pence50Sum, pence20Sum, pence10Sum, pence5Sum, pence2Sum,
                pence1Sum);
    }
}
