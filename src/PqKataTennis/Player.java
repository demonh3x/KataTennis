/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PqKataTennis;

/**
 *
 * @author demonh3x
 */
public class Player {
    private String name;
    private Score score = new Score();

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Score getScore() {
        return score;
    }
}
