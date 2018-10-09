package commands;

import models.Command;
import models.LogCommand;
import unnamed.Log;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Load extends LogCommand {

    public Load(Log log){
        super(log, "load");
    }

    //TODO: make run change the title of log
    @Override
    public void run(int vestigial, String fileLoc){
        try{
            log.LoadData(Files.readAllLines(Paths.get(fileLoc)));
        }catch(Exception e){
            System.out.println(e);
            return;
        }
    }

}
