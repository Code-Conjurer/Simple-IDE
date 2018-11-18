package commands;

import models.SingleArgCommand;
import models.Log;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Load extends SingleArgCommand{

    public Load(){
        super("load");
    }

    //TODO: make execute change the title of log
    @Override
    public void execute(Log log, String fileLoc){
        try{
            log.LoadData(Files.readAllLines(Paths.get(fileLoc)));
        }catch(Exception e){
            System.out.println(e);
            return;
        }
    }

}
