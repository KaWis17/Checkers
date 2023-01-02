package org.example.Client.Model;

/**
 * class that contains info about player
 */
public class Player {
    /**
     * players name
     */
    String name;
    /**
     * is true if player color is white, otherwise player color is black
     */
    boolean isWhite;

    /**
     * getter for players name
     * @return name
     */
    public String getName() {
            return name;
        }

    /**
     * getter for players color
     * @return is white
     */
    public boolean isWhite() {
            return isWhite;
        }

    /**
     * setter for players name
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * setter for players color
     * @param isWhite is white?
     */
    public void setColor(boolean isWhite) {
        this.isWhite = isWhite;
    }

    /**
     * Player constructor
     * @param name name
     * @param isWhite is white?
     */
    public Player(String name, boolean isWhite) {
        this.name = name;
        this.isWhite = isWhite;
    }
}
