/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PqKataTennis;

/**
 *
 * @author demonh3x
 */
public enum Player {   
    One,
    Two;

    private String name;
   
    public void setName(String name) {
        if (Player.get(name) != null){
            throw new IllegalArgumentException("A player exists with the name: " + name);
        }
        
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    /**
     * Get a player
     * @param name
     * The name of the player to get
     * @return 
     * The player with the specified name<br>
     * null if no player exists with that name
     */
    public static Player get(String name) {
        for (Player p : Player.values()) {
            if (name.equals(p.getName()))
                return p;
        }
        return null;
    }
}
