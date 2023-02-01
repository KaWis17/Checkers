package org.example.Client.Controller.Bot.BotMoves;

import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Board.TileState;
import org.example.Vector2;

public class BotQueen extends BotMove{

    public BotQueen(boolean pacifist){
        this.pacifist=pacifist;
    }

    boolean pacifist;

    @Override
    public Vector2 getWhereToPut(Board board) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if( (board.getPicked().getState()== TileState.QUEEN_1 || board.getPicked().getState()== TileState.QUEEN_2)
                    && (pacifist ? board.foundEmpty(new Vector2(i,j)) : board.opponents(board.getPicked().getState(),board.getTile(i,j).getState()))
                    && board.getTile(new Vector2(i,j)).getIsPossible())
                    return new Vector2(i,j);
            }
        }
        return null;
    }
}
