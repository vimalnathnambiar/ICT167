/*
 * Title: Lab Week 9 - Question 1, 2, 3
 * Author: Vimalnath Nambiar
 * Date: 31-10-2023
 * File: NotActivatedException.java
 * 
 * Purpose: 
 * - An exception class for throwing exception if tutorial class has already been activated
 * 
 * Assumptions/Conditions:
 * -
 */

public class NotActivatedException extends Exception{
    public NotActivatedException(){
        super("Tutorial class has already been activated");
    }

}
