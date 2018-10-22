package commands;

import Exceptions.CommandNotFoundException;
import models.Command;
import unnamed.Log;

public class CommandBundle {
    Log log;
    final String COMMAND_SIGNIFIER = "``";
    final int MIN_COMMAND_NAME_LENGTH = 1;

    Command[] comList;//TODO: refactor, Command might have parameters (int, String), (CAN BE REPLACED BY LogCommand)
    private int delete, edit, read, search, write, save, load, compile;

    //TODO: implment a better way of creating/accessing commands (better data structure)
    public CommandBundle(Log log){
        delete = 0;
        edit = 1;
        read = 2;
        search = 3;
        write = 4;
        save = 5;
        load = 6;
        compile = 7;

        comList = new Command[8];
        comList[delete] = new Delete(log);
        comList[edit] = new Edit(log);
        comList[read] = new Read(log);
        comList[search] = new Search(log);
        comList[write] = new Write(log);
        comList[save] = new Save(log);
        comList[load] = new Load(log);
        comList[compile] = new Compile(log);
    }

    //TODO: Separate into private methods
    //TODO: remove magic numbers
    //TODO: test unknown command
    //TODO: use exceptions
    //TODO: handle invalid input
    public void handleCommand(String input) throws CommandNotFoundException{
        String commandName;
        Command command = null;
        int sectionMarker;
        String[] linesEffected;

        if (!isCommand(input)) {
            comList[write].run(input);
            return;
        }

        /*
        if (!input.contains(" ")) {
            System.out.println("~~Invalid Input~~");
            return;
        }*/

        sectionMarker = input.indexOf(" ");
        commandName = input.substring(2, sectionMarker).toLowerCase();
        try {
            command = findCommand(commandName);
        }catch (CommandNotFoundException e){
            throw new CommandNotFoundException();
        }

        //REMARK: input without + 1 will have " " at char 0
        input = input.substring(sectionMarker + 1);
        /*
        if (input.charAt(0) == '<') {
            input = input.substring(1);//removes '<' from string
            sectionMarker = input.indexOf('>');//removes '>' from string
            if (sectionMarker == -1) {//REMARK: .indexOf() returns -1 if char cannot be found
                System.out.println("~~ '>' not found in range~~");
                return;
            } else {
                linesEffected = parseLineArgs(input);
            }
        } else {*/
        linesEffected = new String[1];
        sectionMarker = input.indexOf(' ');

        if(sectionMarker == -1)
            linesEffected[0] = input;
        else
            linesEffected[0] = input.substring(0, sectionMarker);
        //}

        if(sectionMarker == -1)
            input = null;
        else {
            input = input.substring(sectionMarker + 1);// + 1 to remove '>'
            while(input.charAt(0) == ' '){// to remove spaces
                input = input.substring(1);
            }
        }
        for(String s : linesEffected){
            command.run(s, input);
        }

    }

    /*
    private String[] parseLineArgs(String input){
        String temp = input.substring(0, input.indexOf('>'));
        return temp.split(" ");
    }*/

    private Command findCommand(String commandName)throws CommandNotFoundException {
        for (Command c : comList) {
            if (c.getName().equals(commandName)){
                return c;
            }
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
