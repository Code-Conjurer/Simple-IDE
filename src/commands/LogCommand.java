package commands;

import models.Command;
import unnamed.Log;

public abstract class LogCommand implements Command {

    protected Log log;
    protected String name;

    public void input(String in){
        //stub
    }

    //@Override
    public String prompt(){
        return "Command: " + name;
    }

    @Override
    public String getName() {
        return name;
    }
}
