package models;

import unnamed.Log;

public abstract class SingleArgCommand extends LogCommand {

    public SingleArgCommand(Log log, String name) {
        super(log, name);
    }

    @Override
    public void run(String... args) {
        assert(args.length == 1);
        run(args[0]);
    }

    abstract public void run(String arg);

}
