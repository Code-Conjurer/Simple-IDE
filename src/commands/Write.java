package commands;

import models.SingleArgCommand;
import models.Log;

public class Write extends SingleArgCommand {

    public Write(){
        super("write");
    }

    @Override
    public void execute(Log log, String input){
        log.addLine(input);
    }


}
