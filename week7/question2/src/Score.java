/*
 * Title: Lab Week 7 - Question 2
 * Author: Vimalnath Nambiar
 * Date: 30-10-2023
 * File: Score.java
 * 
 * Purpose: 
 * - Store score records
 * 
 * Assumptions/Conditions:
 * - 2 instance variables
 * - Default constructor
 * - Get and set methods for the 2 instance variables
 * - Instance variables are private
 */

 public class Score {
    // Instance variables
    private String name;
    private double score;

    // Constructors
    public Score(){
        this.name = "";
        this.score = 0;
    }

    public Score(String name, double score){
        this.name = name;
        this.score = score;
    }

    // Setters and getters
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setScore(double score){
        this.score = score;
    }

    public double getScore(){
        return this.score;
    }
 }