package commands;

import unnamed.Log;

import java.util.Scanner;

public class Edit extends LogCommand{


    public Edit(Log log){
        super.log = log;
        super.name = "edit";
    }

    @Override
    public void run(int lineNumber, String input) {

    }

}
