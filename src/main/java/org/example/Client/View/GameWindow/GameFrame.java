package org.example.Client.View.GameWindow;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import org.example.Client.View.View;

public class GameFrame extends JFrame implements View {
  private GamePanel panel;
  public GameFrame(){
    setTitle("Warcaby");
    setSize(500, 500);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setExtendedState(JFrame.MAXIMIZED_BOTH);
    addComponent(panel = new GamePanel());
    display();
  }

  @Override
  public void display() {
    setVisible(true);
  }

  @Override
  public void addComponent(View view) {
    this.add((Component) view);
  }

  @Override
  public void addAction(ActionListener listener) {

  }

  @Override
  public void remove(View view) {

  }

  @Override
  public View download(int i) {
    return panel;
  }
}
