package commands;

import models.LineCommand;
import models.Log;

public class Edit extends LineCommand {


    public Edit(){
        super("edit");
    }

    @Override
    public void execute(Log log, int lineNumber, String input) {
        log.changeLine(lineNumber, input);
    }

}
