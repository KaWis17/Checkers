package org.example.Client.Model.Rules.FigureRules.FigureMoves;

import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Board.Tile;
import org.example.Client.Model.Board.TileState;
import org.example.Vector2;

/**
 * class representing figure movements
 */
public abstract class FigureMove {
    /**
     * possible movement directions
     */
    protected Vector2[] directions;

    /**
     * constructor
     * @param directions directions
     */
    protected FigureMove(Vector2[] directions) {
        this.directions = directions;
    }

    /**
     * checks if figure can move there
     * @param chosenPos chosen pos
     * @param board board
     * @return answer
     */
    public abstract boolean canMove(Vector2 chosenPos, Board board);

    /**
     * moves figure into given direction
     * @param chosenPos chosen position
     * @param board board
     */
    public void move(Vector2 chosenPos, Board board){
        Tile picked = board.getPicked();
        board.getTile(chosenPos).setState(picked.getState());
        picked.setPicked(false);
        picked.setState(TileState.EMPTY);
        board.setAllTilesNotPossible();
        board.negateCurrent();
    }

    /**
     * checks if normalized given direction is on direction list
     * @param direction direction
     * @return answer
     */
    protected boolean validDirection(Vector2 direction){
        return validDestination(direction.normalized());
    }

    /**
     * checks if given destination is on direction list
     * @param destination destination
     * @return answer
     */
    protected boolean validDestination(Vector2 destination){
        for (Vector2 direction : directions) {
            if (direction.isEqual(destination)) return true;
        }
        return false;
    }

    /**
     * checks if figure can move anywhere
     * @param board board
     * @return answer
     */
    protected boolean hasMove(Board board){
        for (Vector2 direction : directions) {
            Vector2 candidate = new Vector2(direction.getX(), direction.getY());
            candidate.add(board.getPickedPos());
            if (board.isPositionInBoard(candidate) && canMove(candidate, board)) return true;
        }
        return false;
    }

    /**
     * sets possible moves on board
     * @param board board
     */
    public void setPossibleMoves(Board board) {
        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 8 ; j++) {
                if(canMove(new Vector2(i,j),board)) board.getTile(new Vector2(i,j)).setPossible(true);
            }
        }
    }
}
