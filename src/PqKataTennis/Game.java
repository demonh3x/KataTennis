/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PqKataTennis;

/**
 *
 * @author demonh3x
 */
public class Game{ 
    private Score[] scores = {new Score(), new Score()};
    private int[] advantages = {0, 0};
    private Player winner = null;

    /**
     * Increments a score
     * @param scorer
     * The player who scores
     */
    public void score(Player scorer) {        
        if ((getWinner() != null)) {
            return;
        }
        
        if (advantageSystem()){
            advantages[scorer.ordinal()]++;
            
            if (advantageDifference() >= 2){
                winner = scorer;
            }
            
        } else {
            if (scores[scorer.ordinal()].isMax()) {
                winner = scorer;
            } else {
                scores[scorer.ordinal()].increment();
            }
        }
    }
    
    /**
     * Get a score
     * @param player
     * The player to get his/her score
     * @return 
     * A text containing the score
     */
    public String getScore(Player player) {       
        Player win = getWinner();
        if (win != null) {
            return (player == win) ? "Winner" : "Loser";
        }
        
        if (isDeuce()){
            return "Deuce";
        }
        
        Player advantage = getAdvantage();
        if (advantage == null)
        {
            return Integer.toString(scores[player.ordinal()].getValue());
        }
        else 
        {
            return (player == advantage)? "Advantaged" : "Disadvantaged";
        }
    }
    
    /**
     * Get the winner
     * @return 
     * The winning player.<br>
     * null if there is no winner yet.
     */
    public Player getWinner() {
        return winner;
    }
    
    /**
     * Is it in Deuce state?
     * @return 
     * true if the scores are maxed out and even.
     */
    public boolean isDeuce() {
        return advantageSystem() && (advantageDifference() == 0);
    }
    
    /**
     * Get the advantage info
     * @return 
     * The advantaged player<br>
     * null if a winner is set, both scores aren't at max or in deuce state
     */
    public Player getAdvantage() {
        if (!advantageSystem() || isDeuce() || (getWinner() != null)) {
            return null;
        }
        
        return (advantages[Player.One.ordinal()] > advantages[Player.Two.ordinal()]) ?
                Player.One : Player.Two;
    }
    
    private boolean advantageSystem() {
        return scores[Player.One.ordinal()].isMax() && 
               scores[Player.Two.ordinal()].isMax();
    }
    
    private int advantageDifference() {
        return Math.abs(advantages[Player.One.ordinal()] -
                        advantages[Player.Two.ordinal()]);
    }
}
