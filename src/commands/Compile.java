package commands;

import models.LogCommand;
import unnamed.Log;

import java.io.PrintWriter;

public class Compile extends LogCommand {

    private PrintWriter pr;

    public Compile(Log log){
        super(log, "compile");
    }

    @Override
    public void run(int lineNumber, String input){
            /////////////////////////////////////////////TODO:allow blank input for unsaved log
        try {
            Process p = Runtime.getRuntime().exec("cmd.exe /c start dir");
            //Runtime r = Runtime.getRuntime();
            //r.exec("cmd.exe /c start dir");
            //r.exec("cd src\\ui");

            /*
            pr = new PrintWriter(new OutputStreamWriter(p.getOutputStream()));
            pr.write("cd src\\ui");
            pr.write("javac Initialize.java");
            pr.close();*/
        }catch (Exception e){
            System.out.println(e);
        }

    }

}
