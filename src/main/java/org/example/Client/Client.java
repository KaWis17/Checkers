package org.example.Client;

import java.io.*;
import java.net.Socket;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import org.example.Client.Controller.AbstractController;
import org.example.Client.Controller.SpecificController;
import org.example.Client.Model.AbstractModel;
import org.example.Client.Model.SpecificModel;
import org.example.Client.View.GameMenu.MenuFrame;
import org.example.Client.View.GameWindow.Chat.ChatPanel;
import org.example.Client.View.GameWindow.GameFrame;
import org.example.Client.View.View;

public class Client {

  private static BufferedReader in;
  private static PrintWriter out;
  private static BufferedReader bufferRead;

  public View view;

  public void main(){
    view = new GameFrame();
    AbstractController controller = new SpecificController(this);
    //new MenuFrame();
    AbstractModel model = new SpecificModel("Player");

    controller.setModel(model);
    controller.setView(view);
    model.setView(view);

    ((SpecificController)controller).chat();
    ((SpecificController)controller).initGame();
  }

  public void initConnection(int port){
    try{
      Socket s1 = new Socket("localhost", port);
      out = new PrintWriter(s1.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(s1.getInputStream()));
      bufferRead = new BufferedReader(new InputStreamReader(System.in));

      new Receive(in, view).start();
      do{
        send(bufferRead.readLine());
      } while(true);
    }
    catch (IOException e){
      e.printStackTrace();
      System.out.println("Could not connect. Check the hostname and port.");
      System.exit(0);
    }
  }
  public void send(String message){
    out.println(message);
  }
}

class Receive extends Thread{
  BufferedReader in;
  View view;
  Receive(BufferedReader in, View view){
    this.view = view;
    this.in = in;
  }

  public void run(){
    try {
      while(true){
        ((ChatPanel)((GameFrame)view).download(1).download(3)).addText(in.readLine());
        //System.out.println(in.readLine());
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
