package org.example.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends Thread{
  static ArrayList<ServerThread> threads = new ArrayList<>();
  int port;

  public Server(int port){
    this.port = port;
  }

  public void run(){
    try (ServerSocket serverSocket = new ServerSocket(port)) {
      System.out.println("SERVER: Server is listening on port: " + port);

      while (threads.size()<2) {
        Socket socket = serverSocket.accept();
        System.out.println("SERVER: New client connected");

        ServerThread thread = new ServerThread(socket);
        thread.start();
        threads.add(thread);
      }
    }
    catch (IOException ex) {
      System.out.println("Server exception: " + ex.getMessage());
      ex.printStackTrace();
    }
  }
}

