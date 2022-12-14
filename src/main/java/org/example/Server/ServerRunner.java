package org.example.Server;

public class ServerRunner {

  public static void main(String[] args){
    Server server= new Server(4444);
    server.start();
  }
}
