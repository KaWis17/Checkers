package org.example.Client.Model.Board;

import org.example.Vector2;

/**
 * class that represents board
 */
public class Board {
    /**
     * boards tiles
     */
    protected Tile[][] tiles = new Tile[8][8];
    /**
     * info about current player color
     */
    boolean isWhiteCurrent = true;

    /**
     * Board constructor
     * @param numberOfRows number of rows of pons at beginning
     */
    public Board(int numberOfRows) {
        setInit(numberOfRows);
    }

    /**
     * inits the board for game
     * @param numberOfRows number of rows
     */
    public void setInit(int numberOfRows) {
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tiles[i][j] = new Tile((i+j)%2==0, TileState.EMPTY);
                if(i<numberOfRows && !tiles[i][j].isWhite()) tiles[i][j].setState(TileState.PON_1);
                if(i>7-numberOfRows && !tiles[i][j].isWhite()) tiles[i][j].setState(TileState.PON_2);
            }
        }
    }

    /**
     * getter for picked tile
     * @return picked tile
     */
    public Tile getPicked() {
        Vector2 pickedPos = getPickedPos();
        return pickedPos == null ? null : tiles[getPickedPos().getX()][getPickedPos().getY()];
    }

    /**
     * returns position of picked tile if it exits
     * @return picked tile position
     */
    public Vector2 getPickedPos() {
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++) {
                if(tiles[i][j].isPicked()) return new Vector2(i,j);
            }
        }
        return null;
    }

    /**
     * getter for tiles
     * @return tiles
     */
    public Tile[][] getTiles()
    {
        return tiles;
    }

    /**
     * getter for specific tile
     * @param x x
     * @param y y
     * @return tile
     */
    public Tile getTile(int x, int y){
        return tiles[x][y];
    }

    /**
     * getter for specific tile
     * @param pos vector2 position
     * @return tile
     */
    public Tile getTile(Vector2 pos){
        return tiles[pos.getX()][pos.getY()];
    }

    /**
     * checks if two titles contain pon of same team
     * @param pos1 position 1
     * @param pos2 position 2
     * @return answer
     */
    public boolean sameTeam(Vector2 pos1, Vector2 pos2) {
        return getTile(pos2).getState() != TileState.EMPTY &&
                getTile(pos1).getState().ordinal() % 2 == getTile(pos2).getState().ordinal() % 2;
    }

    /**
     * checks if line between two positions is empty
     * @param startPos starting position
     * @param endPos ending position
     * @param step one step
     * @return answer
     */
    public boolean emptyLineBetween(Vector2 startPos, Vector2 endPos, Vector2 step) {
        Vector2 stepDimensions = step.normalized();
        Vector2 current = new Vector2(startPos.getX(), startPos.getY());
        current.add(stepDimensions);
        while(current.getX()!=endPos.getX() || current.getY()!=endPos.getY())
        {
            if(getTile(current.getX(), current.getY()).getState() != TileState.EMPTY)
                return false;
            current.add(stepDimensions);
        }
        return (current.getX()==endPos.getX() && current.getY()==endPos.getY()) ||
                opponents(getTile(current).getState(),getPicked().getState());
    }

    /**
     * checks if position is empty
     * @param pos position
     * @return answer
     */
    public boolean foundEmpty(Vector2 pos) {
        return getTile(pos).getState() == TileState.EMPTY;
    }

    //TODO: delete this or sameTeam()

    /**
     * checks if two titles contain enemy pons
     * @param tile1 tile 1
     * @param tile2 tile 2
     * @return answer
     */
    public boolean opponents(TileState tile1, TileState tile2){
        if (tile1 == TileState.EMPTY || tile2 == TileState.EMPTY)
            return false;
        return  (tile1 == TileState.PON_1 || tile1 == TileState.QUEEN_1) ?
                (tile2 == TileState.PON_2 || tile2 == TileState.QUEEN_2) :
                (tile2 == TileState.PON_1 || tile2 == TileState.QUEEN_1);
    }

    //TODO: refactor to the vector
    /**
     * returns true if on cords (x,y) lays my pon
     * @param vector vector
     * @return answer
     */
    public boolean isMine(Vector2 vector){
        Tile tile = getTile(vector.getX(), vector.getY());
        return tile.getState() == TileState.EMPTY ||  ((tile.getState().ordinal() % 2 == 1) == isWhiteCurrent);
    }

    /**
     * returns tile between two given tiles
     * @param pos1 pos1
     * @param pos2 pos2
     * @return answer
     */
    public Tile getMiddleTile(Vector2 pos1, Vector2 pos2){
        return getTile(new Vector2((pos1.getX()+ pos2.getX())/2, (pos1.getY()+ pos2.getY())/2));
    }

    /**
     * checks if given vector represents position inside board
     * @param vector vector
     * @return answer
     */
    public boolean isPositionInBoard(Vector2 vector){
        return vector.getX()>=0 && vector.getY()>=0 && vector.getX()<=7 && vector.getY()<=7;
    }

    /**
     * changes pon to queen as it goes to the end of board
     */
    public void changePonToQueen() {
        for(int j=0;j<8;j++){
            if (getTile(7,j).getState() == TileState.PON_1)
                getTile(7,j).setState(TileState.QUEEN_1);
            if (getTile(0,j).getState() == TileState.PON_2)
                getTile(0,j).setState(TileState.QUEEN_2);
        }
    }

    /**
     * sets all tiles not possible
     */
    public void setAllTilesNotPossible() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tiles[i][j].setPossible(false);
            }
        }
    }

    /**
     * translates board data to String
     * @return board ass code
     */
    public String printBoard() {
        StringBuilder result= new StringBuilder();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                result.append(tiles[i][j].getTileCode());
            }
            result.append("\n");
        }
        return result.toString();
    }

    /**
     * getter for current player color
     * @return is white current?
     */
    public boolean isWhiteCurrent() {
        return isWhiteCurrent;
    }

    /**
     * negates current player color
     */
    public void negateCurrent(){
        isWhiteCurrent=!isWhiteCurrent;
    }

    /**
     *
     * @return -1 when white lost, 1 when black, 0 when nobody
     */
    public int getWinner()
    {
        boolean blackLost=true;
        boolean whiteLost=true;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++) {
                if(tiles[i][j].getState().ordinal()%2==0 && tiles[i][j].getState().ordinal()!=0) blackLost=false;
                if(tiles[i][j].getState().ordinal()%2==1) whiteLost=false;
            }
        }
        return whiteLost? -1 : (blackLost ? 1 : 0);
    }
}
