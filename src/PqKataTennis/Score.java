/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PqKataTennis;

/**
 *
 * @author demonh3x
 */
public class Score {
    private int scoreCounter = 0;
    private int[] scoreValues = {0, 15, 30, 40};
    
    /**
     * Increments the value
     * @return 
     * true if able to increment, false otherwise
     */
    public boolean increment(){
        if (isMax()){
            return false;
        }
        
        scoreCounter++;
        return true;
    }
    
    /**
     * Is the maximum value reached?
     * @return 
     * true if the value is at the max, false otherwise
     */
    public boolean isMax(){
        return scoreCounter == scoreValues.length -1;
    }
    
    /**
     * Get the value
     * @return 
     * the score's number
     */
    public int getValue(){
        return scoreValues[scoreCounter];
    }
}
