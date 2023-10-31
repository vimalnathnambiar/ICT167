/*
 * Title: Lab Week 9 - Question 1, 2, 3
 * Author: Vimalnath Nambiar
 * Date: 31-10-2023
 * File: TutorialSpace.java
 * 
 * Purpose: 
 * - Used to enrol student in a tutorial class
 * 
 * Assumptions/Conditions:
 * - Have private instances: slots (int) and activated (boolean)
 * - Throw self-defined exception class
 */

public class TutorialSpace {
    private int slots;
    private boolean activated = false;

    // Constructor
    public TutorialSpace(){
        this.slots = 0;
        this.activated = false;
    }

    public TutorialSpace(int slots){
        this.slots = slots;
    }

    public void activate() throws NotActivatedException{
        if(this.activated){
            throw new NotActivatedException();
        }
        this.activated = true;
    }

    public void reserveSlot() throws EmptyException{
        if(this.slots == 0 || this.activated == false){
            throw new EmptyException();
        }

        this.slots--;
    }

    public int slotsRemaining(){
        return this.slots;
    }
}
