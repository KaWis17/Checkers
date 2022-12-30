package org.example.Client.Controller.Commands;

import org.example.Client.Client;
import org.example.Client.Model.SpecificModel;

import static java.lang.Integer.parseInt;

public class Pick extends AbstractCommand{

    @Override
    public void execute(String line, Client client) {
        line=line.replaceAll("(.*): /pick ","");
        int x = parseInt(String.valueOf(line.charAt(0)));
        int y = parseInt(String.valueOf(line.charAt(2)));
        ((SpecificModel)client.model).pick(x,y);
        client.send(": /localnotify");
    }
}
