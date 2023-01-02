package org.example.Client.Controller.Commands;

/**
 * class that matches command line with specific class that implements abstract command
 */
public class CommandMatching {
    /**
     * checks if given text is command
     * @param line line
     * @return answer
     */
    public static boolean isCommand(String line) {
        return line.matches("(.*): /(.*)");
    }

    /**
     * extracts command from text line
     * @param line line
     * @return command type
     */
    public static String extractCommand(String line){
        String withoutUser = line.substring(line.indexOf("/")+1);
        String[] segments = withoutUser.split(" ", 2);
        return segments[0];
    }

    /**
     * converts local command to other command
     * @param line text line
     * @return converted command line
     */
    public static String changeLocalToOther(String line)
    {
        line=line.replaceAll(": /local",": /other");
        return line;
    }

    /**
     * finds command class that matches text line
     * @param line text line
     * @return specific command interface
     */
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
            case "otherstart" -> {
                return new OtherStart();
            }
        }
        return null;
    }
}
