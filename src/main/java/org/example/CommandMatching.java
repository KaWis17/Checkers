package org.example;

public class CommandMatching {

    public static boolean isCommand(String line) {
        return (line.matches("/(.*)") || line.matches("(.*): /(.*)"));
    }

    public static boolean matchesNameCommand(String line) {
        return line.matches("/name (.*)") || line.matches("(.*): /name (.*)");
    }

    public static boolean matchesPrintCommand(String line) {
        return line.matches("/print(.*)") || line.matches("(.*): /print(.*)");
    }

    public static boolean matchesOtherNameCommand(String line) {
        return line.matches("/othername (.*)");
    }

    public static boolean matchesNameChanged(String line) {
        return line.matches("Changed name to: (.*)");
    }
}
