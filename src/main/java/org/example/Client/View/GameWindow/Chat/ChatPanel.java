package org.example.Client.View.GameWindow.Chat;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JPanel;

import org.example.Client.View.View;
import org.example.Client.Controller.Commands.CommandMatching;

/**
 *
 */
public class ChatPanel extends JPanel implements View {
  private final ChatArea area;
  private final ChatWrite write;

  /**
   *
   */
  public ChatPanel(){
    setBackground(Color.green);
    setLayout(new GridLayout(2,1));

    area = new ChatArea();
    add(area);

    write = new ChatWrite();
    add(write);

  }

  /**
   *
   * @param text
   */
  public void addText(String text){
    if(!isCommand(text))
    area.append(text +"\n");
  }

  /**
   *
   * @param text
   * @return
   */
  private static boolean isCommand(String text) {
  return CommandMatching.isCommand(text);
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
    add((Component) view);
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
    if(i==1) return area;
    if(i==2) return write;
    return null;
  }
}
