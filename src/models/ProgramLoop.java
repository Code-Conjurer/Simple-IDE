package models;


import Exceptions.CommandNotFoundException;
import ui.ConsoleDisplay;

import java.util.Observer;


public class ProgramLoop {

    private Log log;
    InputHandler inputHandler;
    private CommandInterpreter comInter;
    private Boolean running;

    public ProgramLoop() {
        //log = new Log("new log", false);
        log = new Log(new ConsoleDisplay(), "new log");
        Observer logObserver = new LogObserver();
        log.addObserver(logObserver);
        comInter = new CommandInterpreter();
        inputHandler = new InputHandler(comInter);
        running = true;
    }

    public void update(){
        inputHandler.handleInput(log);
    }

    public void run(){
        System.out.println("~~ " + log.getTitle()  + " ~~");
        while(running){
            running = inputHandler.handleInput(log);
            //log.printLog();
        }
    }

    /*
    private void handleInput(){
        String input = inputScanner.nextLine();
        if(input.toLowerCase().equals("``quit"))
            running = false;

        try {
            if(input.length() < 3 || !input.substring(0, 2).equals("``")) {
                comInter.handleCommand(log,"``write " + input);
            }else
                comInter.handleCommand(input);
        }catch(CommandNotFoundException e){
            System.out.println("~~Command not Found~~");
        }
    }*/

}
