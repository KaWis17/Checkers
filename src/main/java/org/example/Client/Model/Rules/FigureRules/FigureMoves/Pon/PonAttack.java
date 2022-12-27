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
        Tile middleTile = board.getMiddleTile(pickedPos,chosenPos);
        return  pickedPos.manhattanDistance(chosenPos) == 4 && pickedPos.inDiagonal(chosenPos) &&
                board.opponents(middleTile.getState(),board.getPicked().getState()) &&
                board.foundEmpty(chosenPos);
    }

    //TODO: REFACTOR
    boolean hasMove(Board board){
        System.out.println("TUTAJ");
        for(int i=0;i<normalizedDirections.length;i++){
            Vector2 candidate=new Vector2(normalizedDirections[i].getX(),normalizedDirections[i].getY());
            candidate.add(board.getPickedPos());
            System.out.println(candidate.getX()+" "+candidate.getY());
            if( candidate.getX()>=0 && candidate.getY()>=0 &&
                    candidate.getX()<=7 && candidate.getY()<=7 &&
                    canMove(candidate,board)) return true;
        }
        return false;
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
        if(!hasMove(board)){
            board.getPicked().setPicked(false);
            board.negateCurrent();
            board.changePonsToQueens();
        }
    }
}
