package org.example.Client.Controller.Commands;

import org.example.Client.Client;

public class Print extends AbstractCommand {
    @Override
    public void execute(String line, Client client) {
        //deprecated
        //((ChatPanel)((GameFrame)client.view).download(1).download(3)).addText(((SpecificModel)client.model).getBoard().printBoard());
    }
}
