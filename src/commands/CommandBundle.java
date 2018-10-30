package commands;

import models.Command;

import java.util.HashMap;

public abstract class CommandBundle {

    HashMap<String, Command> commandLibrary;

    public Command getCommand(String commandName){
        return commandLibrary.get(commandName);
    }

}
