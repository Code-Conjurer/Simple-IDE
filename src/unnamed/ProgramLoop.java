package unnamed;

import commands.*;

import java.util.Scanner;

public class ProgramLoop {

    private Log log;
    private Scanner inputScanner;
    private CommandHandler comHam;

    public ProgramLoop() {
        log = new Log("new log");
        comHam = new CommandHandler(log);
        inputScanner = new Scanner(System.in);
    }

    public void run(){
        //String input = "";
        System.out.println("~~ " + log.getTitle()  + " ~~");
        while(true){
            handleInput();

            log.printLog();
        }
    }

    //TODO: Allow for diffrent command formats (``~ # effects) (``~ <# # #> effects) (``~ effects) (``~ #)
    private void handleInput(){
        String input = inputScanner.nextLine();
        if (input.length() > 2 && input.substring(0, 2).equals("``") && !input.contains(" ")) {
            input += " ";

            System.out.println("~~Enter Line Number~~");
            input += inputScanner.nextLine() + " ";

            System.out.println("~~Enter Effects~~");
            input += inputScanner.nextLine() + " ";
            }


        comHam.handleCommand(input);



    }

}
