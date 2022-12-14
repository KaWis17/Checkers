package org.example.Client.View.GameWindow;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import org.example.Client.View.GameWindow.Board.BoardPanel;
import org.example.Client.View.GameWindow.Chat.ChatPanel;
import org.example.Client.View.GameWindow.Stats.StatsPanel;
import org.example.Client.View.View;

public class GamePanel extends JPanel implements View {

  private StatsPanel statsPanel;
  private ChatPanel chatPanel;
  GamePanel(){
    setBackground(Color.BLUE);
    setLayout(new BorderLayout());
    add(statsPanel = new StatsPanel(), BorderLayout.WEST);
    add(new BoardPanel(), BorderLayout.CENTER);
    add(chatPanel = new ChatPanel(), BorderLayout.EAST);
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

  }

  @Override
  public View download(int i) {
    if(i==1) return statsPanel;
    if(i==3) return chatPanel;
    return null;
  }
}
