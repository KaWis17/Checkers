package org.example.Client.Controller;

import org.example.Client.Client;
import org.example.Client.Controller.Commands.AbstractCommand;
import org.example.Client.Controller.Commands.CommandMatching;
import org.example.Client.Model.SpecificModel;
import org.example.Client.View.GameWindow.Board.Tile;
import org.example.Client.View.GameWindow.Chat.ChatPanel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class SpecificController extends AbstractController {

  Client client;

  public SpecificController(Client client){
      this.client=client;
  }

  public void processCommand(String line){
    AbstractCommand command = CommandMatching.findCommand(line);
    if(command != null) command.execute(line,client);
    ((ChatPanel) view.download(1).download(3)).addText(line);
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
          if(CommandMatching.isCommand(text))
          processCommand(text);
          client.send(": "+text);
        }
      }

      @Override
      public void keyReleased(KeyEvent e) {}
    });
  }

  public void tileListener(){
    //TODO: Interpelacja do dr. Macyny
    for(int i=0; i<8; i++){
      for(int j=0; j<8; j++){
        Tile tile = ((Tile)view.download(1).download(2).download(i*8+j));
        tile.addAction(e -> {
          if(((SpecificModel)model).isPlayerCurrent()){
            if (pickedPonExists() && isMine(tile)) {
              client.send(": /pick " + tile.getPlace() / 8 + " " + tile.getPlace() % 8);
            } else if (!pickedPonExists()){
              client.send(": /put " + tile.getPlace() / 8 + " " + tile.getPlace() % 8);
            }
          }
        });
      }
    }
  }

  private boolean isMine(Tile tile) {
    return ((SpecificModel) model).getBoard().isMine(tile.getPlace() / 8, tile.getPlace() % 8);
  }

  private boolean pickedPonExists() {
    return ((SpecificModel) model).getBoard().getPicked() == null;
  }

  public void setModelPlayer(String name){
    ((SpecificModel)model).setPlayerName(name);
  }

  public void setModelColor(boolean isWhite){
    ((SpecificModel)model).setPlayerColor(isWhite);
  }
}

