package commands;

import unnamed.Log;

import java.util.Scanner;

public class Write extends LogCommand{

    public Write(Log log){
        super.log = log;
        super.name = "write";
    }

    @Override
    public void run(int lineNumber, String input){
        log.addLine(input);
    }

}
