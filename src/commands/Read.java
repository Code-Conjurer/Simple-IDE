package commands;

import models.LogCommand;
import unnamed.Log;

public class Read extends LogCommand {

    public Read(Log log) {
        super(log, "read");
    }

    @Override
    public void run(int lineNumber, String inputs) {

    }

}
