package commands;

import models.Command;

public class Print extends Command {

    public Print(){
        super("print");
    }

    @Override
    public void execute(String... args) {
        for(String s : args){
            System.out.print(s);
        }
    }
}
