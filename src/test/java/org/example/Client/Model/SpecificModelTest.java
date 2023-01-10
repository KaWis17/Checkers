package org.example.Client.Model;

import org.example.Client.Model.Rules.FigureRules.NormalFigureRuleSet;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SpecificModelTest {
  @Test
  void pick(){
    SpecificModel model = new SpecificModel();
    model.rules.initRules(new NormalFigureRuleSet());
    model.pick(0, 1);

    assertEquals( "[w0]{b1}[w0][b1][w0][b1][w0][b1]\n" +
                          "[b1][w0][b1][w0][b1][w0][b1][w0]\n" +
                          "[w0][b0][w0][b0][w0][b0][w0][b0]\n" +
                          "[b0][w0][b0][w0][b0][w0][b0][w0]\n" +
                          "[w0][b0][w0][b0][w0][b0][w0][b0]\n" +
                          "[b0][w0][b0][w0][b0][w0][b0][w0]\n" +
                          "[w0][b2][w0][b2][w0][b2][w0][b2]\n" +
                          "[b2][w0][b2][w0][b2][w0][b2][w0]\n", model.board.printBoard());
  }

  @Test
  void put(){
    SpecificModel model = new SpecificModel();
    model.rules.initRules(new NormalFigureRuleSet());
    model.pick(1, 0);
    model.put(2, 1);

    System.out.println(model.board.printBoard());

    assertEquals( "[w0][b1][w0][b1][w0][b1][w0][b1]\n" +
                          "[b0][w0][b1][w0][b1][w0][b1][w0]\n" +
                          "[w0][b1][w0][b0][w0][b0][w0][b0]\n" +
                          "[b0][w0][b0][w0][b0][w0][b0][w0]\n" +
                          "[w0][b0][w0][b0][w0][b0][w0][b0]\n" +
                          "[b0][w0][b0][w0][b0][w0][b0][w0]\n" +
                          "[w0][b2][w0][b2][w0][b2][w0][b2]\n" +
                          "[b2][w0][b2][w0][b2][w0][b2][w0]\n", model.board.printBoard());
  }

  @Test
  void setPlayerName(){
    SpecificModel model = new SpecificModel();
    model.setPlayerName("Bartosz");

    assertEquals("Bartosz", model.getPlayerName());
  }

}