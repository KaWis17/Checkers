package org.example.Client.Controller.Commands;

import org.example.Client.Client;
import org.example.Client.Model.SpecificModel;
import org.example.Client.View.GameWindow.Chat.ChatPanel;
import org.example.Client.View.GameWindow.GameFrame;

public class Print extends AbstractCommand {
    @Override
    public void execute(String line, Client client) {
        ((ChatPanel)((GameFrame)client.view).download(1).download(3)).addText(((SpecificModel)client.model).getBoard().printBoard());
    }
}
