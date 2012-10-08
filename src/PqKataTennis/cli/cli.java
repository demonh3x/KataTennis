/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PqKataTennis.cli;

import PqKataTennis.Game;
import PqKataTennis.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author demonh3x
 */
public class cli {
    private static Player p1 = new Player("Jugador 1");
    private static Player p2 = new Player("Jugador 2");
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        Game g = new Game(p1, p2);
        
        while (g.getWinner() == null){
            Player scoringPlayer = askPlayer("Jugador que ha marcado (1/2):");
            g.score(scoringPlayer);
            
            System.out.println(g.getScores());
        }
    }
    
    private static Player askPlayer(String text){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String resp = null;
        int playerNumber = -1;
        do {
            System.out.println(text);

            try {
                resp = reader.readLine();
                playerNumber = Integer.parseInt(resp);
            } catch (IOException ex) {
            }
        } while (resp == null || !validPlayerAnswer(playerNumber));
        
        switch (playerNumber) {
            case 1:
                return p1;
            case 2:
                return p2;
            default:
                throw new AssertionError();
        }
    }
    
    private static boolean validPlayerAnswer(int playerNumber){
        return (playerNumber == 1 || playerNumber == 2);
    }
}
