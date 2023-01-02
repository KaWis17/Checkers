package org.example.Client.Model.Board;

import org.example.Vector2;

public class Board {
    protected Tile[][] tiles = new Tile[8][8];

    boolean isWhiteCurrent = true;

    public boolean isWhiteCurrent() {
        return isWhiteCurrent;
    }

    public void negateCurrent(){
        isWhiteCurrent=!isWhiteCurrent;
    }

    public Board(int numberOfRows) {
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tiles[i][j] = new Tile((i+j)%2==0, TileState.EMPTY);
                if(i<numberOfRows && !tiles[i][j].isWhite()) tiles[i][j].setState(TileState.PON_1);
                if(i>7-numberOfRows && !tiles[i][j].isWhite()) tiles[i][j].setState(TileState.PON_2);
            }
        }
    }

    public Tile getPicked() {
        Vector2 pickedPos = getPickedPos();
        return pickedPos == null ? null : tiles[getPickedPos().getX()][getPickedPos().getY()];
    }

    public Vector2 getPickedPos() {
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++) {
                if(tiles[i][j].isPicked()) return new Vector2(i,j);
            }
        }
        return null;
    }

    public Tile[][] getTiles()
    {
        return tiles;
    }

    public Tile getTile(int x, int y){
        return tiles[x][y];
    }

    public Tile getTile(Vector2 pos){
        return tiles[pos.getX()][pos.getY()];
    }

    public boolean sameTeam(Vector2 pickedPos, Vector2 chosenPos) {
        return getTile(chosenPos).getState() != TileState.EMPTY &&
                getTile(pickedPos).getState().ordinal() % 2 == getTile(chosenPos).getState().ordinal() % 2;
    }

    public boolean emptyLineBetween(Vector2 pickedPos, Vector2 chosenPos, Vector2 step) {
        Vector2 stepDimensions = step.normalized();
        Vector2 current = new Vector2(pickedPos.getX(), pickedPos.getY());
        current.add(stepDimensions);
        while(current.getX()!=chosenPos.getX() || current.getY()!=chosenPos.getY())
        {
            if(getTile(current.getX(), current.getY()).getState() != TileState.EMPTY)
                return false;
            current.add(stepDimensions);
        }
        return (current.getX()==chosenPos.getX() && current.getY()==chosenPos.getY()) ||
                opponents(getTile(current).getState(),getPicked().getState());
    }

    public boolean foundEmpty(Vector2 chosenPos) {
        return getTile(chosenPos).getState() == TileState.EMPTY;
    }

    public boolean opponents(TileState tile1, TileState tile2){
        if (tile1 == TileState.EMPTY || tile2 == TileState.EMPTY)
            return false;
        return  (tile1 == TileState.PON_1 || tile1 == TileState.QUEEN_1) ?
                (tile2 == TileState.PON_2 || tile2 == TileState.QUEEN_2) :
                (tile2 == TileState.PON_1 || tile2 == TileState.QUEEN_1);
    }

    public boolean isMine(int x, int y){
        Tile tile = getTile(x,y);
        return tile.getState() == TileState.EMPTY ||  ((tile.getState().ordinal() % 2 == 1) == isWhiteCurrent);
    }

    public Tile getMiddleTile(Vector2 pos1, Vector2 pos2){
        return getTile(new Vector2((pos1.getX()+ pos2.getX())/2, (pos1.getY()+ pos2.getY())/2));
    }

    public boolean isPositionInBoard(Vector2 vector){
        return vector.getX()>=0 && vector.getY()>=0 && vector.getX()<=7 && vector.getY()<=7;
    }

    public void changePonsToQueens() {
        for(int j=0;j<8;j++){
            if (getTile(7,j).getState() == TileState.PON_1)
                getTile(7,j).setState(TileState.QUEEN_1);
            if (getTile(0,j).getState() == TileState.PON_2)
                getTile(0,j).setState(TileState.QUEEN_2);
        }
    }

    public void setAllTilesNotPossible() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                tiles[i][j].setPossible(false);
            }
        }
    }

    public String printBoard() {
        StringBuilder result= new StringBuilder();
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                result.append(getTiles()[i][j].getTileCode());
            }
            result.append("\n");
        }
        return result.toString();
    }
}
