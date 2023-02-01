package org.example.Client.Controller.Commands;

import java.sql.SQLException;
import org.example.Client.Client;
import org.example.Client.DatabaseConn.Database;
import org.example.Client.Model.SpecificModel;
import org.example.Client.View.GameWindow.Board.Tile;

public class Save extends AbstractCommand{
  @Override
  public void execute(String line, Client client) {

    String board = (((SpecificModel)client.model).getBoard().printBoard());
    boolean isCurrentlyWhite = (((SpecificModel)client.model).getBoard().getIsWhiteCurrent());

    Database db = null;
    try {
      db = new Database();
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    try {
      db.addRecord(isCurrentlyWhite, board);
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

  }
}
