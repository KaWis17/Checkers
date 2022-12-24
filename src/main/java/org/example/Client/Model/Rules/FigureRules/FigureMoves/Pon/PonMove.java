package org.example.Client.Model.Rules.FigureRules.FigureMoves.Pon;

import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.FigureMove;
import org.example.Client.Model.Tile;
import org.example.Client.Model.TileState;
import org.example.Vector2;

public class PonMove extends FigureMove {
    @Override
    public boolean canMove(Vector2 chosenPos, Board board) {
        return board.getPickedPos().areOnShortDiagonal(chosenPos) &&
                board.foundEmpty(chosenPos) && canMovePonFurther(chosenPos,board);
    }

    @Override
    public void move(Vector2 chosenPos, Board board) {
        Tile picked = board.getPicked();
        board.getTile(chosenPos).setState(picked.getState());
        board.changePonsToQueens();
        picked.setPicked(false);
        picked.setState(TileState.EMPTY);
    }

    private boolean canMovePonFurther(Vector2 chosenPos, Board board) {
        Vector2 pickedPos = board.getPickedPos();
        Tile picked=board.getPicked();
        return  (chosenPos.getX() - pickedPos.getX() > 0 && picked.getState() == TileState.PON_1 ) ||
                (chosenPos.getX() - pickedPos.getX() < 0 && picked.getState() == TileState.PON_2 );
    }
}
