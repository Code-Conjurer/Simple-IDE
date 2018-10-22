package commands;

import models.LogCommand;
import models.SingleArgCommand;
import unnamed.Log;

import javax.tools.JavaCompiler;
import java.io.PrintWriter;

public class Compile extends SingleArgCommand {

    private PrintWriter pr;

    public Compile(Log log) {
        super(log, "compile");
    }


        //TODO: handle java.exe being in other locations, and of other versions
    public void run (String input){
            /////////////////////////////////////////////TODO:allow blank input for unsaved log
        try {
            Process p = Runtime.getRuntime().exec("cmd.exe /c start dir");

                //String[] cmdCommands = {"cmd.exe","/c","start","cd C:\\Users\\matt\\Desktop\\Git Repos",
                //"set path=%path%;C:\\Program Files\\Java\\jdk1.8.0_181\\bin"};
                //Process p = Runtime.getRuntime().exec(cmdCommands);

                //Runtime r = Runtime.getRuntime();
                //r.exec("cmd.exe /c start dir");
                //r.exec("cd src\\ui");

            /*
            pr = new PrintWriter(new OutputStreamWriter(p.getOutputStream()));
            pr.write("cd src\\ui");
            pr.write("javac Initialize.java");
            pr.close();*/
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
