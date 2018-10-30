package commands;

import models.SingleArgCommand;
import unnamed.Log;

import javax.tools.*;
import java.io.File;
import java.net.URI;
import java.nio.file.Paths;
import java.util.Arrays;

public class Compile extends SingleArgCommand {

    public Compile(Log log) {
        super(log, "compile");
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
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler(); //gets java compiler, returns null otherwise (only having the JRE will return null)
        StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
        /*local is a geographic region or language ie: CANADA,JAPAN,ITALIAN.
          the file manager is an object
         */

        SourceFile source = new SourceFile(new File(fileName));
        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(source);

        JavaCompiler.CompilationTask compilationTask = compiler.getTask(
                null,
                fileManager,
                null,
                null,
                null,
                compilationUnits);
        compilationTask.call();



    }
    /*
    private String makeJavaFileString(){
        String stringFile = "";
        for(int i = 0; i < super.log.getNumberOfLines(); i++){
            stringFile += super.log.getLine(i);
        }
        return stringFile;
    }*/

    /*
    private void initalizeCompiler(URI uri)throws SecurityException {
        //compile.run(null, null, "HelloWorld.java");
        //JavaFileObject javaFile = new SimpleJavaFileObject(uri, JavaFileObject.Kind.SOURCE){};//since SimpleJavaFileObject is protected, we need to make it a class (via lambda)
        //ForwardingFileObject javaFileManager = new ForwardingJavaFileManager<ClassJavaFileObject>()


    }*/

    private class SourceFile extends SimpleJavaFileObject{

        private final CharSequence source;

        public SourceFile(File file){
            super(file.toURI(), Kind.SOURCE);
        }

        @Override
        public CharSequence getCharContent(final boolean ignoreEncodingErrors)
                throws UnsupportedOperationException {
            if (source == null)
                throw new UnsupportedOperationException("getCharContent()");
            return source;
        }
    }

}
