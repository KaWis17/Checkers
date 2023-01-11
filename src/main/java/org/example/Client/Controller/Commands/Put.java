package org.example.Client.Controller.Commands;

import org.example.Client.Client;
import org.example.Client.Model.SpecificModel;

import static java.lang.Integer.parseInt;

public class Put extends AbstractCommand {
    @Override
    public void execute(String line, Client client) {
        line=line.replaceAll("(.*): /put ","");
        int x = parseInt(String.valueOf(line.charAt(0)));
        int y = parseInt(String.valueOf(line.charAt(2)));
        ((SpecificModel)client.model).put(x,y);
        int winner = ((SpecificModel) client.model).getBoard().getWinner();
        if(winner == 1 || winner == -1) {
            client.send(": /endgame");
        }
        else{
            client.send(": /localnotify");
        }
    }
}
