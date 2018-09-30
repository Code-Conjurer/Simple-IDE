package commands;

import unnamed.Log;

public class Read extends LogCommand{

    public Read(Log log) {
        super.log = log;
        super.name = "read";
    }

    @Override
    public void run(int lineNumber, String inputs) {

    }

}
