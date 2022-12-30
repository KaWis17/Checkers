package org.example.Client.Controller.Commands;

import org.example.Client.Client;
import org.example.Client.Controller.SpecificController;

public class LocalColor extends AbstractCommand {
    @Override
    public void execute(String line, Client client) {
        String argument = line.replaceAll("(.*): /localcolor ", "");
        boolean color = argument.toLowerCase().contains("white");
        ((SpecificController)client.controller).setModelColor(color);
    }
}
