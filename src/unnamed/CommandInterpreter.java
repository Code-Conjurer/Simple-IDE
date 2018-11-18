package unnamed;

import Exceptions.CommandNotFoundException;
import commands.CommandBundle;
import commands.LogCommandBundle;
import models.Command;
import models.LineCommand;
import models.SingleArgCommand;

import java.util.ArrayList;
import java.util.List;


public class CommandInterpreter {

    final String COMMAND_SIGNIFIER = "``";
    final int COMMAND_SIG_LENGTH =  COMMAND_SIGNIFIER.length();
    final int MIN_COMMAND_NAME_LENGTH = 1;
    List<CommandBundle> commandBundles;

    /*public CommandInterpreter(CommandBundle... commandBundles){
        this.commandBundles = new ArrayList<>();
        this.commandBundles = Arrays.asList(commandBundles);
    }*/

    public CommandInterpreter(Log log){
        this.commandBundles = new ArrayList<>();
        commandBundles.add(new LogCommandBundle(log));

    }

    public void handleCommand(String input) throws CommandNotFoundException {
        String commandName;
        int spaceMarker;
        Command command = null;

        if(input.equals("") || input == null)
            return;
        //Gets command name
        spaceMarker = input.indexOf(" ");
        if(spaceMarker == -1)//no " " were found
            spaceMarker = COMMAND_SIG_LENGTH;

        commandName =  input.substring(COMMAND_SIG_LENGTH, spaceMarker).toLowerCase();//"``someCommand 3 words" -> "someCommands"
        input = input.substring(spaceMarker);//"``someCommand 3 words" -> " 3 words"
        input = input.trim();

        //--------------------------
        /*
        //Recursively handles commands in command args
        int commandMarker = input.indexOf("``");
        if(commandMarker != -1) {
            handleCommand(input.substring(commandMarker));
            input = input.substring(0, commandMarker);
        }
        //--------------------------*/

        command = findCommand(commandName);

        if(command instanceof SingleArgCommand)
            command.execute(input);
        else if(command instanceof LineCommand){
            spaceMarker = input.indexOf(" ");

            if(spaceMarker == -1)
                spaceMarker = 1;

            String lineArg = input.substring(0, spaceMarker).trim();
            input = input.substring(spaceMarker).trim();
            command.execute(lineArg, input);
        }else{
            command.execute(input.split(" "));
        }
    }

    /*
    private String[] parseLineArgs(String input){
        String temp = input.substring(0, input.indexOf('>'));
        return temp.split(" ");
    }*/
/*
    private String parseCommandNameFromInput(){
        int spaceMarker;
        String commandName;

        spaceMarker = input.indexOf(" ");
        if(spaceMarker == -1)//no " " were found
            spaceMarker = COMMAND_SIG_LENGTH;

        commandName =  input.substring(COMMAND_SIG_LENGTH, spaceMarker).toLowerCase();//"``someCommand 3 words" -> "someCommands"
        input = input.substring(spaceMarker);//"``someCommand 3 words" -> " 3 words"
        input = input.trim();
        return commandName;
    }

    private void handleCommandsInArgs(String input)throws CommandNotFoundException{

        int commandMarker = input.indexOf("``");
        if(commandMarker == -1)
            return;

        //if(commandMarker > 0 && input.indexOf(commandMarker - 1) == '\\')// '\'
          //  return;

        //try {
        handleCommand(input.substring(commandMarker));
        ///}catch(CommandNotFoundException e){
           // throw e;
        //}

    }*/

    private Command findCommand(String commandName)throws CommandNotFoundException {

        Command c = null;

        for(CommandBundle comBun: commandBundles){
            c = comBun.getCommand(commandName);
            if(c != null)
                return c;
        }
        throw new CommandNotFoundException();
    }

    //Modifies: this
    //Effects: if the string starts with the COMMAND_SIGNIFIER returns true
    private boolean isCommand(String input){

        if(input.length() < COMMAND_SIGNIFIER.length() + MIN_COMMAND_NAME_LENGTH)
            return false;

        if(input.substring(0,COMMAND_SIGNIFIER.length()).equals(COMMAND_SIGNIFIER))
            return true;
        return false;
    }
}
