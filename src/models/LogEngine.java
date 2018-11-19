package models;

import Exceptions.CommandNotFoundException;
import ui.ConsoleDisplay;

import java.util.Arrays;

public class LogEngine{

    private final CommandInterpreter commandInterpreter = new CommandInterpreter();
    private Log log;
    private ConsoleDisplay console;

    public LogEngine(ConsoleDisplay console){
        this.console = console;
        log = new Log(console, "log title");

    }

    public void update(String change){
        log.loadData(Arrays.asList(change.split("\\n")));
    }

    public void pushCommand(String command){
        try {
            commandInterpreter.handleCommand(log, "``" + command);
        }catch (CommandNotFoundException e){
            console.refresh("Command Not Found");
        }
    }

    public void pull(){

    }
}
