package unnamed;

import Exceptions.CommandNotFoundException;

import java.util.Scanner;

public class ProgramLoop{

    private Log log;
    private Scanner inputScanner;
    private CommandInterpreter comHam;

    public ProgramLoop() {
        log = new Log("new log");
        comHam = new CommandInterpreter(log);
        inputScanner = new Scanner(System.in);
    }

    public void run(){
        boolean running = true;
        System.out.println("~~ " + log.getTitle()  + " ~~");
        while(running){
            running = handleInput();
            log.printLog();
        }
    }

    //TODO: Allow for different command formats (``~ # effects) (``~ <# # #> effects) (``~ effects) (``~ #)
    private boolean handleInput(){
        String input = inputScanner.nextLine();
        if(input.toLowerCase().equals("``quit"))
            return false;

        if (input.length() > 2 && input.substring(0, 2).equals("``") && !input.contains(" ")) {
            input += " ";

            System.out.println("~~Enter Line Number~~");
            input += inputScanner.nextLine() + " ";

            System.out.println("~~Enter Effects~~");
            input += inputScanner.nextLine() + " ";
        }

        try {
            comHam.handleCommand(input);
        }catch(CommandNotFoundException e){
            System.out.println("~~Command not Found~~");
        }
        return true;
    }

}
