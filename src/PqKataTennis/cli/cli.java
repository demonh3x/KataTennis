/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PqKataTennis.cli;

import PqKataTennis.Game;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author demonh3x
 */
public class cli {
    private static String[] players = new String[2];
    private static Game game;
            
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   
        players[0] = ask("Player A's name: ");
        players[1] = ask("Player B's name: ");
        
        game = new Game(players[0], players[1]);
        System.out.println("Game started!");
        
        do {
            game.score(askScorer());
            printScores();
        } while (game.getWinner() == null);
        
        System.out.println("The winner is: " + game.getWinner());
    }
    
    private static void printScores(){
        String scores = players[0] + ": " + game.getScore(players[0]);
        
        for (int i = 1; i < players.length; i++) {
            scores += ", " + players[i] + ": " + game.getScore(players[i]);
        }
        
        System.out.println(scores);
    }
    
    private static String askScorer(){
        String scorer;
        
        do {
            scorer = ask("Who scores? (" + players[0] + "/" + players[1] + "): ");
        } while (!validName(scorer));
        
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
    
    private static boolean validName(String name){
        for (int i = 0; i < players.length; i++) {
            if (players[i].equals(name)){
                return true;
            }
        }
        
        return false;
    }

}
