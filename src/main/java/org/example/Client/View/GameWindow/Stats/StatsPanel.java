package org.example.Client.View.GameWindow.Stats;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import org.example.Client.View.View;

public class StatsPanel extends JPanel implements View {
private View portInfo;
  public StatsPanel(){
    setBackground(Color.red);
    setLayout(new GridLayout(2,1));
    add(new JPanel());
    add(new JPanel());
  }

  @Override
  public void display() {

  }

  @Override
  public void addComponent(View view) {
    this.add((Component)view);
  }

  @Override
  public void addAction(ActionListener listener) {

  }

  @Override
  public void remove(View view) {

  }

  @Override
  public View download(int i) {
    return portInfo;
  }
}
