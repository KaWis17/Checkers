package org.example.Client.Controller.Commands;

import org.example.Client.Client;

public abstract class AbstractCommand {
    abstract public void execute(String line, Client client);
}
