package commands;

import models.Command;
import ui.ConsoleDisplay;

import java.util.HashMap;

public class LogCommandBundle extends CommandBundle{

    public LogCommandBundle(){
        commandLibrary = new HashMap<>();

        Command[] commands = {
                new Write(),
                new Compile(),
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
