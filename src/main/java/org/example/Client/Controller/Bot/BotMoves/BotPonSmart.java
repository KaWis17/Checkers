package org.example.Client.Controller.Bot.BotMoves;

import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Board.TileState;
import org.example.Vector2;

public class BotPonSmart extends BotMove{

@Override
public Vector2 getWhereToPut(Board board) {
    for(int i=0;i<8;i++){
        for(int j=0;j<8;j++){
            if(( board.getPicked().getState()== TileState.PON_1 || board.getPicked().getState()== TileState.PON_2)
                &&board.getPickedPos().manhattanDistance(new Vector2(i,j))==4
                && !(board.opponents(board.getPicked().getState(),board.getTile(i,j).getState()))
                && board.foundEmpty(new Vector2((board.getPickedPos().getX()+i)/2,(board.getPickedPos().getY()+j)/2))
                && board.getTile(new Vector2((board.getPickedPos().getX()+i)/2,(board.getPickedPos().getY()+j)/2)).getIsPossible())
                    return new Vector2((board.getPickedPos().getX()+i)/2,(board.getPickedPos().getY()+j)/2);
        }
    }
    return null;
}
}