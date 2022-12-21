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

  public void pick(int x, int y)
  {
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        board[i][j].setPicked( (x == i && y == j) );
      }
    }
  }

  public String getPlayer() {
        return player;
  }

  public void setPlayer(String player) {
      this.player = player;
  }
}

