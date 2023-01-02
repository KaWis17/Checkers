package org.example.Client.Controller.Commands;
public class CommandMatching {

    public static boolean isCommand(String line) {
        return line.matches("(.*): /(.*)");
    }

    public static String extractCommand(String line){
        String withoutUser = line.substring(line.indexOf("/")+1);
        String[] segments = withoutUser.split(" ", 2);
        return segments[0];
    }

    public static String changeLocalToOther(String line)
    {
        line=line.replaceAll(": /local",": /other");
        return line;
    }

    public static AbstractCommand findCommand(String line){
        String commandType = extractCommand(line);
        switch (commandType){
            case "localname" -> {
                return new LocalName();
            }
            case "othername" -> {
                return new OtherName();
            }
            case "localcolor" -> {
                return new LocalColor();
            }
            case "print","localprint" -> {
                return new Print();
            }
            case "notify","localnotify" -> {
                return new Notify();
            }
            case "pick" -> {
                return new Pick();
            }
            case "put" -> {
                return new Put();
            }
            case "localstart" -> {
                return new LocalStart();
            }
        }
        return null;
    }
}
