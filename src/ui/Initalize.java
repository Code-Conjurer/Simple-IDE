package ui;

import unnamed.CommandHandler;
import unnamed.Log;

import java.util.Scanner;

public class Initalize{

    public Initalize(){
        Log log = new Log("new log");
        Scanner sc = new Scanner(System.in);
        CommandHandler com = new CommandHandler(sc, log);
        String currentLine = "";

        System.out.println("type `` to enter a command");
        System.out.println(log.getTitle());
        while(true){
            currentLine = sc.next();
            if(currentLine.equals("``")) {
                System.out.println("Enter Command: ");
                if(com.handleCommand(sc.next()))
                    break;
            }else{
                log.addLine(currentLine);
            }

            log.printLog();
        }
    }

    public static void main(String[] args){
        new Initalize();
    }
}
