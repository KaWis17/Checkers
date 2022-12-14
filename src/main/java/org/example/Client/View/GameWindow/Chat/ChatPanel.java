package org.example.Client.View.GameWindow.Chat;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import org.example.Client.View.View;

public class ChatPanel extends JPanel implements View {
  private ChatArea area;
  private ChatWrite write;
  public ChatPanel(){
    setBackground(Color.green);
    setLayout(new GridLayout(2,1));

    area = new ChatArea();
    add(area);

    write = new ChatWrite();
    add(write);

  }

  public void addText(String text){
    area.append(text +"\n");
  }

  @Override
  public void display() {

  }

  @Override
  public void addComponent(View view) {
    add((Component) view);
  }

  @Override
  public void addAction(ActionListener listener) {

  }

  @Override
  public void remove(View view) {

  }

  @Override
  public View download(int i) {
    if(i==1) return area;
    if(i==2) return write;
    return null;
  }
}
