package org.example.Client.Controller;

import org.example.Client.Client;
import org.example.Client.Controller.Commands.AbstractCommand;
import org.example.Client.Controller.Commands.CommandMatching;
import org.example.Client.Model.SpecificModel;
import org.example.Client.View.GameWindow.Board.Tile;
import org.example.Client.View.GameWindow.Chat.ChatPanel;
import org.example.Vector2;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Specific controller
 */
public class SpecificController extends AbstractController {
  /**
   * client that is connected to controller
   */
  Client client;

  /**
   * Constructor
   * @param client client
   */
  public SpecificController(Client client){
      this.client=client;
  }

  /**
   * function that matches given line with certain command and then executes it
   * @param line command to process
   */
  public void processCommand(String line){
    AbstractCommand command = CommandMatching.findCommand(line);
    if(command != null) command.execute(line,client);
    ((ChatPanel) view.download(1).download(3)).addText(line);
  }

  /**
   * function that initializes game
   */
  public void initGame(){
    client.initConnection(4444);
  }

  /**
   * addition of key listener to chat
   */
  public void chat(){
    JTextArea write = ((JTextArea)(view.download(1).download(3)).download(2));
    //TODO: create documentation
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

  /**
   * adding listeners to tile
   */
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

  /**
   * return if tile is mine
   * @param tile tile
   * @return answer
   */
  private boolean isMine(Tile tile) {
    return ((SpecificModel) model).getBoard().isMine(new Vector2(tile.getPlace() / 8, tile.getPlace() % 8));
  }

  /**
   * returns if any pon was picked
   * @return answer
   */
  private boolean pickedPonExists() {
    return ((SpecificModel) model).getBoard().getPicked() == null;
  }

  /**
   * sets player name
   * @param name name
   */
  public void setModelPlayer(String name){
    ((SpecificModel)model).setPlayerName(name);
  }

  /**
   * sets model color
   * @param isWhite is white
   */
  public void setModelColor(boolean isWhite){
    ((SpecificModel)model).setPlayerColor(isWhite);
  }
}

