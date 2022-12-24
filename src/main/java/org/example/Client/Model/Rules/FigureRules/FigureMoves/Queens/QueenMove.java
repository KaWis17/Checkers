package org.example.Client.Model.Rules.FigureRules.FigureMoves.Queens;

import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.FigureMove;
import org.example.Vector2;

public class QueenMove extends FigureMove {
    @Override
    public boolean canMove(Vector2 chosenPos, Board board) {
        Vector2 pickedPos =board.getPickedPos();
        return board.getTile(pickedPos).getState().ordinal()>2 &&
                board.emptyLineBetween(pickedPos,chosenPos) &&
                !board.sameTeam(pickedPos,chosenPos);
    }
}
