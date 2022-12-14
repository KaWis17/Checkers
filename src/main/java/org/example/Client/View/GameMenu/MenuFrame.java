package org.example.Client.View.GameMenu;

import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import org.example.Client.View.View;

public class MenuFrame extends JFrame implements View {

  MenuPanel panel = new MenuPanel();
  public MenuFrame(){
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(500, 210);
    setTitle("Warcaby - Main Menu");
    setResizable(false);
    add(panel);
    display();
    getContentPane().requestFocusInWindow();
  }

  public void disposeWindow(){
    dispose();
  }
  @Override
  public void display() {
    this.setVisible(true);
  }

  @Override
  public void addComponent(View view) {
    this.add((Component) view);
  }

  @Override
  public void remove(View view) {
    this.remove(view);
  }

  @Override
  public View download(int i) {
    return panel;
  }

  @Override
  public void addAction(ActionListener listener){

  }

}
