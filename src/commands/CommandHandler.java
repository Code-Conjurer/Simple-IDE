package commands;

import unnamed.Log;

public class CommandHandler {
    Log log;
    LogCommand[] comList;
    private int delete, edit, read, search, write;

    //TODO: implment a better way of creating/accessing commands (better data structure)
    public CommandHandler(Log log){
        delete = 0;
        edit = 1;
        read = 2;
        search = 3;
        write = 4;

        comList = new LogCommand[5];
        comList[delete] = new Delete(log);
        comList[edit] = new Edit(log);
        comList[read] = new Read(log);
        comList[search] = new Search(log);
        comList[write] = new Write(log);
    }


    //TODO: Separate into private methods
    //TODO: remove magic numbers
    //TODO: test unknown command
    //TODO: use exceptions
    //TODO: handle invalid input
    private void handleCommand(String input) {
        //input = input.trim();
        String commandName;
        Command command = null;
        int sectionMarker;
        String[] linesEffected;

        if (!input.substring(0, 2).equals("``")) {
            comList[write].run(-1, input);
            return;
        }

        if (!input.contains(" ")) {
            System.out.println("~~Invalid Input~~");
            return;
        }

        sectionMarker = input.lastIndexOf(" ");
        commandName = input.substring(2, sectionMarker).toLowerCase();
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
            sectionMarker = input.charAt('>');
            if (sectionMarker == -1) {//REMARK: .charAt() returns -1 if char cannot be found
                System.out.println("~~ '>' not found in range~~");
                return;
            } else {
                linesEffected = input.split(" ", sectionMarker);
            }
        } else {
            linesEffected = new String[1];
            sectionMarker = input.indexOf(' ');
            linesEffected[0] = input.substring(0, sectionMarker);
        }

        input = input.substring(sectionMarker + 1);
        for(String s : linesEffected){
            command.run(Integer.getInteger(s), input);
        }



        /*
        logCom.run();
        while(logCom.getWaiting()){
            logCom.input(sc.nextLine);
            logCom.run();
        }
        */
    }

}
