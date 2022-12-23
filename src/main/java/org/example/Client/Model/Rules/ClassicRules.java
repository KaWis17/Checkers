package org.example.Client.Model.Rules;

import org.example.Client.Model.Tile;
import org.example.Client.Model.TileState;
import org.example.Vector2;

public class ClassicRules implements Rules {
    private boolean canMovePon(Vector2 pickedPos, Vector2 chosenPos, Board board){
        return areOnShortDiagonal(pickedPos,chosenPos) &&
                foundEmpty(chosenPos, board) && canMovePonFurther(pickedPos,chosenPos,board);
    }

    private boolean canMovePonFurther(Vector2 pickedPos, Vector2 chosenPos, Board board) {
        return  (chosenPos.getX() - pickedPos.getX() > 0 && board.getTile(pickedPos).getState() == TileState.PON_1 ) ||
                (chosenPos.getX() - pickedPos.getX() < 0 && board.getTile(pickedPos).getState() == TileState.PON_2 );
    }

    // TE METODE W SWOIM CZASIE NADPISAC
    private boolean canMoveQueen(Vector2 pickedPos, Vector2 chosenPos, Board board) {
        return board.getTile(pickedPos).getState().ordinal()>2 &&
                emptyLineBetween(pickedPos,chosenPos,board) &&
                !sameTeam(pickedPos,chosenPos,board);
    }

    private boolean sameTeam(Vector2 pickedPos, Vector2 chosenPos, Board board) {
        if(board.getTile(chosenPos).getState()==TileState.EMPTY) return false;
        return board.getTile(pickedPos).getState().ordinal() % 2 == board.getTile(chosenPos).getState().ordinal() % 2;
    }

    private boolean emptyLineBetween(Vector2 pickedPos, Vector2 chosenPos, Board board) {
        return (emptyHorizontalLine(pickedPos,chosenPos,board)) || (emptyVerticalLine(pickedPos,chosenPos,board));
    }

    private boolean emptyHorizontalLine(Vector2 pickedPos, Vector2 chosenPos, Board board) {
        if(pickedPos.getY() != chosenPos.getY()) return false;
            for(int i=Math.min(pickedPos.getX(),chosenPos.getX())+1; i<Math.max(pickedPos.getX(), chosenPos.getX()); i++){
                if(board.getTile(i, pickedPos.getY()).getState()!=TileState.EMPTY) return false;
            }
        return true;
    }

    private boolean emptyVerticalLine(Vector2 pickedPos, Vector2 chosenPos, Board board) {
        if(pickedPos.getX() != chosenPos.getX()) return false;
            for(int i=Math.min(pickedPos.getY(),chosenPos.getY())+1; i<Math.max(pickedPos.getY(), chosenPos.getY()); i++){
                if(board.getTile(pickedPos.getX(),i).getState()!=TileState.EMPTY) return false;
        }
        return true;
    }

    private boolean foundEmpty(Vector2 chosenPos, Board board) {
        return board.getTile(chosenPos).getState() == TileState.EMPTY;
    }

    private boolean areOnShortDiagonal(Vector2 pos1, Vector2 pos2){
        return manhattanDistance(pos1,pos2) == 2 && inDiagonal(pos1,pos2);
    }

    public boolean shortTaking(Vector2 picked, Vector2 chosen, Board board){
        Tile middleTile = getMiddleTile(picked,chosen,board);
        return manhattanDistance(picked,chosen) == 4 && inDiagonal(picked,chosen) &&
                opponents(middleTile.getState(),board.getTile(picked).getState());

    }

    private boolean opponents(TileState tile1, TileState tile2){
        if (tile1 == TileState.EMPTY || tile2 == TileState.EMPTY)
            return false;
        return  (tile1 == TileState.PON_1 || tile1 == TileState.QUEEN_1) ?
                (tile2 == TileState.PON_2 || tile2 == TileState.QUEEN_2) :
                (tile2 == TileState.PON_1 || tile2 == TileState.QUEEN_1);
    }

    private int manhattanDistance(Vector2 pos1,Vector2 pos2){
        return Math.abs(pos1.getX()- pos2.getX()) + Math.abs(pos1.getY()- pos2.getY());
    }

    private boolean inStraightLine(Vector2 pos1, Vector2 pos2){
        return pos1.getX() == pos2.getX() || pos2.getY() == pos1.getY();
    }

    private boolean inDiagonal(Vector2 pos1, Vector2 pos2){
        return Math.abs(pos1.getX()- pos2.getX()) == Math.abs(pos1.getY()- pos2.getY());
    }

    private Tile getMiddleTile(Vector2 pos1, Vector2 pos2, Board board){
        //zabezpieczyc
        return board.getTile(new Vector2((pos1.getX()+ pos2.getX())/2, (pos1.getY()+ pos2.getY())/2));
    }

    private void moveFigure(Vector2 chosenPos, Board board, Tile picked) {
        board.getTile(chosenPos).setState(picked.getState());
        changePonsToQueens(board);
        picked.setPicked(false);
        picked.setState(TileState.EMPTY);
    }

    private void changePonsToQueens(Board board) {
        for(int j=0;j<8;j++){
            if (board.getTile(7,j).getState() == TileState.PON_1)
                board.getTile(7,j).setState(TileState.QUEEN_1);
            if (board.getTile(0,j).getState() == TileState.PON_2)
                board.getTile(0,j).setState(TileState.QUEEN_2);
        }
    }

    @Override
    public void pick(Vector2 chosen, Board board) {
        if(board.getTiles()[chosen.getX()][chosen.getY()].getState() == TileState.EMPTY)
            return;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                board.getTiles()[i][j].setPicked( (chosen.getX() == i && chosen.getY() == j) );
            }
        }
    }

    @Override
    public void put(Vector2 chosenPos, Board board) {
        Tile picked = board.getPicked();
        Vector2 pickedPos = board.getPickedPos();
        if(canMovePon(pickedPos, chosenPos, board)){
            moveFigure(chosenPos, board, picked);
        }
        else if (shortTaking(pickedPos,chosenPos,board)){
            moveFigure(chosenPos, board, picked);
            getMiddleTile(chosenPos,pickedPos,board).setState(TileState.EMPTY);
        }
        else if (canMoveQueen(pickedPos,chosenPos,board)) {
            moveFigure(chosenPos, board, picked);
        }
        else {
            board.getPicked().setPicked(false);
        }
    }
}
