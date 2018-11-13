/*package commands;

import models.LogCommand;
import models.SingleArgCommand;
import unnamed.CommandInterpreter;
import unnamed.Log;

import java.util.Arrays;
import java.util.List;

public class CompositeCommand extends LogCommand {

    List<String> commands;
    CommandInterpreter commandInterpreter;

    public CompositeCommand(Log log){
        super(log, "{");
        commandInterpreter = new CommandInterpreter(log);
    }

    public CompositeCommand(Log log, CommandInterpreter commandInterpreter){
        super(log, "{");
        this.commandInterpreter = commandInterpreter;
    }

    @Override
    public void execute(String... args){
        for(String command: args){
            if(args.equals("``{")){
                commandInterpreter.handleCommand();
            }
        }
    }

    public void addCommand(String command){
        commands.add(command);
    }
}*/