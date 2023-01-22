package org.example.Server;

import org.example.Client.Client;

public class ServerRunner {

  public static void main(String[] args){
    ClientThread client = new ClientThread();
    Server server= new Server(4444);
    client.start();
    server.start();
  }

  public static class ClientThread extends Thread{
    @Override
    public void run() {
      try {
        sleep(100);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      super.run();
      Client client =new Client();
      client.main(false);
    }
  }
}
