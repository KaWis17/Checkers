package org.example.Client.View.GameWindow.Chat;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import org.example.Client.View.View;

/**
 *
 */
public class ChatArea extends JTextArea implements View {
  /**
   *
   */
  public ChatArea(){
    setPreferredSize(new Dimension(200,500));
    setEnabled(false);
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
    return null;
  }
}
