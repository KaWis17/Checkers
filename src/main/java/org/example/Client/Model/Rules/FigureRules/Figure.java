package org.example.Client.Model.Rules.FigureRules;

import java.util.List;
import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.FigureMove;
import org.example.Vector2;

public class Figure{
    private final List<FigureMove> moves;

    public Figure(List<FigureMove> moves) {
        this.moves=moves;
    }

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

    public void setPossibleMoves(Board board){
        for (FigureMove move : moves){
            move.setPossibleMoves(board);
        }
    }
}
