package org.example.Client.Model.Rules.FigureRules;

import java.util.List;
import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.FigureMove;
import org.example.Vector2;

/**
 * class that represent figure type
 */
public class Figure{
    /**
     * movement that figure can perform
     */
    private final List<FigureMove> moves;

    /**
     * constructor
     * @param moves moves
     */
    public Figure(List<FigureMove> moves) {
        this.moves=moves;
    }

    /**
     * figure movement
     * @param chosenPos chosen position
     * @param board board
     */
    public void move(Vector2 chosenPos, Board board) {
        for (FigureMove move : moves){
            if (move.canMove(chosenPos,board))
            {
                move.move(chosenPos,board);
                return;
            }
        }
        board.getPicked().setPicked(false);
        board.setAllTilesNotPossible();
    }

    /**
     * setts possible moves on board
     * @param board board
     */
    public void setPossibleMoves(Board board){
        for (FigureMove move : moves){
            move.setPossibleMoves(board);
        }
    }
}
