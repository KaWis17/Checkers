package org.example.Client.Model;

public class Player {
    String name;
    boolean isWhite;

    public String getName() {
        return name;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setColor(boolean white) {
        isWhite = white;
    }

    public Player(String name, boolean isWhite) {
        this.name = name;
        this.isWhite = isWhite;
    }
}
