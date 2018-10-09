package models;

import models.Command;
import unnamed.Log;

public abstract class LogCommand extends Command {

    protected Log log;

    public LogCommand(Log log, String name){
        super(name);
        this.log = log;
    }
   // public void input(String in){
        //stub
    //}

    //@Override
    public String prompt(){
        return "Command: " + name;
    }


}
