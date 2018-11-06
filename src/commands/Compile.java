package commands;

import models.SingleArgCommand;
import unnamed.Log;

import javax.tools.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Compile extends SingleArgCommand {

    private JavaCompiler compiler;
    private StandardJavaFileManager fileManager;

    public Compile(Log log) {
        super(log, "compile");
        compiler = ToolProvider.getSystemJavaCompiler(); //gets java compiler, returns null otherwise (only having the JRE will return null)
        fileManager = compiler.getStandardFileManager(null, null, null);
        /*local is a geographic region or language ie: CANADA,JAPAN,ITALIAN.
          the file manager is an object
         */
    }

    /*
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
    public void run(String input) {

        try {
            setupCompilerAndRun(input);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    private URI findFileURI(String input) {
        return Paths.get(input).toUri();
    }

    private void setupCompilerAndRun(String fileName) {

        SourceFile source = new SourceFile(new File(fileName));
        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(source);

        Writer output = null;

        try {
            output = new PrintWriter("outputFile");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        JavaCompiler.CompilationTask compilationTask = compiler.getTask(
                output,
                fileManager,
                null,
                null,
                null,
                compilationUnits);
        compilationTask.call();

    }

    private class SourceFile extends SimpleJavaFileObject{

        private String code;

        public SourceFile(File file){
            super(file.toURI(), Kind.SOURCE);

            //QUICK HACK=------------------------------
            code ="";
            for(String s : log.getData())
                code += s;

        }

        @Override
        public CharSequence getCharContent(final boolean ignoreEncodingErrors) throws UnsupportedOperationException {
            return code;
        }
    }

}
