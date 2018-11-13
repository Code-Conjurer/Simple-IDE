package commands;

import models.LineCommand;
import unnamed.Log;

public class Edit extends LineCommand {


    public Edit(Log log){
        super(log, "edit");
    }

    @Override
    public void execute(int lineNumber, String input) {
        log.changeLine(lineNumber, input);
    }

}
