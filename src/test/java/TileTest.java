import org.example.Client.Model.Board.Tile;
import org.example.Client.Model.Board.TileState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TileTest {
  @Test
  void setPossible(){
    Tile tile = new Tile(false, TileState.PON_1);
    tile.setPossible(true);
    assertTrue(tile.isPossible());
  }

  @Test
  void setState1(){
    Tile tile = new Tile(false, TileState.PON_1);
    tile.setState(TileState.QUEEN_2);
    assertEquals(TileState.QUEEN_2, tile.getState());
  }

  @Test
  void setState2(){
    Tile tile = new Tile(false, TileState.PON_1);
    tile.setState(TileState.EMPTY);
    assertEquals(TileState.EMPTY, tile.getState());
  }

  @Test
  void setPicked(){
    Tile tile = new Tile(false, TileState.PON_1);
    tile.setPicked(true);
    assertTrue(tile.isPicked());
  }
}