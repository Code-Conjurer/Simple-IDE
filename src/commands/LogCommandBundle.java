package commands;

import models.Command;
import unnamed.Log;

import java.util.HashMap;

public class LogCommandBundle extends CommandBundle{

    private Log log;
    //HashMap<String, Command> commandLibrary;

    public LogCommandBundle(Log log){
        this.log = log;

        commandLibrary = new HashMap<>();

        Command[] commands = {
                new Write(log),
                new Compile(log),
                new Delete(log),
                new Edit(log),
                new Load(log),
                new Save(log)
        };

        for(Command c : commands)
            commandLibrary.put(c.getName(), c);
    }

}
