/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PqKataTennis;

/**
 *
 * @author demonh3x
 */
public class Scores{ 
    private Score[] scores = {new Score(), new Score()};
    private Integer[] advantages = {new Integer(0), new Integer(0)};
    private Integer winner = null;

    /**
     * Increments a score
     * @param index
     * The index of the score to increment (0 or 1)
     * @return 
     * true if able to increment the score, false otherwise<br>
     * If the received index is null or an invalid value, false is returned
     */
    public boolean score(Integer index) {
        if ((!validIndex(index)) || (getWinner() != null)) {
            return false;
        }
        
        if (advantageSystem()){
            advantages[index]++;
            if (advantageDifference() >= 2){
                winner = index;
            }
            return true;
            
        } else {
            if (scores[index].isMax()) {
                winner = index;
                return true;
            }
        }
        
        return scores[index].increment();
    }
    
    /**
     * Get a score
     * @param index
     * The index of the score to get (0 or 1)
     * @return 
     * A text containing the score<br>
     * If the received index is null or an invalid value, null is returned
     */
    public String getScore(Integer index) {
        if (!validIndex(index)){
            return null;
        }
        
        Integer win = getWinner();
        if (win != null) {
            return (index == win) ? "Winner" : "Loser";
        }
        
        if (isDeuce()){
            return "Deuce";
        }
        
        Integer advantage = getAdvantage();
        if (advantage == null)
        {
            return Integer.toString(scores[index].getValue());
        }
        else 
        {
            return (index == advantage)? "Advantaged" : "Disadvantaged";
        }
    }
    
    /**
     * Get the winner
     * @return 
     * The winning score's index.<br>
     * null if there is no winner yet.
     */
    public Integer getWinner() {
        return winner;
    }
    
    /**
     * Is it in Deuce state?
     * @return 
     * true if no score has advantage, false if one does.
     */
    public boolean isDeuce() {
        return advantageSystem() && (advantageDifference() == 0);
    }
    
    /**
     * Get the advantage info
     * @return 
     * 0..1 The advantaged score's index<br>
     * null if a winner is set, not in advantage system or in deuce state
     */
    public Integer getAdvantage() {
        if (!advantageSystem() || isDeuce() || (getWinner() != null)) {
            return null;
        }
        
        return (advantages[0] > advantages[1]) ? 0 : 1;
    }
    
    private boolean advantageSystem() {
        return scores[0].isMax() && scores[1].isMax();
    }
    
    private int advantageDifference() {
        return Math.abs(advantages[0] - advantages[1]);
    }
    
    private boolean validIndex(Integer index) {
        if (index == null) {
            return false;
        }
        
        if (index >= 0 && index <= 1) {
            return true;
        } else {
            return false;
        }
    }
}
