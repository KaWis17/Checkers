package org.example.Client;

import java.io.*;
import java.net.Socket;

import org.example.Client.Controller.AbstractController;
import org.example.Client.Controller.Bot.BotController;
import org.example.Client.Controller.SpecificController;
import org.example.Client.Model.AbstractModel;
import org.example.Client.Model.SpecificModel;
import org.example.Client.View.GameWindow.GameFrame;
import org.example.Client.View.View;

public class Client {

  private static BufferedReader in;
  private static PrintWriter out;
  private static BufferedReader bufferRead;

  public View view;

  public AbstractModel model;

  public AbstractController controller;

  public void main(boolean isBot){
    view = new GameFrame();
    model = new SpecificModel();
    controller = isBot ? new BotController(this) : new SpecificController(this);

    controller.setModel(model);
    controller.setView(view);
    model.setView(view);

    ((SpecificController)controller).controls();
    ((SpecificController)controller).tileListener();
    ((SpecificController)controller).initGame();
  }

  public void initConnection(int port){
    try{
      Socket s1 = new Socket("localhost", port);
      out = new PrintWriter(s1.getOutputStream(), true);
      in = new BufferedReader(new InputStreamReader(s1.getInputStream()));
      bufferRead = new BufferedReader(new InputStreamReader(System.in));

      new Receive(in, view, controller).start();
      do{
        String line=bufferRead.readLine();
        send(line);
      } while(true);
    }
    catch (IOException e){
      e.printStackTrace();
      System.out.println("Could not connect. Check the hostname and port.");
      System.exit(0);
    }
  }
  public void send(String message){
    out.println(((SpecificModel)model).getPlayerName()+message);
  }
}

class Receive extends Thread{
  BufferedReader in;
  View view;

  AbstractController controller;

  Receive(BufferedReader in, View view, AbstractController controller){
    this.controller=controller;
    this.view = view;
    this.in = in;
  }

  public void run(){
    try {
      while(true){
        String line=in.readLine();
        ((SpecificController)controller).processCommand(line);
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
