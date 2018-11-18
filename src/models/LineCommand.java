package models;

public abstract class LineCommand extends LogCommand {


    public LineCommand(String name) {
        super(name);
    }

    @Override
    public void execute(Log log, String... args) {

        execute(log, Integer.parseInt(args[0]), args[1]);
    }


    abstract public void execute(Log log, int line, String arg);
}
