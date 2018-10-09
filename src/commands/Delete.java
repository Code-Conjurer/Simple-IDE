package commands;

import models.LogCommand;
import unnamed.Log;

public class Delete extends LogCommand {


    public Delete(Log log) {
        super(log, "delete");
    }

    @Override
    public void run(int lineNumber, String input){
        log.removeLine(lineNumber);
    }

}

