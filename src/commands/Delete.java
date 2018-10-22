package commands;

import models.LineCommand;
import models.LogCommand;
import unnamed.Log;

public class Delete extends LineCommand {


    public Delete(Log log) {
        super(log, "delete");
    }

    @Override
    public void run(int lineNumber, String input){
        log.removeLine(lineNumber);
    }

}

