package org.example.Client.Model.Rules.FigureRules.FigureMoves.Pon;

import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.FigureMove;
import org.example.Client.Model.Tile;
import org.example.Client.Model.TileState;
import org.example.Vector2;

public class PonAttack extends FigureMove {
    public PonAttack(Vector2[] normalizedDirections) {
        super(normalizedDirections);
    }

    @Override
    public boolean canMove(Vector2 chosenPos, Board board) {
        Vector2 pickedPos = board.getPickedPos();
        Tile middleTile = board.getMiddleTile(pickedPos,chosenPos);
        return pickedPos.manhattanDistance(chosenPos) == 4 && pickedPos.inDiagonal(chosenPos) &&
                board.opponents(middleTile.getState(),board.getPicked().getState()) &&
                board.foundEmpty(chosenPos);
    }

    @Override
    public void move(Vector2 chosenPos, Board board) {
        Tile picked = board.getPicked();
        Vector2 pickedPos = board.getPickedPos();
        board.getTile(chosenPos).setState(picked.getState());
        picked.setPicked(false);
        picked.setState(TileState.EMPTY);
        board.getMiddleTile(chosenPos,pickedPos).setState(TileState.EMPTY);
        board.changePonsToQueens();
    }
}
