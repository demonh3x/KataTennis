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
            assertEquals(true, s.score(1));
        }
        assertEquals(new Integer(1), s.getWinner());
        assertEquals(false, s.score(0));
        assertEquals(false, s.score(1));
    }
    
    @Test
    public void testDeuce() {
        Scores s = new Scores();
        
        for (int i = 0; i < 3; i++) {
            assertEquals(null, s.getAdvantage());
            assertEquals(true, s.score(0));
            assertEquals(null, s.getAdvantage());
            assertEquals(true, s.score(1));
        }
        assertEquals(new Integer(-1), s.getAdvantage());
    }
    
    @Test
    public void testAdvantages() {
        Scores s = new Scores();
        
        for (int i = 0; i < 3; i++) {
            s.score(0);
            s.score(1);
        }
        assertEquals(true, s.score(0));
        assertEquals(new Integer(0), s.getAdvantage());
        assertEquals(true, s.score(1));
        assertEquals(new Integer(-1), s.getAdvantage());
        assertEquals(true, s.score(1));
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
        assertEquals(true, s.score(0));
        assertEquals(false, s.score(0));
        assertEquals(false, s.score(1));
        assertEquals(new Integer(0), s.getWinner());
    }
    
}
