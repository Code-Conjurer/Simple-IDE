package commands;

import unnamed.Log;

public class Search extends LogCommand{

    public Search(Log log){
        super.log = log;
        super.name = "search";
    }

    @Override
    public void run(int lineNumber, String input) {

    }

}
