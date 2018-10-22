package commands;

import models.Command;
import models.LogCommand;
import models.SingleArgCommand;
import unnamed.Log;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Load extends SingleArgCommand{

    public Load(Log log){
        super(log, "load");
    }

    //TODO: make run change the title of log
    @Override
    public void run(String fileLoc){
        try{
            log.LoadData(Files.readAllLines(Paths.get(fileLoc)));
        }catch(Exception e){
            System.out.println(e);
            return;
        }
    }

}
