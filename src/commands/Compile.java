package commands;

import models.SingleArgCommand;
import unnamed.Log;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;
import java.io.File;

public abstract class Compile extends SingleArgCommand {

    public Compile(Log log) {
        super(log, "compileLog");
    }

/*
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
            pr.close();*//*
        } catch (Exception e) {
            System.out.println(e);
        }

    }*/
    public void run(String input){

        try{

        }catch (SecurityException e){

        }
    }



    /*
    private String makeJavaFileString(){
        String stringFile = "";
        for(int i = 0; i < super.log.getNumberOfLines(); i++){
            stringFile += super.log.getLine(i);
        }
        return stringFile;
    }*/

    private void initalizeCompiler()throws SecurityException {

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler(); //gets java compiler, returns null otherwise
        //JavaFileObject javaFile = new SimpleJavaFileObject();

    }

}
