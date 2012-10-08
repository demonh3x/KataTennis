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
public class ScoresTest {
    
    public ScoresTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testPerfectWin() {
        Scores s = new Scores();
        
        for (int i = 0; i < 4; i++) {
            assertEquals(null, s.getWinner());
            s.score(1);
        }
        assertEquals(new Integer(1), s.getWinner());
    }
    
    @Test
    public void testDeuce() {
        Scores s = new Scores();
        
        for (int i = 0; i < 3; i++) {
            assertEquals(false, s.isDeuce());
            s.score(0);
            assertEquals(false, s.isDeuce());
            s.score(1);
        }
        assertEquals(true, s.isDeuce());
    }
    
    @Test
    public void testAdvantages() {
        Scores s = new Scores();
        
        for (int i = 0; i < 3; i++) {
            s.score(0);
            s.score(1);
        }
        s.score(0);
        assertEquals(new Integer(0), s.getAdvantage());
        s.score(1);
        assertEquals(null, s.getAdvantage());
        s.score(1);
        assertEquals(new Integer(1), s.getAdvantage());
    }
    
    @Test
    public void testBackAndForthWin() {
        Scores s = new Scores();
        
        for (int i = 0; i < 40; i++) {
            s.score(0);
            s.score(1);
        }
        s.score(0);
        s.score(0);
        assertEquals(new Integer(0), s.getWinner());
    }
    
    
    @Test
    public void testIllegalScoresWin() {
        Scores s = new Scores();
        
        for (int i = 0; i < 40; i++) {
            s.score(0);
            s.score(1);
        }
        for (int i = 0; i < 3; i++) {
            s.score(0);
        }
        for (int i = 0; i < 10; i++) {
            s.score(1);
        }
        assertEquals(new Integer(0), s.getWinner());
    }
    
}
