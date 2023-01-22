package org.example.Client.Controller.Bot.BotMoves;

import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Board.TileState;
import org.example.Vector2;

public class BotPon extends BotMove{

    public BotPon(int length){
     this.length=length;
    }

    private final int length;

    @Override
    public Vector2 getWhereToPut(Board board) {
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if( (board.getPicked().getState()== TileState.PON_1 || board.getPicked().getState()== TileState.PON_2)
                    && board.getPickedPos().manhattanDistance(new Vector2(i,j))==length
                    && board.getTile(new Vector2(i,j)).isPossible())
                    return new Vector2(i,j);
            }
        }
        return null;
    }
}
