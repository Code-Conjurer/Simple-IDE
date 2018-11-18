package commands;

import models.LineCommand;
import models.Log;

public class Delete extends LineCommand {


    public Delete() {
        super("delete");
    }

    @Override
    public void execute(Log log, int lineNumber, String input){
        log.removeLine(lineNumber);
    }

}

