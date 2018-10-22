package models;

import unnamed.Log;

public abstract class LineCommand extends LogCommand {


    public LineCommand(Log log, String name) {
        super(log, name);
    }

    @Override
    public void run(String... args) {

        run(Integer.parseInt(args[0]), args[1]);
    }


    abstract public void run(int line, String arg);
}
