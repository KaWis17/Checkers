package org.example.Client.Model;

public class Tile {
    private boolean isWhite;
    private boolean isPicked;
    private TileState state;

    public Tile(boolean isWhite, TileState state){
        this.isWhite=isWhite;
        this.state=state;
        isPicked=false;
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

    public boolean isPicked() {
        return isPicked;
    }

    public void setPicked(boolean picked) {
        isPicked = picked;
    }

    public String getTileCode() {
        char colorFlag = isWhite ? 'w' : 'b';
        int stateFlag=state.ordinal();
        return isPicked ? "{"+colorFlag+stateFlag+"}" : "["+colorFlag+stateFlag+"]";
    }
}
