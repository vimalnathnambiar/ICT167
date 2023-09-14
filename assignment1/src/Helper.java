/*
 * Title: Assignment 1
 * Author: Vimalnath Nambiar
 * Date: 13-09-2023
 * File: Helper.java
 * 
 * Purpose:
 * 1. Perform basic general methods to assist with client input validation
 *      - Check if same name exists in array
 *      - check if coin amount is less than 0
 *      - Check if proceed input is valid
 *      - Change coin amount for a person in the array
 * 
 * Assumptions/Conditions:
 * 1. Coin amount is assumed to not be lesser than 0
 */

/*
 * Helper class
 */
public class Helper {
    /*
     * Method to check if a record with the name inputted already exists
     */
    public static boolean isNameExists(ChangeC[] coinChangeRecords, String name) {
        // Loop through array
        for (ChangeC record : coinChangeRecords) {
            // Check if index of the array is not null and
            // if the ChangeC object has the same name
            if (record != null && record.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    /*
     * Method to throw an exception if coinAmount is less than 0
     */
    public static void isCoinAmountLessThanZero(int coinAmount) throws Exception {
        if (coinAmount < 0) {
            throw new Exception("\nInvalid input. Coin amount cannot be lesser than 0. Please try again...\n");
        }
    }

    /*
     * Method to throw an exception if proceed is not 'Y' or 'N'
     */
    public static void isProceedValid(char input) throws Exception {
        if (input != 'Y' && input != 'N') {
            throw new Exception("\nInvalid input. Please try again...");
        }
    }

    /*
     * Method to set a new coin amount for an already existing record
     * and return updated ChangeC record array
     */
    public static ChangeC[] setNewCoinAmount(ChangeC[] coinChangeRecords, String name, int coinAmount) {
        // Loop through array
        for (ChangeC record : coinChangeRecords) {
            // Check if index of the array is not null and
            // if the ChangeC object has the same name
            if (record != null && record.getName().equalsIgnoreCase(name)) {
                // Set new coin amount
                record.setCoinAmount(coinAmount);
                break;
            }
        }

        return coinChangeRecords;
    }
}
