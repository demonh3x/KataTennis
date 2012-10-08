/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PqKataTennis;

/**
 *
 * @author demonh3x
 */
public class Game {
    private Scores scores = new Scores();
    private String[] names;

    public Game(String playerAName, String playerBName) {
        this.names = new String[]{playerAName, playerBName};
    }
    
    private Integer getPlayerIndex(String player) {
        for (int i = 0; i < names.length; i++) {
            if (names[i].equals(player)){
                return i;
            }
        }
        return null;
    }
    
    /**
     * Gets the player's score
     * @param player
     * The player to get his/her score
     * @return 
     * A string containing the player's score
     */
    public String getScore(String player){        
        return scores.getScore(getPlayerIndex(player));
    }
    
    /**
     * Score a point for a player
     * @param player
     * The name of the player to score
     */
    public void score(String player) {
        scores.score(getPlayerIndex(player).intValue());
    }
    
    /**
     * Get the winner of the game
     * @return 
     * The name of the player<br>
     * null if the game is not finished
     */
    public String getWinner() {
        Integer winner = scores.getWinner();
        return (winner == null) ? null : names[winner];
    }
}
