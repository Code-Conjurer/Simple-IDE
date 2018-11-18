package commands;

import models.SingleArgCommand;
import models.Log;

public class Write extends SingleArgCommand {

    public Write(Log log){
        super(log, "write");
    }

    public void execute(String input){
        log.addLine(input);
    }


}
