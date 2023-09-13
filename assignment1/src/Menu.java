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
    public static boolean executeMenuOptions(Scanner kb, ChangeC[] array, int menuOption) {
        switch (menuOption) {
            case 1:
                displayChangeForName(kb, array);
                break;

            case 2:
                displaySmallestCoinAmount(array);
                break;

            case 3:
                displayLargestCoinAmount(array);
                break;

            case 4:
                calculateTotalCoinsOfDenominations(array);
                break;

            case 5:
                calculateTotalSumOfDenominations(array);
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
    private static void displayChangeForName(Scanner kb, ChangeC[] array) {
        while (true) {
            try {
                // Get a name to search for
                System.out.print("\nPlease enter a person's name that you would like display the change for: ");
                String name = kb.next();

                // Loop through array
                boolean isFound = false;
                for (ChangeC changeC : array) {
                    // If name is found in array, display change details
                    if (changeC != null && changeC.getName().equalsIgnoreCase(name)) {
                        isFound = true;
                        System.out.println("\nCustomer:");
                        System.out.println(changeC.getName() + " " + changeC.getCoinAmount() + " pence\n");
                        displayChangeDetails(changeC);
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
    private static void displayChangeDetails(ChangeC changeC) {
        System.out.println("Change:");

        if (changeC.getPound2() != 0) {
            System.out.println("£2: " + changeC.getPound2());
        }
        if (changeC.getPound1() != 0) {
            System.out.println("£1: " + changeC.getPound1());
        }
        if (changeC.getPence50() != 0) {
            System.out.println("50 pence: " + changeC.getPence50());
        }
        if (changeC.getPence20() != 0) {
            System.out.println("20 pence:" + changeC.getPence20());
        }
        if (changeC.getPence10() != 0) {
            System.out.println("10 pence:" + changeC.getPence10());
        }
        if (changeC.getPence5() != 0) {
            System.out.println("5 pence: " + changeC.getPence5());
        }
        if (changeC.getPence2() != 0) {
            System.out.println("2 pence: " + changeC.getPence2());
        }
        if (changeC.getPence1() != 0) {
            System.out.println("1 pence: " + changeC.getPence1());
        }
    }

    /*
     * Method to display person with the smallest coin amount
     */
    private static void displaySmallestCoinAmount(ChangeC[] array) {

        // Check if array is empty
        if (array[0] != null) {
            // Set the first index as the object with smallest coin amount
            ChangeC smallestCoinPerson = array[0];

            // Loop through array
            for (ChangeC changeC : array) {
                // Replace smallestCoinPerson if another object is found with smaller coin
                // amount
                if (changeC != null && changeC.getCoinAmount() < smallestCoinPerson.getCoinAmount()) {
                    smallestCoinPerson = changeC;
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
    private static void displayLargestCoinAmount(ChangeC[] array) {

        // Check if array is empty
        if (array[0] != null) {
            // Set the first index as the object with smallest coin amount
            ChangeC largestCoinPerson = array[0];

            // Loop through array
            for (ChangeC changeC : array) {
                // Replace smallestCoinPerson if another object is found with smaller coin
                // amount
                if (changeC != null && changeC.getCoinAmount() > largestCoinPerson.getCoinAmount()) {
                    largestCoinPerson = changeC;
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
     * all objects
     */
    private static void calculateTotalCoinsOfDenominations(ChangeC[] array) {
        int pound2Coin = 0;
        int pound1Coin = 0;
        int pence50Coin = 0;
        int pence20Coin = 0;
        int pence10Coin = 0;
        int pence5Coin = 0;
        int pence2Coin = 0;
        int pence1Coin = 0;

        // Loop through array to get the total number of coins for each denomination
        for (ChangeC changeC : array) {
            if (changeC != null) {
                pound2Coin += changeC.getPound2();
                pound1Coin += changeC.getPound1();
                pence50Coin += changeC.getPence50();
                pence20Coin += changeC.getPence20();
                pence10Coin += changeC.getPence10();
                pence5Coin += changeC.getPence5();
                pence2Coin += changeC.getPence2();
                pence1Coin += changeC.getPence1();
            }
        }

        // Display the total coins for each denominations
        System.out.println("\nTotal number of coins for each denomination:");
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
     * Method to calculate the sum amount of each denomination across all objects
     */
    private static void calculateTotalSumOfDenominations(ChangeC[] array) {
        int totalSum = 0;
        int pound2Sum = 0;
        int pound1Sum = 0;
        int pence50Sum = 0;
        int pence20Sum = 0;
        int pence10Sum = 0;
        int pence5Sum = 0;
        int pence2Sum = 0;
        int pence1Sum = 0;

        // Loop through array to get the sum amount of each denomination
        for (ChangeC changeC : array) {
            if (changeC != null) {
                totalSum += changeC.getCoinAmount();
                pound2Sum += changeC.getPound2() * 200;
                pound1Sum += changeC.getPound1() * 100;
                pence50Sum += changeC.getPence50() * 50;
                pence20Sum += changeC.getPence20() * 20;
                pence10Sum += changeC.getPence10() * 10;
                pence5Sum += changeC.getPence5() * 5;
                pence2Sum += changeC.getPence2() * 2;
                pence1Sum += changeC.getPence1() * 1;
            }
        }

        // Display the sum amount of each denominations
        System.out.println("\nTotal sum amount: " + totalSum + " pence\n");
        System.out.println("Breakdown:");
        displayAllDenomination(pound2Sum, pound1Sum, pence50Sum, pence20Sum, pence10Sum, pence5Sum, pence2Sum,
                pence1Sum);
    }
}
