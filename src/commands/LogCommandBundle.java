package commands;

import models.Command;
import models.Log;

import java.util.HashMap;

public class LogCommandBundle extends CommandBundle{

    private Log log;
    //HashMap<String, Command> commandLibrary;

    public LogCommandBundle(){

        commandLibrary = new HashMap<>();

        Command[] commands = {
                new Write(),
                new Compile(),
                //new ToggleNewLine(log),
                new Delete(),
                new Edit(),
                new Load(),
                new Save(),
                new Scrape(),
                new LoadExecute(),

                //NOT LOG COMMANDS
                new Print()
        };

        for(Command c : commands)
            commandLibrary.put(c.getName(), c);
    }

}
