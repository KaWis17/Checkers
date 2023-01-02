package org.example.Client.Controller.Commands;

import org.example.Client.Client;

public class LocalStart extends AbstractCommand{

    @Override
    public void execute(String line, Client client) {
        client.send(": /localcolor white");
        client.send(": /notify");
    }
}
