package org.example.Client.Controller.Commands;

import org.example.Client.Client;
import org.example.Client.View.GameWindow.Stats.StatsPanel;

public class OtherName extends AbstractCommand {
    @Override
    public void execute(String line, Client client) {
        ((StatsPanel)client.view.download(1).download(1)).setPlayer2(line.replaceAll("(.*): /othername ",""));
    }
}
