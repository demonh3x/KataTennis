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
    
    protected boolean increment(){
        if (isMax()){
            return false;
        }
        
        scoreCounter++;
        return true;
    }
    
    public boolean isMax(){
        return scoreCounter == scoreValues.length -1;
    }
    
    public int getValue(){
        return scoreValues[scoreCounter];
    }
}
