package commands;

import models.Command;
import models.Log;
import ui.ConsoleDisplay;

import java.util.HashMap;

public class LogCommandBundle extends CommandBundle{

    //HashMap<String, Command> commandLibrary;
    //ConsoleDisplay console;

    public LogCommandBundle(){
        //this.console = console;
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
