package org.example.Client.Model.Rules.FigureRules.FigureMoves;
import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Tile;
import org.example.Client.Model.TileState;
import org.example.Vector2;

public abstract class FigureMove {
    public boolean canMove(Vector2 chosenPos, Board board){
     return false;
    }

    public void move(Vector2 chosenPos, Board board){
        Tile picked = board.getPicked();
        board.getTile(chosenPos).setState(picked.getState());
        //changePonsToQueens(board);
        picked.setPicked(false);
        picked.setState(TileState.EMPTY);
    }
}
