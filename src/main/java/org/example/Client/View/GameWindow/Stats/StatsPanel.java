package org.example.Client.View.GameWindow.Stats;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import org.example.Client.View.View;

/**
 *
 */
public class StatsPanel extends JPanel implements View {

private final JTextArea player1=new JTextArea("player1");
private final JTextArea player2=new JTextArea("player2");

  /**
   *
   */
  public StatsPanel(){
    setBackground(Color.red);
    setLayout(new GridLayout(2,1));
    add(player2);
    add(player1);
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
    this.add((Component)view);
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
    return null;
  }

  /**
   *
   * @param name
   */
  public void setPlayer1(String name) {
    player1.setText(name);
  }

  /**
   *
   * @param name
   */
  public void setPlayer2(String name) {
    player2.setText(name);
  }
}
