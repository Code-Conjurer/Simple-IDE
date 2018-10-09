package unnamed;

import commands.*;

import java.util.Scanner;

public class ProgramLoop{

    private Log log;
    private Scanner inputScanner;
    private CommandBundle comHam;

    public ProgramLoop() {
        log = new Log("new log");
        comHam = new CommandBundle(log);
        inputScanner = new Scanner(System.in);
    }

    public void run(){
        //String input = "";
        boolean running = true;
        System.out.println("~~ " + log.getTitle()  + " ~~");
        while(running){
            running = handleInput();

            log.printLog();
        }
    }

    //TODO: Allow for diffrent command formats (``~ # effects) (``~ <# # #> effects) (``~ effects) (``~ #)
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


        comHam.handleCommand(input);
        return true;
    }

}
