/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PqKataTennis;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author demonh3x
 */
public class GameTest {
    
    public GameTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testPerfectGame() {
        Player playerA = new Player("PlayerA");
        Player playerB = new Player("PlayerB");
        
        Game game = new Game(playerA, playerB);
        
        for (int i = 0; i < 3; i++) {
            game.score(playerA);
            assertEquals(null, game.getWinner());
        }
        game.score(playerA);
        assertEquals(playerA, game.getWinner());
    }
    
    @Test
    public void testEasyWin() {
        Player playerA = new Player("PlayerA");
        Player playerB = new Player("PlayerB");
        
        Game game = new Game(playerA, playerB);
        
        for (int i = 0; i < 2; i++) {
            game.score(playerA);
            assertEquals(null, game.getWinner());
        }
        //Score A: 30

        for (int i = 0; i < 3; i++) {
            game.score(playerB);
            assertEquals(null, game.getWinner());
        }
        //score B: 40

        //Winner
        game.score(playerB);
        assertEquals(playerB, game.getWinner());
    }
    
    
    @Test
    public void testDeuce() {
        Player playerA = new Player("PlayerA");
        Player playerB = new Player("PlayerB");
        
        Game game = new Game(playerA, playerB);
        
        for (int i = 0; i < 3; i++) {
            game.score(playerA);
            assertEquals(null, game.getWinner());
            game.score(playerB);
            assertEquals(null, game.getWinner());
        }
 
        // Deuce
        
        game.score(playerB);
        //score B: Adv
        assertEquals(null, game.getWinner());
        
         game.score(playerB);
        //score B: Winner
        assertEquals(playerB, game.getWinner());
    }
    
    @Test
    public void testBackAndForth() {
        Player playerA = new Player("PlayerA");
        Player playerB = new Player("PlayerB");
        
        Game game = new Game(playerA, playerB);
        
        for (int i = 0; i < 30; i++) {
            game.score(playerA);
            assertEquals(null, game.getWinner());
            game.score(playerB);
            assertEquals(null, game.getWinner());
        }
        
        // Deuce
        
        game.score(playerB);
        //score B: Adv
        assertEquals(null, game.getWinner());
        
         game.score(playerB);
        //score B: Winner
        assertEquals(playerB, game.getWinner());
    }
}
