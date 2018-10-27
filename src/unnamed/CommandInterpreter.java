package unnamed;

import Exceptions.CommandNotFoundException;
import commands.CommandBundle;
import commands.LogCommandBundle;
import models.Command;
import models.LineCommand;
import models.SingleArgCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandInterpreter {

    final String COMMAND_SIGNIFIER = "``";
    final int MIN_COMMAND_NAME_LENGTH = 1;
    List<CommandBundle> commandBundles;

    public CommandInterpreter(CommandBundle... commandBundles){
        this.commandBundles = new ArrayList<>();
        this.commandBundles = Arrays.asList(commandBundles);
    }

    /*public CommandInterpreter(CommandBundle commandBundle){
        this.commandBundles = new ArrayList<>();
        commandBundles.add(commandBundle);
    }*/

    public CommandInterpreter(Log log){
        this.commandBundles = new ArrayList<>();
        commandBundles.add(new LogCommandBundle(log));

    }


    public void handleCommand(String input) throws CommandNotFoundException {
        String commandName;
        Command command = null;
        int sectionMarker;

        sectionMarker = input.indexOf(" ");
        commandName = input.substring(2, sectionMarker).toLowerCase();//"``someCommand 3 words" -> "someCommands"
        input = input.substring(sectionMarker + 1);//"``someCommand 3 words" -> "2 words"

        try {
            command = findCommand(commandName);
        }catch (CommandNotFoundException e){
            throw new CommandNotFoundException();
        }

        if(command instanceof SingleArgCommand)
            command.run(input);

        if(command instanceof LineCommand){
            sectionMarker = input.indexOf(" ");

            if(sectionMarker == -1)
                sectionMarker = 1;

            String lineArg = input.substring(0, sectionMarker).trim();
            input = input.substring(sectionMarker).trim();
            command.run(lineArg, input);
        }


        /*
        //REMARK: input without + 1 will have " " at char 0
        input = input.substring(sectionMarker + 1);

        //linesEffected = new String[1];
        sectionMarker = input.indexOf(' ');

        //if(sectionMarker == -1)
        //    linesEffected[0] = input;
       // else
        //    linesEffected[0] = input.substring(0, sectionMarker);
        //}
/*
        if(sectionMarker == -1)
            input = null;
        else {
            input = input.substring(sectionMarker + 1);// + 1 to remove '>'
            while(input.charAt(0) == ' '){// to remove spaces
                input = input.substring(1);
            }
        }*/
       // for(String s : linesEffected){
            //command.run(s, input);
       // }*/

    }

    /*
    private String[] parseLineArgs(String input){
        String temp = input.substring(0, input.indexOf('>'));
        return temp.split(" ");
    }*/

    private Command findCommand(String commandName)throws CommandNotFoundException {

        Command c = null;

        for(CommandBundle comBun: commandBundles){
            c = comBun.findCommand(commandName);
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
