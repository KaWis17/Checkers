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
        char c = board[i][j].isWhite() ? 'w' : 'b';
        result.append(c);
      }
      result.append("\n");
    }
    return result.toString();
  }

  public String getPlayer() {
        return player;
  }

  public void setPlayer(String player) {
      this.player = player;
  }
}

