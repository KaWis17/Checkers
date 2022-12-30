package org.example.Client.Model.Rules.FigureRules.FigureMoves.Pon;

import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Rules.FigureRules.FigureMoves.FigureMove;
import org.example.Client.Model.Board.Tile;
import org.example.Client.Model.Board.TileState;
import org.example.Vector2;

public class PonAttack extends FigureMove {
    public PonAttack(Vector2[] normalizedDirections) {
        super(normalizedDirections);
    }

    @Override
    public boolean canMove(Vector2 chosenPos, Board board) {
        Vector2 pickedPos = board.getPickedPos();
        Vector2 destination = new Vector2(chosenPos.getX() - pickedPos.getX(), chosenPos.getY() - pickedPos.getY());
        Tile middleTile = board.getMiddleTile(pickedPos,chosenPos);
        return  validDestination(destination)
                && board.foundEmpty(chosenPos)
                && board.opponents(middleTile.getState(),board.getPicked().getState());
    }

    @Override
    public void move(Vector2 chosenPos, Board board) {
        Tile picked = board.getPicked();
        Vector2 pickedPos = board.getPickedPos();
        board.getTile(chosenPos).setState(picked.getState());
        board.getTile(chosenPos).setPicked(true);
        picked.setPicked(false);
        picked.setState(TileState.EMPTY);
        board.getMiddleTile(chosenPos,pickedPos).setState(TileState.EMPTY);
        board.setAllTilesNotPossible();
        setPossibleMoves(board);
        if(!hasMove(board)){
            board.getPicked().setPicked(false);
            board.negateCurrent();
            board.changePonsToQueens();
            board.setAllTilesNotPossible();
        }
    }
}
