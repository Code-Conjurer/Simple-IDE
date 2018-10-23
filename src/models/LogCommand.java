package models;

import models.Command;
import unnamed.Log;

public abstract class LogCommand extends Command {

    protected Log log;

    public LogCommand(Log log, String name){
        super(name);
        this.log = log;
    }

}
