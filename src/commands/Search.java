package commands;

import models.LogCommand;
import unnamed.Log;

public class Search extends LogCommand {

    public Search(Log log){
        super(log, "search");
    }

    @Override
    public void run(int lineNumber, String input) {

    }

}
