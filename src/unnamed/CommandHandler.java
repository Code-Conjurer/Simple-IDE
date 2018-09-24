package unnamed;

import java.util.Scanner;

public class CommandHandler{
    String command;
    Scanner sc;
    Log log;

    public CommandHandler(Scanner sc, Log log){
        this.sc = sc;
        this.log = log;
        command = "write";
    }

    public boolean handleCommand(String command){
        command = command.toLowerCase();
        this.command = command;
        switch (command) {
            case "write":
                write();
                break;
            case "edit":
                edit();
                break;
            case "quit":
                return true;
            default:
                System.out.println("~~invalid command~~");
        }
        return false;
    }

    private void edit() {
        int lineIndex;
        System.out.println("~~Enter Line Number To Edit~~");
        lineIndex = sc.nextInt();
        log.printLine(sc.nextInt());
    }

    private void write() {
    }
    
    public String getCommand() {
        return command; 
    }
}
