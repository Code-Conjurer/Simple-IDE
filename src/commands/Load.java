package commands;

import models.Command;
import unnamed.Log;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Load implements Command{
    Log log;
    String name;

    public Load(Log log){
        this.log = log;
        name = "load";
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

    @Override
    public String getName() {
        return name;
    }
}
