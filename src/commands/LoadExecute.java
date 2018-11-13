package commands;

import Exceptions.CommandNotFoundException;
import models.SingleArgCommand;
import unnamed.CommandInterpreter;
import unnamed.Log;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoadExecute extends SingleArgCommand {

    public LoadExecute(Log log){
        super(log, "loadexecute");
    }

    //TODO: make execute change the title of log
    @Override
    public void execute(String fileLoc){
        CommandInterpreter commandInterpreter = new CommandInterpreter(super.log);

        List<String> lines = new ArrayList<>();
        try{
            lines = Files.readAllLines(Paths.get(fileLoc));
        }catch(Exception e){
            System.out.println(e);
            return;
        }
            Iterator<String> iter = lines.iterator();
        try {
            while (iter.hasNext()) {
                commandInterpreter.handleCommand(iter.next());
            }
        }catch (CommandNotFoundException e){
            e.printStackTrace();
        }

    }
}
