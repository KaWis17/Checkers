package org.example;

public class CommandMatching {

    public static boolean isCommand(String line) {
        return line.matches("(.*): /(.*)");
    }

    public static boolean matchesCommand(String line, String commandName)
    {
        String regex = "(.*): /"+commandName+"(.*)";
        return line.matches(regex);
    }

    public static boolean matchesCommand(String line, String commandName1,String commandName2)
    {
        return matchesCommand(line,commandName1) || matchesCommand(line,commandName2);
    }

    public static String changeLocalToOther(String line)
    {
        line=line.replaceAll(": /local",": /other");
        return line;
    }
}
