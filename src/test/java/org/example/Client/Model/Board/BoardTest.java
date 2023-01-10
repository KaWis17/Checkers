package org.example.Client.Model.Board;

import org.example.Vector2;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class BoardTest {

  @Test
  void getTile(){
    Board board = new Board(3);
    assertEquals(board.getTile(1, 2), board.getTile(new Vector2(1, 2)));
  }

  @Test
  void sameTeam1(){
    Board board = new Board(3);
    assertTrue(board.sameTeam(new Vector2(0, 1), new Vector2(0, 3)));
  }

  @Test
  void sameTeam2(){
    Board board = new Board(3);
    assertFalse(board.sameTeam(new Vector2(0, 0), new Vector2(0, 3)));
  }

}