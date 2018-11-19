package models;

import Exceptions.CommandNotFoundException;

import java.util.Scanner;

public class InputHandler {

    private Scanner inputScanner;
    private CommandInterpreter commandInterpreter;

    public InputHandler(CommandInterpreter commandInterpreter){
        this.commandInterpreter = commandInterpreter;
        inputScanner = new Scanner(System.in);
    }

    public boolean handleInput(Log log) {
        String input = inputScanner.nextLine();
        if (input.toLowerCase().equals("``quit"))
            return false;
        try {
            if (input.length() < 3 || !input.substring(0, 2).equals("``")) {
                commandInterpreter.handleCommand(log,"``write " + input);
            }else if(input.substring(0, 3).equals("\\``")){
                commandInterpreter.handleCommand(log,"``write " + input.substring(1));
            } else
                commandInterpreter.handleCommand(log, input);
        } catch (CommandNotFoundException e) {
            System.out.println("~~Command not Found~~");
        }
        return true;
    }
}
