package org.example.Client.Controller.Commands;

import java.sql.SQLException;
import org.example.Client.Client;
import org.example.Client.DatabaseConn.Database;
import org.example.Client.Model.Board.Board;
import org.example.Client.Model.Board.Tile;
import org.example.Client.Model.Board.TileState;
import org.example.Client.Model.SpecificModel;

public class Load extends AbstractCommand{
  @Override
  public void execute(String line, Client client) {
    Board board = (((SpecificModel)client.model).getBoard());

    Database db;
    try {
      db = new Database();
    } catch (ClassNotFoundException | SQLException e) {
      throw new RuntimeException(e);
    }

    try {
      board.setIsWhiteCurrent(db.loadRecordBoolean());
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    try {
      String board_text = db.loadRecordString();

      System.out.println(board_text);

      for(int i=0; i<8; i++){
        for(int j=0; j<8; j++){
          Tile tile = board.getTile(i, j);
          int location = ((i * 8) + j) * 4 + i;

          tile.setIsWhite(board_text.charAt(location +1)=='w');
          tile.setIsPicked(board_text.charAt(location)=='{');
          tile.setIsPossible(board_text.charAt(location)=='<');

          int state = Character.getNumericValue(board_text.charAt(location +2));
          switch (state){
            case 0:
              tile.setState(TileState.EMPTY);
              break;
            case 1:
              tile.setState(TileState.PON_1);
              break;
            case 2:
              tile.setState(TileState.PON_2);
              break;
            case 3:
              tile.setState(TileState.QUEEN_1);
              break;
            case 4:
              tile.setState(TileState.QUEEN_2);
              break;
          }

        }
      }


    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    System.out.println("test1");
    client.send(": /localnotify");
    System.out.println("test1");
  }
}
