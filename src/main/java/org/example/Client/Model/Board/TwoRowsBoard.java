package org.example.Client.Model.Board;

import org.example.Client.Model.Tile;
import org.example.Client.Model.TileState;

public class TwoRowsBoard extends Board{
    public TwoRowsBoard() {
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tiles[i][j] = new Tile((i+j)%2==0, TileState.EMPTY);
                if(i<2 && !tiles[i][j].isWhite()) tiles[i][j].setState(TileState.PON_1);
                if(i>5 && !tiles[i][j].isWhite()) tiles[i][j].setState(TileState.PON_2);
            }
        }
    }
}
