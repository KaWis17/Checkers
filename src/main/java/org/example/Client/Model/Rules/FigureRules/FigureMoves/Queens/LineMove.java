package org.example.Client.Model.Rules.FigureRules.FigureMoves.Queens;

import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.FigureMove;
import org.example.Vector2;

/**
 * class representing linear movement
 */
public class LineMove extends FigureMove {

    /**
     * constructor
     * @param directions directions
     */
    public LineMove(Vector2[] directions){
        super(directions);
    }

    /**
     * checks if figure can move
     * @param chosenPos chosen position
     * @param board board
     * @return answer
     */
    @Override
    public boolean canMove(Vector2 chosenPos, Board board) {
        Vector2 pickedPos = board.getPickedPos();
        Vector2 direction = new Vector2(chosenPos.getX() - pickedPos.getX(), chosenPos.getY() - pickedPos.getY());
        return  validDirection(direction.normalized()) &&
                board.emptyLineBetween(pickedPos,chosenPos,direction) &&
                !board.sameTeam(pickedPos,chosenPos);
    }

    /**
     * checks if on board is position where pon can move
     * @param board board
     * @return
     */
    @Override
    protected boolean hasMove(Board board) {
        for(int i = 0; i < 8; i++){
            for (int j = 0; j < 8 ; j++) {
                if(canMove(new Vector2(i,j),board)) return true;
            }
        }
        return false;
    }
}
