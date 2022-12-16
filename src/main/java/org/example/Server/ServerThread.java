package org.example.Server;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread{
  private Socket socket;
  OutputStream output;
  PrintWriter out;
  ServerThread(Socket socket){
    this.socket = socket;
  }

  public void run(){
    try {
      InputStream input = socket.getInputStream();
      BufferedReader in = new BufferedReader(new InputStreamReader(input));

      output = socket.getOutputStream();
      out = new PrintWriter(output, true);

      String line;
      do {
        line = in.readLine();
        processCommand(line);
        send(line);

      } while (!line.equals("bye"));
      socket.close();

    } catch (IOException ex) {
      System.out.println("Server exception: " + ex.getMessage());
      ex.printStackTrace();
    }
  }

  private void processCommand(String line) {
    if(matchesNameCommand(line)){
      nameCommand(line);
    }
    System.out.println(line);
  }

  private static boolean matchesNameCommand(String line) {
    return line.matches("/name (.*)") || line.matches("(.*): /name (.*)");
  }

  private void nameCommand(String line){
    String newName= line.substring(line.indexOf(':')+7);
    sendToOther("/othername "+newName);
    out.println("Changed name to: "+newName);
  }

protected void send(String message){
    for(ServerThread thread : Server.threads)
      thread.out.println(message);
  }

  protected void sendToOther(String message){
    for(ServerThread thread : Server.threads)
      if(thread!=this){
        thread.out.println(message);
      }
  }
}
