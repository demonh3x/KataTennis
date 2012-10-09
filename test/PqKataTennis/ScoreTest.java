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
public class ScoreTest {
    
    public ScoreTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Test
    public void testToMax() {
        Score instance = new Score();
        
        assertEquals(0, instance.getValue());
        assertEquals(false, instance.isMax());
        
        instance.increment();
        assertEquals(15, instance.getValue());
        assertEquals(false, instance.isMax());
        
        instance.increment();
        assertEquals(30, instance.getValue());
        assertEquals(false, instance.isMax());
        
        instance.increment();
        assertEquals(40, instance.getValue());
        assertEquals(true, instance.isMax());
        
        instance.increment();
        assertEquals(40, instance.getValue());
        assertEquals(true, instance.isMax());
    }

}
