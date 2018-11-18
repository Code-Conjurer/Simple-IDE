package models;

public abstract class LogCommand extends Command {

    protected Log log;

    public LogCommand(Log log, String name){
        super(name);
        this.log = log;
    }

}
