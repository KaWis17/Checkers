package org.example.Client.Model.Board;

import org.example.Client.Model.Tile;
import org.example.Client.Model.TileState;

public class nRowsBoard extends Board{
    public nRowsBoard(int numberOfRows) {
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tiles[i][j] = new Tile((i+j)%2==0, TileState.EMPTY);
                if(i<numberOfRows && !tiles[i][j].isWhite()) tiles[i][j].setState(TileState.QUEEN_1);
                if(i>7-numberOfRows && !tiles[i][j].isWhite()) tiles[i][j].setState(TileState.PON_2);
            }
        }
    }
}
