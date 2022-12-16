package org.example.Client.Model;

public class Tile {
    private boolean isWhite;
    private TileState state;

    Tile(boolean isWhite,TileState state){
        this.isWhite=isWhite;
        this.state=state;
    }

    public void setWhite(boolean white) {
        isWhite = white;
    }

    public void setState(TileState state) {
        this.state = state;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public TileState getState() {
        return state;
    }
}
