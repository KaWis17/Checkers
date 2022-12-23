package org.example.Client.Model.Rules;

import org.example.Client.Model.Tile;
import org.example.Client.Model.TileState;
import org.example.Vector2;

public class Board {
    private Tile[][] tiles = new Tile[8][8];

    public Board() {
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                tiles[i][j] = new Tile((i+j)%2==0, TileState.EMPTY);
                if(i<2 && !tiles[i][j].isWhite()) tiles[i][j].setState(TileState.PON_1);
                if(i>5 && !tiles[i][j].isWhite()) tiles[i][j].setState(TileState.PON_2);
            }
        }
    }

    public Tile getPicked() {
        Vector2 pickedPos = getPickedPos();
        return pickedPos == null ? null : tiles[getPickedPos().getX()][getPickedPos().getY()];
    }

    public Vector2 getPickedPos() {
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++) {
                if(tiles[i][j].isPicked()) return new Vector2(i,j);
            }
        }
        return null;
    }

    public Tile[][] getTiles()
    {
        return tiles;
    }

    public Tile getTile(int x, int y){
        return tiles[x][y];
    }

    public Tile getTile(Vector2 pos){
        return tiles[pos.getX()][pos.getY()];
    }
}
