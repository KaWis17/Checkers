package org.example.Client.Model;

import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Rules.ClassicRules;
import org.example.Client.Model.Rules.Rules;
import org.example.Vector2;

public class SpecificModel extends AbstractModel {
  Rules rules;
  Board board;
  Player player;

  public SpecificModel() {
    board = new Board(3);
    rules = new ClassicRules();
    player = new Player("Anon",false);
  }

  public void pick(int x, int y) {
    rules.pick(new Vector2(x,y),board);
  }

  public void put(int x, int y) {
    rules.put(new Vector2(x,y),board);
  }

  public String getPlayerName() {
        return player.getName();
  }

  public void setPlayerName(String playerName) {
      player.setName(playerName);
  }

  public Board getBoard(){
    return board;
  }

  public void setPlayerColor(boolean isWhite) {
    player.setColor(isWhite);
  }

  public boolean isPlayerCurrent(){
    return board.isWhiteCurrent() == player.isWhite();
  }
}

