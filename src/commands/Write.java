package commands;

import models.LogCommand;
import models.SingleArgCommand;
import unnamed.Log;

public class Write extends SingleArgCommand {

    public Write(Log log){
        super(log, "write");
    }

    public void execute(String input){
        log.addLine(input);
    }


}
