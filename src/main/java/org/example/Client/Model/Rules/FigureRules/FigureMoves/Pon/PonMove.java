package org.example.Client.Model.Rules.FigureRules.FigureMoves.Pon;

import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.FigureMove;
import org.example.Vector2;
/**
 * class that represents pon movement that does not attack
 */
public class PonMove extends FigureMove {
    /**
     * checks if pon can move
     * @param chosenPos chosen position
     * @param board board
     * @return answer
     */
    @Override
    public boolean canMove(Vector2 chosenPos, Board board){
        Vector2 pickedPos = board.getPickedPos();
        Vector2 destination = new Vector2(chosenPos.getX() - pickedPos.getX(), chosenPos.getY() - pickedPos.getY());
        return  validDestination(destination) && board.foundEmpty(chosenPos);
    }

    /**
     * constructor
     * @param directions directions
     */
    public PonMove(Vector2[] directions) {
        super(directions);
    }

    /**
     * executes pons movement
     * @param chosenPos chosen position
     * @param board board
     */
    @Override
    public void move(Vector2 chosenPos, Board board) {
        super.move(chosenPos,board);
        board.changePonToQueen();
    }
}
