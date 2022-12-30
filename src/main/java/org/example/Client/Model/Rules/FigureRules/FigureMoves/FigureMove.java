package org.example.Client.Model.Rules.FigureRules.FigureMoves;
import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Board.Tile;
import org.example.Client.Model.Board.TileState;
import org.example.Vector2;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public abstract class FigureMove {
    protected Vector2[] directions;

    protected FigureMove(Vector2[] directions) {
        this.directions = directions;
    }

    public FigureMove(Vector2 direction){
        this.directions = new Vector2[]{direction};
    }

    public abstract boolean canMove(Vector2 chosenPos, Board board);

    public void move(Vector2 chosenPos, Board board){
        Tile picked = board.getPicked();
        board.getTile(chosenPos).setState(picked.getState());
        picked.setPicked(false);
        picked.setState(TileState.EMPTY);
        board.setAllTilesNotPossible();
        board.negateCurrent();
    }

    protected boolean validDirection(Vector2 direction){
        return validDestination(direction.normalized());
    }

    protected boolean validDestination(Vector2 destination){
        for(int i = 0; i< directions.length; i++){
            if(directions[i].isEqual(destination)) return true;
        }
        return false;
    }

    protected boolean hasMove(Board board){
        for(int i = 0; i< directions.length; i++){
            Vector2 candidate=new Vector2(directions[i].getX(), directions[i].getY());
            candidate.add(board.getPickedPos());
            if(board.isPositionInBoard(candidate) && canMove(candidate,board)) return true;
        }
        return false;
    }

    public void setPossibleMoves(Board board) {
        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 8 ; j++) {
                if(canMove(new Vector2(i,j),board)) board.getTile(new Vector2(i,j)).setPossible(true);
            }
        }
    }
}
