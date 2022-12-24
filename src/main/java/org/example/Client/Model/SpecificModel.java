package org.example.Client.Model;

import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Board.ThreeRowsBoard;
import org.example.Client.Model.Rules.ClassicRules;
import org.example.Client.Model.Rules.Rules;
import org.example.Vector2;

public class SpecificModel extends AbstractModel {
  Rules rules;
  Board board;
  String player="Anon: ";

  public SpecificModel() {
    board = new ThreeRowsBoard();
    rules = new ClassicRules();
  }

  public String printBoard() {
    StringBuilder result= new StringBuilder();
    for(int i = 0; i < 8; i++){
      for(int j = 0; j < 8; j++){
        result.append(board.getTiles()[i][j].getTileCode());
      }
      result.append("\n");
    }
    return result.toString();
  }

  public void pick(int x, int y) {
    rules.pick(new Vector2(x,y),board);
  }

  public void put(int x, int y) {
    rules.put(new Vector2(x,y),board);
  }

  public String getPlayer() {
        return player;
  }

  public void setPlayer(String player) {
      this.player = player;
  }

  public Board getBoard(){
    return board;
  }
}

