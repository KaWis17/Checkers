package org.example.Client.Controller.Commands;

import org.example.Client.Client;
import org.example.Client.Controller.SpecificController;

public class EndGame extends AbstractCommand{
  @Override
  public void execute(String line, Client client) {
    ((SpecificController)(client.controller)).finish();
  }
}
