/*
 * Title: Lab Week 9 - Question 1, 2, 3
 * Author: Vimalnath Nambiar
 * Date: 31-10-2023
 * File: RegisterClassAssertion.java
 * 
 * Purpose: 
 * - Used to test TutorialSpace class
 * 
 * Assumptions/Conditions:
 * - Consider test strategies to tell all the methods and exception in TutorialSpace
 */

public class RegisterClassAssertion {
    public static void main(String[] args){
        // Reinitialise oject but with constructor that accept slot amount
        TutorialSpaceAssertion tutorial = new TutorialSpaceAssertion(1);

        // Test reserve slot
        // Should throw an error as tutorial is not activated
        tutorial.reserveSlot();

        // Test activate
        // Shouldn't throw an error
            tutorial.activate();

        // Test activate
        // Should throw an error as tutorial is activated
        tutorial.activate();

        // Test reserve slot
        // Shouldn't throw an error
        tutorial.reserveSlot();

        // Test reserve slot
        // Should throw an error as no slots are available
        tutorial.reserveSlot();
    }
}