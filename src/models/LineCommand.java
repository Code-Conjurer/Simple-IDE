package models;

public abstract class LineCommand extends LogCommand {


    public LineCommand(Log log, String name) {
        super(log, name);
    }

    @Override
    public void execute(String... args) {

        execute(Integer.parseInt(args[0]), args[1]);
    }


    abstract public void execute(int line, String arg);
}
