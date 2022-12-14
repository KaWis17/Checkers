package org.example.Client.View.GameMenu;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import org.example.Client.View.View;

public class MenuPanel extends JPanel implements View {

  MenuButton buttonCreateGame = new MenuButton("Stwórz grę");
  MenuButton buttonJoinGame = new MenuButton("Dołącz do gry");
  TextField textField = new TextField();
  MenuPanel(){
    setBackground(Color.BLUE);
    addComponent(textField);
    addComponent(buttonCreateGame);
    addComponent(buttonJoinGame);
    setLayout(new FlowLayout(1));
  }

  @Override
  public void display() {

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
    this.remove(view);
  }

  @Override
  public View download(int i) {
    if(i==1) return buttonCreateGame;
    else if(i==2) return buttonJoinGame;
    else return textField;
  }
}
