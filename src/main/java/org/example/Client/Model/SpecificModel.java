package org.example.Client.Model;

public class SpecificModel extends AbstractModel {

  Tile[][] board = new Tile[8][8];
  String player="Anon: ";

  public SpecificModel() {
    createBoard();
  }

  private void createBoard() {
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        board[i][j] = new Tile((i+j)%2==0,TileState.EMPTY);
        if(i<2 && !board[i][j].isWhite()) board[i][j].setState(TileState.PON_1);
        if(i>5 && !board[i][j].isWhite()) board[i][j].setState(TileState.PON_2);
      }
    }
  }

  public String printBoard() {
    StringBuilder result= new StringBuilder();
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        result.append(board[i][j].getTileCode());
      }
      result.append("\n");
    }
    return result.toString();
  }

  public void pick(int x, int y) {
    if(board[x][y].getState() == TileState.EMPTY)
      return;
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        board[i][j].setPicked( (x == i && y == j) );
      }
    }
  }

  private Tile getPicked() {
    for(int i=0;i<8;i++)
    {
      for(int j=0;j<8;j++) {
        if(board[i][j].isPicked()) return board[i][j];
      }
    }
    return null;
  }

  public void put(int x, int y) {
    if(board[x][y].getState() != TileState.EMPTY)
      return;
    Tile picked = getPicked();
    board[x][y].setState(picked.getState());
    picked.setPicked(false);
    picked.setState(TileState.EMPTY);
  }

  public String getPlayer() {
        return player;
  }

  public void setPlayer(String player) {
      this.player = player;
  }
}

