package org.example.Client.View.GameWindow.Board;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import org.example.Client.View.View;

public class BoardPanel extends JPanel implements View {

  Tile[] tiles = new Tile[64];
  public BoardPanel(){
    setLayout(new GridLayout(8,8));
    setBackground(Color.BLACK);
    for(int i=0; i<64; i++){
      this.add(tiles[i] = new Tile(i));
    }
    getPreferredSize();
  }


  @Override
  public void display() {

  }

  @Override
  public void addComponent(View view) {

  }

  @Override
  public void addAction(ActionListener listener) {

  }

  @Override
  public void remove(View view) {

  }

  @Override
  public View download(int i) {
    return tiles[i];
  }
}
