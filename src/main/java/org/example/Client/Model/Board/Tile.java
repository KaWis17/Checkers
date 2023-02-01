package org.example.Client.Model.Board;

/**
 * class that represents tile data
 */
public class Tile {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * is tile white
     */
    private boolean isWhite;

    public void setIsWhite(boolean white) {
        isWhite = white;
    }

    public boolean getIsWhite(){
        return isWhite;
    }

    /**
     * is tile picked
     */
    private boolean isPicked;
    /**
     * is tile possible to put at
     */
    private boolean isPossible;
    /**
     * tile state
     */
    private TileState state;

    /**
     * constructor
     * @param isWhite isWhite
     * @param state state
     */
    public Tile(boolean isWhite, TileState state){
        this.isWhite=isWhite;
        this.state=state;
        isPicked=false;
        isPossible=false;
    }

    /**
     * setter for possible
     * @param isPossible is possible
     */
    public void setIsPossible(boolean isPossible){
        this.isPossible=isPossible;
    }

    /**
     * setter for state
     * @param state state
     */
    public void setState(TileState state) {
        this.state = state;
    }

    /**
     * getter for color
     * @return is white
     */
    public boolean isWhite() {
        return isWhite;
    }

    /**
     * getter for state
     * @return state
     */
    public TileState getState() {
        return state;
    }

    /**
     * getter for picked
     * @return picked
     */
    public boolean getIsPicked() {
        return isPicked;
    }

    /**
     * setter for picked
     * @param picked picked
     */
    public void setIsPicked(boolean picked) {
        isPicked = picked;
    }

    /**
     * translates tile data into code
     * @return tile code
     */
    public String getTileCode() {
        char colorFlag = isWhite ? 'w' : 'b';
        int stateFlag=state.ordinal();
        return isPicked ? "{"+colorFlag+stateFlag+"}": isPossible ? "<"+colorFlag+stateFlag+">" : "["+colorFlag+stateFlag+"]";
    }

    public boolean getIsPossible() {
        return isPossible;
    }
}
