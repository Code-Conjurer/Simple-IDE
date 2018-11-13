package commands;

import models.LogCommand;
import models.SingleArgCommand;
import unnamed.Log;

public class Read extends SingleArgCommand {

    public Read(Log log) {
        super(log, "read");
    }

    @Override
    public void execute(String input) {

    }

}
