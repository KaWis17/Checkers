package org.example.Client.View.GameWindow;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import org.example.Client.View.View;

/**
 *
 */
public class GameFrame extends JFrame implements View {
  private final GamePanel panel;

  /**
   *
   */
  public GameFrame(){
    setTitle("Warcaby");
    setSize(1000, 750);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    addComponent(panel = new GamePanel());
    display();
  }

  /**
   *
   */
  @Override
  public void display() {
    setVisible(true);
  }

  /**
   *
   * @param view
   */
  @Override
  public void addComponent(View view) {
    this.add((Component) view);
  }

  /**
   *
   * @param listener
   */
  @Override
  public void addAction(ActionListener listener) {

  }

  /**
   *
   * @param view
   */
  @Override
  public void remove(View view) {

  }

  /**
   *
   * @param i
   * @return
   */
  @Override
  public View download(int i) {
    return panel;
  }
}
