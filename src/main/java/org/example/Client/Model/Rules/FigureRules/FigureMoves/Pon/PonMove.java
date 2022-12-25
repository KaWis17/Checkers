package org.example.Client.Model.Rules.FigureRules.FigureMoves.Pon;

import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.FigureMove;
import org.example.Client.Model.Tile;
import org.example.Client.Model.TileState;
import org.example.Vector2;

public class PonMove extends FigureMove {

    @Override
    public boolean canMove(Vector2 chosenPos, Board board){
        Vector2 pickedPos = board.getPickedPos();
        Vector2 destination = new Vector2(chosenPos.getX() - pickedPos.getX(), chosenPos.getY() - pickedPos.getY());
        return  validDestination(destination) && board.foundEmpty(chosenPos);
    }

    public PonMove(Vector2[] normalizedDirections) {
        super(normalizedDirections);
    }

    @Override
    public void move(Vector2 chosenPos, Board board) {
        super.move(chosenPos,board);
        board.changePonsToQueens();
    }
}
