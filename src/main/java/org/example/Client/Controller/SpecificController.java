package org.example.Client.Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;
import org.example.Client.Client;
import org.example.Client.Model.SpecificModel;
import org.example.Client.View.GameWindow.Board.Tile;
import org.example.Client.View.GameWindow.Chat.ChatPanel;
import org.example.Client.View.GameWindow.GameFrame;
import org.example.Client.View.GameWindow.Stats.StatsPanel;
import org.example.CommandMatching;

import static java.lang.Integer.parseInt;


public class SpecificController extends AbstractController {

  Client client;

  public SpecificController(Client client){
      this.client=client;
  }

  public void processCommand(String line){
    if(CommandMatching.matchesCommand(line,"localname")){
      executeLocalName(line);
    }
    if(CommandMatching.matchesCommand(line,"othername")){
      executeOtherName(line);
    }
    if(CommandMatching.matchesCommand(line,"localcolor")){
      executeLocalColor(line);
    }
    if(CommandMatching.matchesCommand(line,"print","localprint")){
      executePrint();
    }
    if(CommandMatching.matchesCommand(line,"notify","localnotify")){
      executeNotify();
    }
    if(CommandMatching.matchesCommand(line,"pick")){
      executePick(line);
    }
    if(CommandMatching.matchesCommand(line,"put")){
      executePut(line);
    }
    ((ChatPanel)((GameFrame)view).download(1).download(3)).addText(line);
    //System.out.println(in.readLine());
  }

  private void executeLocalName(String line) {
    String name = line.replaceAll("(.*): /localname ", "");
    ((SpecificController)client.controller).setModelPlayer(name +": ");
    ((StatsPanel)view.download(1).download(1)).setPlayer1(name);
  }

  private void executeLocalColor(String line) {
    String argument = line.replaceAll("(.*): /localcolor ", "");
    boolean color = argument.toLowerCase().contains("white");
    ((SpecificController)client.controller).setModelColor(color);
  }

  private void executeOtherName(String line) {
    ((StatsPanel)view.download(1).download(1)).setPlayer2(line.replaceAll("(.*): /othername ",""));
  }

  private void executePrint() {
    ((ChatPanel)((GameFrame)view).download(1).download(3)).addText(((SpecificModel)model).printBoard());
  }

  private void executeNotify() {
    String board = (((SpecificModel)model).printBoard());
    for(int i=0; i<8; i++){
      for(int j=0; j<8; j++){
        Tile tile = ((Tile)view.download(1).download(2).download(i*8+j));
        int location = ((i * 8) + j) * 4 + i;
        char color = board.charAt(location +1);
        int state = Character.getNumericValue(board.charAt(location +2));
        boolean picked = board.charAt(location)=='{';

        tile.setColor(color);
        if(picked) tile.setColor('y');
        tile.setState(state);

      }
    }

  }

  private void executePick(String line) {
    line=line.replaceAll("(.*): /pick ","");
    int x = parseInt(String.valueOf(line.charAt(0)));
    int y = parseInt(String.valueOf(line.charAt(2)));
    ((SpecificModel)model).pick(x,y);
    client.send(": /localnotify");
  }

  private void executePut(String line) {
    line=line.replaceAll("(.*): /put ","");
    int x = parseInt(String.valueOf(line.charAt(0)));
    int y = parseInt(String.valueOf(line.charAt(2)));
    ((SpecificModel)model).put(x,y);
    client.send(": /localnotify");
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
          //TODO: Make simpler
          if(!((SpecificModel)model).isPlayerCurrent() ||
                  !((SpecificModel)model).getBoard().isMine(tile.getPlace()/8,tile.getPlace()%8)) return;

          if(((SpecificModel)model).getBoard().getPicked() == null){
            client.send(": /pick "+ tile.getPlace()/8+" "+ tile.getPlace()%8);
          }
          else{
            client.send(": /put "+ tile.getPlace()/8+" "+ tile.getPlace()%8);
          }
        });
      }
    }
  }

  public void setModelPlayer(String name){
    ((SpecificModel)model).setPlayerName(name);
  }

  public void setModelColor(boolean isWhite){
    ((SpecificModel)model).setPlayerColor(isWhite);
  }
}

