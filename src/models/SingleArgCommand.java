package models;

public abstract class SingleArgCommand extends LogCommand {

    public SingleArgCommand(Log log, String name) {
        super(log, name);
    }

    @Override
    public void execute(String... args) {
        assert(args.length == 1);
        execute(args[0]);
    }

    abstract public void execute(String arg);

}
