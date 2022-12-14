package org.example.Client.View.GameMenu;

import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.example.Client.View.View;

public class MenuInputPort extends JFrame implements View {

  public MenuInputPort(){
    String result = JOptionPane.showInputDialog("Podaj numer portu...");
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
