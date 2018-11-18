package commands;

import models.Command;
import models.Log;

public class Print extends Command {

    public Print(){
        super("print");
    }

    @Override
    public void execute(Log log, String... args) {
        for(String s : args){
            System.out.print(s);
        }
    }
}
