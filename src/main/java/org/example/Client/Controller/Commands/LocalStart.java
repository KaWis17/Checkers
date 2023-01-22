package org.example.Client.Controller.Commands;

import org.example.Client.Client;
import org.example.Client.Model.SpecificModel;

public class LocalStart extends OtherStart{

    public void execute(String line, Client client) {
        String arguments = line.replaceAll("(.*): /localstart ","");
        initGame(arguments,client);
        client.send(": /localcolor white");
        client.send(": /notify");
    }
}
