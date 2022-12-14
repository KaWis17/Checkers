package org.example.Client.View.GameWindow.Chat;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import org.example.Client.View.View;

public class ChatWrite extends JTextArea implements View {

  public ChatWrite(){
    setPreferredSize(new Dimension(200,200));
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
    return null;
  }
}
