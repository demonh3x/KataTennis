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
    
    public Scores() {
        for (int i = 0; i < scores.length; i++) {
            scores[i] = new Score();
        }
    }
    
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
        
        Integer advantage = getAdvantage();
        if (advantage == null)
        {
            return Integer.toString(scores[index].getValue());
        }
        else if (advantage == -1) 
        {
            return "Deuce";
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
     * Get the advantage info
     * @return 
     * null if not in advantage system or a winner is set<br>
     * -1 Deuce<br>
     * 0..1 The advantaged score's index
     */
    public Integer getAdvantage() {
        if ((getWinner() != null) || (!advantageSystem())) {
            return null;
        }
        
        if (advantageDifference() > 0) {
            return (advantages[0] > advantages[1]) ? 0 : 1;
        } else {
            return -1;
        }
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
