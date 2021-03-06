package commands;

import models.SingleArgCommand;
import models.Log;

import java.io.IOException;
import java.io.PrintWriter;

public class Save extends SingleArgCommand {
    PrintWriter writer;

    public Save() {
        super("save");
    }

    @Override
    public void execute(Log log, String fileLoc){
        try{
            writer = makeWriter(fileLoc);
        }catch(Exception e){
            writer.close();
            System.out.println(e);
            return;
        }

        write(log, writer);
        writer.close();
    }

    public PrintWriter makeWriter(String fileLoc) throws IOException{
        return new PrintWriter(fileLoc);
    }

    public void write(Log log, PrintWriter writer) {
        for(int i = 0; i < log.getNumberOfLines(); i++){
            writer.println(log.getLine(i));
        }
    }
}
