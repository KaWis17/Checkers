package org.example.Client.Model;

import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Rules.Rules;
import org.example.Vector2;

/**
 * Specific model
 */
public class SpecificModel extends AbstractModel {
  /**
   * rules of game
   */
  Rules rules;
  /**
   * board
   */
  Board board;
  /**
   * players representation
   */
  Player player;

  /**
   * game initiated
   */
  public boolean initiated;

  /**
   * Specific model constructor
   */
  public SpecificModel() {
    board = new Board(2);
    rules = new Rules();
    player = new Player("Anon",false);
  }

  /**
   * picks one of pons
   * @param x x
   * @param y y
   */
  public void pick(int x, int y) {
    rules.pick(new Vector2(x,y),board);
  }

  /**
   * puts pon in one place
   * @param x x
   * @param y y
   */
  public void put(int x, int y) {
    rules.put(new Vector2(x,y),board);
  }

  /**
   * getter for player name
   * @return player name
   */
  public String getPlayerName() {
        return player.getName();
  }

  /**
   * setter for player name
   * @param playerName name
   */
  public void setPlayerName(String playerName) {
      player.setName(playerName);
  }

  /**
   * getter for board
   * @return board
   */
  public Board getBoard(){
    return board;
  }

  /**
   * getter for rules
   * @return rules
   */
  public Rules getRules(){
    return rules;
  }

  /**
   * setter for player color
   * @param isWhite is white?
   */
  public void setPlayerColor(boolean isWhite) {
    player.setColor(isWhite);
  }

  /**
   * checks if player is current
   * @return answer
   */
  public boolean isPlayerCurrent(){
    return board.isWhiteCurrent() == player.isWhite();
  }
}

