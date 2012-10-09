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
    public void testPerfectWin() {
        Game s = new Game();
        
        for (int i = 0; i < 4; i++) {
            assertEquals(null, s.getWinner());
            s.score(Player.Two);
        }
        assertEquals(Player.Two, s.getWinner());
    }
    
    @Test
    public void testDeuce() {
        Game s = new Game();
        
        for (int i = 0; i < 3; i++) {
            assertEquals(false, s.isDeuce());
            s.score(Player.One);
            assertEquals(false, s.isDeuce());
            s.score(Player.Two);
        }
        assertEquals(true, s.isDeuce());
    }
    
    @Test
    public void testAdvantages() {
        Game s = new Game();
        
        for (int i = 0; i < 3; i++) {
            s.score(Player.One);
            s.score(Player.Two);
        }
        s.score(Player.One);
        assertEquals(Player.One, s.getAdvantage());
        s.score(Player.Two);
        assertEquals(null, s.getAdvantage());
        s.score(Player.Two);
        assertEquals(Player.Two, s.getAdvantage());
    }
    
    @Test
    public void testBackAndForthWin() {
        Game s = new Game();
        
        for (int i = 0; i < 40; i++) {
            s.score(Player.One);
            s.score(Player.Two);
        }
        s.score(Player.One);
        s.score(Player.One);
        assertEquals(Player.One, s.getWinner());
    }
    
    
    @Test
    public void testIllegalScoresWin() {
        Game s = new Game();
        
        for (int i = 0; i < 40; i++) {
            s.score(Player.One);
            s.score(Player.Two);
        }
        for (int i = 0; i < 3; i++) {
            s.score(Player.One);
        }
        for (int i = 0; i < 10; i++) {
            s.score(Player.Two);
        }
        assertEquals(Player.One, s.getWinner());
    }
    
}
