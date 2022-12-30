package org.example.Client.Controller.Commands;

import org.example.Client.Client;
import org.example.Client.Controller.SpecificController;
import org.example.Client.View.GameWindow.Stats.StatsPanel;

public class LocalName extends AbstractCommand{

    @Override
    public void execute(String line, Client client) {
        String name = line.replaceAll("(.*): /localname ", "");
        ((SpecificController)client.controller).setModelPlayer(name +": ");
        ((StatsPanel)client.view.download(1).download(1)).setPlayer1(name);
    }
}
