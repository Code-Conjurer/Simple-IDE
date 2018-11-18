package models;

public abstract class SingleArgCommand extends LogCommand {

    public SingleArgCommand(String name) {
        super(name);
    }

    @Override
    public void execute(Log log, String... args) {
        assert(args.length == 1);
        execute(log, args[0]);
    }

    abstract public void execute(Log log, String arg);

}
