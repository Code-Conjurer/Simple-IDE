package commands;

import models.LogCommand;
import unnamed.Log;

public class Write extends LogCommand {

    public Write(Log log){
        super(log, "search");
    }

    @Override
    public void run(int lineNumber, String input){
        log.addLine(input);
    }

}
