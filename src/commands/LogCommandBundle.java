package commands;

import models.Command;
import models.Log;

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
                //new ToggleNewLine(log),
                new Delete(log),
                new Edit(log),
                new Load(log),
                new Save(log),
                new Scrape(log),
                new LoadExecute(log),

                //NOT LOG COMMANDS
                new Print()
        };

        for(Command c : commands)
            commandLibrary.put(c.getName(), c);
    }

}
