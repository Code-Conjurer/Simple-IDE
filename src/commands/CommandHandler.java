package commands;

import models.Command;
import unnamed.Log;

public class CommandHandler {
    Log log;
    Command[] comList;//TODO: refactor, Command might have parameters (int, String), (CAN BE REPLACED BY LogCommand)
    private int delete, edit, read, search, write, save, load;

    //TODO: implment a better way of creating/accessing commands (better data structure)
    public CommandHandler(Log log){
        delete = 0;
        edit = 1;
        read = 2;
        search = 3;
        write = 4;
        save = 5;
        load = 6;

        comList = new Command[7];
        comList[delete] = new Delete(log);
        comList[edit] = new Edit(log);
        comList[read] = new Read(log);
        comList[search] = new Search(log);
        comList[write] = new Write(log);
        comList[save] = new Save(log);
        comList[load] = new Load(log);
    }


    //TODO: Separate into private methods
    //TODO: remove magic numbers
    //TODO: test unknown command
    //TODO: use exceptions
    //TODO: handle invalid input
    public void handleCommand(String input) {
        String commandName;
        Command command = null;
        int sectionMarker;
        String[] linesEffected;

        if (input.length() < 2 || !input.substring(0, 2).equals("``")) {
            comList[write].run(-1, input);
            return;
        }

        if (!input.contains(" ")) {
            System.out.println("~~Invalid Input~~");
            return;
        }

        sectionMarker = input.indexOf(" ");
        commandName = input.substring(2, sectionMarker).toLowerCase();
        System.out.println(commandName);
        for (Command c : comList) {
            if (c.getName().equals(commandName)){
                command = c;
                break;
            }
        }

        if (command == null) {
            System.out.println("~~Command Not Found~~");
            return;
        }

        //REMARK: input without + 1 will have " " at char 0
        input = input.substring(sectionMarker + 1);
        if (input.charAt(0) == '<') {
            input = input.substring(1);//removes '<' from string
            sectionMarker = input.indexOf('>');//removes '>' from string
            if (sectionMarker == -1) {//REMARK: .indexOf() returns -1 if char cannot be found
                System.out.println("~~ '>' not found in range~~");
                return;
            } else {
                linesEffected = parseLineArgs(input);
            }
        } else {
            linesEffected = new String[1];
            sectionMarker = input.indexOf(' ');

            if(sectionMarker == -1)
                linesEffected[0] = input;
            else
                linesEffected[0] = input.substring(0, sectionMarker);
        }

        if(sectionMarker == -1)
            input = null;
        else {
            input = input.substring(sectionMarker + 1);// + 1 to remove '>'
            while(input.charAt(0) == ' '){// to remove spaces
                input = input.substring(1);
            }
        }
        for(String s : linesEffected){
            command.run(Integer.parseInt(s), input);
        }

    }

    private String[] parseLineArgs(String input){
        String temp = input.substring(0, input.indexOf('>'));
        return temp.split(" ");
    }

}
