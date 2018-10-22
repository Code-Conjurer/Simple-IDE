package commands;

import models.LineCommand;
import models.LogCommand;
import unnamed.Log;

public class Search extends LineCommand {

    public Search(Log log){
        super(log, "search");
    }

    @Override
    public void run(int lineNumber, String input) {

    }

}
