/*
 * Title: Lab Week 9 - Question 1, 2, 3
 * Author: Vimalnath Nambiar
 * Date: 31-10-2023
 * File: RegisterClass.java
 * 
 * Purpose: 
 * - Used to test TutorialSpace class
 * 
 * Assumptions/Conditions:
 * - Consider test strategies to tell all the methods and exception in TutorialSpace
 */

public class RegisterClass {
    public static void main(String[] args){
        // Reinitialise oject but with constructor that accept slot amount
        TutorialSpace tutorial = new TutorialSpace(1);

        // Test reserve slot
        try{
            // Should throw an error as tutorial is not activated
            tutorial.reserveSlot();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        // Test activate
        try{
            // Shouldn't throw an error
            tutorial.activate();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        // Test activate
        try{
            // Should throw an error as tutorial is activated
            tutorial.activate();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        // Test reserve slot
        try{
            // Shouldn't throw an error
            tutorial.reserveSlot();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }

        // Test reserve slot
        try{
            // Should throw an error as no slots are available
            tutorial.reserveSlot();
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
