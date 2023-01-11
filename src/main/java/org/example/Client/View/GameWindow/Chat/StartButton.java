package org.example.Client.View.GameWindow.Chat;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.example.Client.View.View;

/**
 *
 */
public class StartButton extends JButton implements View {
  /**
   *
   */
  public StartButton(){
    setText("StartGame");
  }

  /**
   *
   */
  @Override
  public void display() {

  }

  /**
   *
   * @param view
   */
  @Override
  public void addComponent(View view) {

  }

  @Override
  public void addAction(ActionListener listener) {
    addActionListener(listener);
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
    return null;
  }
}
