/*
 * Title: Assignment 1
 * Author: Vimalnath Nambiar
 * Date: 13-09-2023
 * File: ChangeC.java
 * 
 * Purpose:
 * 
 * Assumptions/Conditions:
 * 1. The name of the class should be ChangeC
 * 2. Two instance variables is required
 *      - To store the name of a person
 *      - The coin change amount to be given to the person
 * 3. In UK, the coin denominations are 1p, 2p, 5p, 10p, 20p, 50p, £1 and £2
 *      - The use of 8 instance variables to represent the amounts for each of the 8-coin denominations
 *      - There's no need for more than these instances. 
 *      - Provide justification in internal and external documentation of their usage if different way is used to implement
 * 4. All these variables are to be declared private
 * 5. Think of a way such that client program can use the same class name and public methods for other countries with different coin denominations without changing their class program
 *      - Work on a design that does not require client class to make any changes if ChangeC needs to be upgraded to accommodate different coin denominations for different countries
 *      - Explain how your class satisfy the above and the concepts used in your external documentation
 * 6. Have at least a default constructor and constructor with two parameters (name and coin amount)
 * 7. Provide appropriate get and set methods for client usage
 * 8. Other methods (including helpers) may be provided as needed
 *      - Provide legitimate justification for their usage in the external and internal documentation
 * 9. Class should not include input and output methods
 *      - Use get method to get data class object to the client program
 * 10. Data class methods should not write data out
 * 11. Data should be entered into the data class object via a constructor or appropriate set methods
 * 12. Aim to give as much of the higher valued coins as possible
 */

/*
 * Data class called ChangeC
 */
public class ChangeC {
    /*
     * Global variables
     */
    private String name;
    private int coinAmount, pence1, pence2, pence5, pence10, pence20, pence50, pound1, pound2;

    /*
     * Constructors
     */
    // Default Constructor
    public ChangeC() {
        // Set default values of instances
        this.name = "Default";
        this.coinAmount = 0;
        this.pence1 = 0;
        this.pence2 = 0;
        this.pence5 = 0;
        this.pence10 = 0;
        this.pence20 = 0;
        this.pence50 = 0;
        this.pound1 = 0;
        this.pound2 = 0;
    }

    // Constructor that accepts two input parameters:
    // (name: String and coinAmount: int)
    public ChangeC(String name, int coinAmount) {
        // Set name
        this.name = name;

        // Set coinAmount
        this.coinAmount = coinAmount;

        // Calculate number of coins for each denomination values
        calculateChange();
    }

    /*
     * Accessor methods
     * - Return values of the private instances
     */
    public String getName() {
        return this.name;
    }

    public int getCoinAmount() {
        return this.coinAmount;
    }

    public int getPence1() {
        return this.pence1;
    }

    public int getPence2() {
        return this.pence2;
    }

    public int getPence5() {
        return this.pence5;
    }

    public int getPence10() {
        return this.pence10;
    }

    public int getPence20() {
        return this.pence20;
    }

    public int getPence50() {
        return this.pence50;
    }

    public int getPound1() {
        return this.pound1;
    }

    public int getPound2() {
        return this.pound2;
    }

    /*
     * Mutator methods
     * - Set new values for the private instances
     */
    public void setCoinAmount(int coinAmount) {
        // Set value for coinAmount
        this.coinAmount = coinAmount;

        // Calculate number of coins for each denomination values
        calculateChange();
    }

    /*
     * Method to calculate the number of coins needed for each denomination
     * - Checks for highest denomination to the lowest denomination
     */
    private void calculateChange() {
        // Stores the remaining balance of the coinAmount that requires change
        int balance = this.coinAmount;

        // Calculates number of £2 required
        this.pound2 = balance / 200;
        balance %= 200;

        // Calculates number of £1 required
        this.pound1 = balance / 100;
        balance %= 100;

        // Calculates number of 50p required
        this.pence50 = balance / 50;
        balance %= 50;

        // Calculates number of 20p required
        this.pence20 = balance / 20;
        balance %= 20;

        // Calculates number of 10p required
        this.pence10 = balance / 10;
        balance %= 10;

        // Calculates number of 5p required
        this.pence5 = balance / 5;
        balance %= 5;

        // Calculates number of 2p required
        this.pence2 = balance / 2;
        balance %= 2;

        // Calculates number of 1p required
        this.pence1 = balance;
    }
}
