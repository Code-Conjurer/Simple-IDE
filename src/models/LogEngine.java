package models;

import Exceptions.CommandNotFoundException;
import ui.ConsoleDisplay;

import java.util.*;

public class LogEngine{

    private final CommandInterpreter commandInterpreter = new CommandInterpreter();;
    private Log log;
    private ConsoleDisplay console;

    public LogEngine(ConsoleDisplay console){
        this.console = console;
        log = new Log(console, "log title");

    }

    public void addObserver(Observer o){
        log.addObserver(o);
    }

    public void update(String newData){
        ArrayList<String> newList = new ArrayList<>();

        if(newData == null || newData.equals("")) {
            log.loadData(newList);
        }else{
            String[] temp = newData.split("\\n");
            for(String s : temp){
                newList.add(s);
            }

            log.loadDataWithoutNotify(newList);
        }
    }

    public void pushCommand(String command){
        try {
            commandInterpreter.handleCommand(log, "``" + command);
        }catch (CommandNotFoundException e){
            console.refresh("Command Not Found");
        }
    }

}
