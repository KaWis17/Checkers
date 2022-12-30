package org.example.Client.Model.Board;

public class Tile {
    private boolean isWhite;
    private boolean isPicked;
    private boolean isPossible;
    private TileState state;

    public Tile(boolean isWhite, TileState state){
        this.isWhite=isWhite;
        this.state=state;
        isPicked=false;
        isPossible=false;
    }

    public void setPossible(boolean isPossible){
        this.isPossible=isPossible;
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

    public boolean isPossible() {
    return isPossible;
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
        return isPicked ? "{"+colorFlag+stateFlag+"}": isPossible ? "<"+colorFlag+stateFlag+">" : "["+colorFlag+stateFlag+"]";
    }
}
