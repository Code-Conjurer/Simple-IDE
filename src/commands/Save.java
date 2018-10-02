package commands;

import models.Command;
import models.Saveable;
import unnamed.Log;

import java.io.IOException;
import java.io.PrintWriter;

public class Save implements Command, Saveable{
    Log log;
    String name;
    PrintWriter writer;

    public Save(Log log) {
        this.log = log;
        name = "save";
    }

    @Override
    public void run(int vestigial, String fileLoc){
        try{
            writer = makeWriter(fileLoc);
        }catch(Exception e){
            writer.close();
            System.out.println(e);
            return;
        }

        write(writer);
        writer.close();
    }

    @Override
    public String getName() {
        return name;
    }


    public PrintWriter makeWriter(String fileLoc) throws IOException{
        return new PrintWriter(fileLoc);
    }

    @Override
    public void write(PrintWriter writer) {
        for(int i = 0; i < log.getNumberOfLines(); i++){
            writer.println(log.getLine(i));
        }
    }
}
