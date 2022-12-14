package org.example.Client.View.GameMenu;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import org.example.Client.View.View;

public class MenuButton extends JButton implements View {

  MenuButton(String text){
    setPreferredSize(new Dimension(175, 100));
    setText(text);
    setFocusable(false);
    setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
  }

  public void display() {

  }

  public void addComponent(View view) {

  }

  @Override
  public void addAction(ActionListener listener) {
    addActionListener(listener);
  }

  public void remove(View view) {

  }

  public View download(int i) {
    return null;
  }
}
