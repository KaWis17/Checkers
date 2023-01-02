package org.example.Client.View.GameWindow.Board;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.example.Client.View.View;

public class Tile extends JButton implements View {

  int place;
  Tile(int i){
    this.setForeground(Color.red);
    setFocusable(false);
    this.place = i;
  }

  public void setColor(char color){
    switch (color){
      case 'w' -> this.setBackground(Color.WHITE);
      case 'y' -> this.setBackground(Color.YELLOW);
      case 'g' -> this.setBackground(Color.GREEN);
      default -> this.setBackground(Color.BLACK);
    }
  }

  public void setState(int state){
    switch (state){
      case 0 -> this.setText("");
      case 1 -> this.setText("PON1");
      case 2 -> this.setText("PON2");
      case 3 -> this.setText("QUEEN1");
      case 4 -> this.setText("QUEEN2");
    }
  }


  @Override
  public void display() {

  }

  @Override
  public void addComponent(View view) {

  }

  @Override
  public void addAction(ActionListener listener) {
    this.addActionListener(listener);
  }

  @Override
  public void remove(View view) {

  }

  @Override
  public View download(int i) {
    return null;
  }

  public int getPlace() {
    return place;
  }
}
