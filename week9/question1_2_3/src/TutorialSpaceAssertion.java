/*
 * Title: Lab Week 9 - Question 1, 2, 3
 * Author: Vimalnath Nambiar
 * Date: 31-10-2023
 * File: TutorialSpaceAssertion.java
 * 
 * Purpose: 
 * - Used to enrol student in a tutorial class
 * 
 * Assumptions/Conditions:
 * - Have private instances: slots (int) and activated (boolean)
 * - Use assertions to check for exceptions
 */

public class TutorialSpaceAssertion {
    private int slots;
    private boolean activated;

    // Constructor
    public TutorialSpaceAssertion(){
        this.slots = 0;
        this.activated = false;
    }

    public TutorialSpaceAssertion(int slots){
        this.slots = slots;
    }

    public void activate(){
        assert !this.activated : "Tutorial class has already been activated";
        this.activated = true;
    }

    public void reserveSlot(){
        assert this.slots > 0 && this.activated : "Slot is completely used or the tutorial class is not active";
        this.slots--;
    }

    public int slotsRemaining(){
        return this.slots;
    }
}
