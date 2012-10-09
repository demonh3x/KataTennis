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
    private static Game game;
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        Player.One.setName(ask("Player A's name: "));
        Player.Two.setName(ask("Player B's name: "));

        game = new Game();
        System.out.println("Game started!");
        
        do {
            game.score(askScorer());
            printScores();
        } while (game.getWinner() == null);
        
        System.out.println("The winner is: " + game.getWinner().getName());
    }
    
    private static void printScores(){
        String scores = Player.One.getName() + ": " + game.getScore(Player.One) + ", " +
                Player.Two.getName() + ": " + game.getScore(Player.Two);

        System.out.println(scores);
    }
    
    private static Player askScorer(){
        String name;
        Player scorer;
        
        do {
            name = ask("Who scores? (" + Player.One.getName() + "/" + 
                                         Player.Two.getName() + "): ");
            scorer = Player.get(name);
            
        } while (scorer == null);
        
        return scorer;
    }
    
    private static String ask(String message){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        String ret = null;
        
        do {
            System.out.println(message);
            try {
                ret = reader.readLine();
            } catch (IOException ex) {
            }
        } while (ret == null);
        
        return ret;
    }

}
