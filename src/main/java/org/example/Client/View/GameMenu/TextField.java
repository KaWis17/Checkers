package org.example.Client.View.GameMenu;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import org.example.Client.View.View;

public class TextField extends JTextField implements View {

  TextField(){
    String defaultText = "Enter your name...";
    setText(defaultText);
    setPreferredSize(new Dimension(300, 50));
    setFont(new Font(Font.DIALOG, Font.PLAIN, 15));
    setHorizontalAlignment(JTextField.CENTER);

    addFocusListener(new FocusListener() {
      @Override
      public void focusLost(final FocusEvent event) {
        if ("".equals(getText())) {
          setText(defaultText);
        }
      }

      @Override
      public void focusGained(final FocusEvent event) {
        if (getText().trim().equals(defaultText)) {
          setText("");
        }
      }
    });
  }

  public String getName(){
    return getText();
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
