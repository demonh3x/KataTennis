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
    private Player[] players;
    private Player advantage = null;
    private Player winner = null;

    public Game(Player playerA, Player playerB) {
        this.players = new Player[]{playerA, playerB};
    }
    
    private Player getRival(Player player){
        if (player.equals(this.players[0])){
            return this.players[1];
        }else{
            return this.players[0];
        }
    }
    
    public boolean score(Player scoringPlayer){
        if (getWinner() != null){
            return false;
        }
        
        if (!scoringPlayer.getScore().isMax()){
            scoringPlayer.getScore().increment();
        }else{
            if (getRival(scoringPlayer).getScore().isMax()){
                if (advantage == null){
                    advantage = scoringPlayer;
                }else if (advantage.equals(getRival(scoringPlayer))){
                    advantage = null;
                }else if (advantage.equals(scoringPlayer)){
                    winner = scoringPlayer;
                }
            }else{
                winner = scoringPlayer;
            }
        }
        
        return true;
    }
    
    public Player getWinner(){
        return winner;
    }

    public Player getPlayerA() {
        return players[0];
    }

    public Player getPlayerB() {
        return players[1];
    }

    public Player getAdvantage() {
        return advantage;
    }
    
    public boolean advantageGame(){
        return getPlayerA().getScore().isMax() && getPlayerB().getScore().isMax();
    }
}
