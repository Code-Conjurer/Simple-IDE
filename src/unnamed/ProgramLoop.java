package unnamed;

import Exceptions.CommandNotFoundException;
import commands.*;

import java.util.Scanner;

public class ProgramLoop{

    private Log log;
    private Scanner inputScanner;
    private CommandInterpreter comInter;
    private Boolean running;

    public ProgramLoop() {
        //log = new Log("new log", false);
        log = new Log("new log", this);
        comInter = new CommandInterpreter(log);
        inputScanner = new Scanner(System.in);
        running = true;
    }

    public void run(){
        System.out.println("~~ " + log.getTitle()  + " ~~");
        while(running){
            handleInput();
            log.printLog();
        }
    }

    //TODO: Allow for different command formats (``~ # effects) (``~ <# # #> effects) (``~ effects) (``~ #)
    private void handleInput(){
        String input = inputScanner.nextLine();
        if(input.toLowerCase().equals("``quit"))
            running = false;

        try {
            if(input.length() < 3 || !input.substring(0, 2).equals("``")) {
                comInter.handleCommand("``write " + input);
            }else
                comInter.handleCommand(input);
        }catch(CommandNotFoundException e){
            System.out.println("~~Command not Found~~");
        }
    }

}
