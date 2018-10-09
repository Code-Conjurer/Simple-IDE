package commands;

import models.LogCommand;
import unnamed.Log;

public class Edit extends LogCommand {


    public Edit(Log log){
        super(log, "edit");
    }

    @Override
    public void run(int lineNumber, String input) {
        log.changeLine(lineNumber, input);
    }

}
