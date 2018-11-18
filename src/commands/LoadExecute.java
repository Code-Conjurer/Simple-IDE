package commands;

import Exceptions.CommandNotFoundException;
import models.SingleArgCommand;
import models.CommandInterpreter;
import models.Log;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoadExecute extends SingleArgCommand {

    public LoadExecute(){
        super("loadexecute");
    }

    //TODO: make execute change the title of log
    //TODO: remove new CommandInterpreter
    @Override
    public void execute(Log log, String fileLoc){
        CommandInterpreter commandInterpreter = new CommandInterpreter();

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
                commandInterpreter.handleCommand(log, iter.next());
            }
        }catch (CommandNotFoundException e){
            e.printStackTrace();
        }

    }
}
