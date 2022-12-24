package org.example.Client.Model.Board;

import org.example.Client.Model.Tile;
import org.example.Client.Model.TileState;

public class ThreeRowsBoard extends Board{
    public ThreeRowsBoard() {
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tiles[i][j] = new Tile((i+j)%2==0, TileState.EMPTY);
                if(i<3 && !tiles[i][j].isWhite()) tiles[i][j].setState(TileState.PON_1);
                if(i>4 && !tiles[i][j].isWhite()) tiles[i][j].setState(TileState.PON_2);
            }
        }
    }
}
