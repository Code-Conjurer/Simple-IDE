package commands;

import models.LogCommand;
import unnamed.Log;

import java.io.IOException;
import java.io.PrintWriter;

public class Save extends LogCommand {
    PrintWriter writer;

    public Save(Log log) {
        super(log, "save");
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

    public PrintWriter makeWriter(String fileLoc) throws IOException{
        return new PrintWriter(fileLoc);
    }

    public void write(PrintWriter writer) {
        for(int i = 0; i < log.getNumberOfLines(); i++){
            writer.println(log.getLine(i));
        }
    }
}