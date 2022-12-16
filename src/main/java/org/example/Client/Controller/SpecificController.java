package org.example.Client.Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;
import org.example.Client.Client;
import org.example.Client.Model.SpecificModel;
import org.example.Client.View.GameWindow.Chat.ChatPanel;
import org.example.Client.View.GameWindow.GameFrame;
import org.example.Client.View.GameWindow.Stats.StatsPanel;
import org.example.CommandMatching;


public class SpecificController extends AbstractController {

  Client client;

  public SpecificController(Client client){
      this.client=client;
  }

  public void processCommand(String line){
    if(CommandMatching.matchesNameChanged(line)){
      ((SpecificController)client.controller).setModelPlayer(line.substring(17)+": ");
      ((StatsPanel)view.download(1).download(1)).setPlayer1(line.substring(17));
    }
    if(CommandMatching.matchesOtherNameCommand(line)){

      ((StatsPanel)view.download(1).download(1)).setPlayer2(line.substring(11));
    }
    if(CommandMatching.matchesPrintCommand(line)){
      ((ChatPanel)((GameFrame)view).download(1).download(3)).addText(((SpecificModel)model).printBoard());
    }
    ((ChatPanel)((GameFrame)view).download(1).download(3)).addText(line);
    //System.out.println(in.readLine());
  }

  public void initGame(){
    client.initConnection(4444);
  }

  public void chat(){
    JTextArea write = ((JTextArea)(view.download(1).download(3)).download(2));

    write.addKeyListener(new KeyListener() {
      @Override
      public void keyTyped(KeyEvent e) {}

      @Override
      public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
          String text = write.getText();
          write.setText("");
          client.send(text);
        }
      }

      @Override
      public void keyReleased(KeyEvent e) {}
    });
  }

  public void setModelPlayer(String name){
    ((SpecificModel)model).setPlayer(name);
  }

  public String getModelPlayer(){
    return ((SpecificModel)model).getPlayer();
  }
}

