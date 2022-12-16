package org.example.Client.Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JTextArea;
import org.example.Client.Client;
import org.example.Client.Model.SpecificModel;


public class SpecificController extends AbstractController {

  Client client;

  public SpecificController(Client client){
      this.client=client;
  }

  public void initGame(){
    System.out.println("TUTAJ DZIAŁA");
    client.initConnection(4444);
  }

  public void chat(){
    System.out.println("TEST");
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
}

