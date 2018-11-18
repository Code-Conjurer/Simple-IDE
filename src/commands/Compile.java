package commands;

import models.SingleArgCommand;
import models.Log;

import javax.tools.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Compile extends SingleArgCommand {

    private JavaCompiler compiler;
    private SimpleJavaFileManager fileManager;

    public Compile() {
        super("compile");
        compiler = ToolProvider.getSystemJavaCompiler(); //gets java compiler, returns null otherwise (only having the JRE will return null)
        fileManager = new SimpleJavaFileManager(compiler.getStandardFileManager(null, null, null));
    }

    /*
        public void execute (String input){
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
    @Override
    public void execute(Log log, String input) {

        try {
            setupCompilerAndRun(log, input);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    /*
    private URI findFileURI(String input) {
        return Paths.get(input).toUri();
    }*/

    private void setupCompilerAndRun(Log log, String fileName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        JavaFileObject source = new SourceFile(log, fileName);
        Iterable<? extends JavaFileObject> compilationUnits = Arrays.asList(source);

        /*riter output = null;

        try {
            output = new PrintWriter("outputFile");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/

        JavaCompiler.CompilationTask compilationTask = compiler.getTask(
                null,
                fileManager,
                null,
                null,
                null,
                compilationUnits);

        compilationTask.call();
        CompiledClassLoader classLoader = new CompiledClassLoader(fileManager.getGeneratedOutputFiles());

        //run -------------HACKY
        //The class name is hard coded as Main, Method is hard coded as main
        Class<?> mainClass = classLoader.findClass("Main"); //throws ClassNotFound
        Method mainMethod = mainClass.getMethod("main", String[].class); //throws NoSuchMethod
        mainMethod.invoke(null, new Object[]{null});
    }

    private class SourceFile extends SimpleJavaFileObject{

        private String code;

        public SourceFile(Log log, String fileName){
            super(URI.create("string://" + "/" + fileName), Kind.SOURCE);// "string://" creates the scheme for the uri

            //QUICK HACK=------------------------------
            code ="";
            for(String s : log.getData())
                code += s + "\n";
        }

        @Override
        public CharSequence getCharContent(final boolean ignoreEncodingErrors) throws UnsupportedOperationException {
            return code;
        }
    }

    //Code Below was inspired by https://gist.github.com/chrisvest/9873843
    //---------------------------------------------------------------------
    private static class ClassJavaFileObject extends SimpleJavaFileObject {
        private final ByteArrayOutputStream outputStream;
        private final String className;

        protected ClassJavaFileObject(String className, Kind kind) {
            super(URI.create("mem:///" + className.replace('.', '/') + kind.extension), kind);
            this.className = className;
            outputStream = new ByteArrayOutputStream();
        }

        @Override
        public OutputStream openOutputStream() throws IOException {
            return outputStream;
        }

        public byte[] getBytes() {
            return outputStream.toByteArray();
        }

        public String getClassName() {
            return className;
        }
    }

    private static class SimpleJavaFileManager extends ForwardingJavaFileManager {
        private final List<ClassJavaFileObject> outputFiles;

        protected SimpleJavaFileManager(JavaFileManager fileManager) {
            super(fileManager);
            outputFiles = new ArrayList<>();
        }

        @Override
        public JavaFileObject getJavaFileForOutput(Location location, String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
            ClassJavaFileObject file = new ClassJavaFileObject(className, kind);
            outputFiles.add(file);
            return file;
        }

        public List<ClassJavaFileObject> getGeneratedOutputFiles() {
            return outputFiles;
        }
    }

    private static class CompiledClassLoader extends ClassLoader {
        private final List<ClassJavaFileObject> files;

        private CompiledClassLoader(List<ClassJavaFileObject> files) {
            this.files = files;
        }

        @Override
        protected Class<?> findClass(String name) throws ClassNotFoundException {
            Iterator<ClassJavaFileObject> itr = files.iterator();
            while (itr.hasNext()) {
                ClassJavaFileObject file = itr.next();
                if (file.getClassName().equals(name)) {
                    itr.remove();
                    byte[] bytes = file.getBytes();
                    return super.defineClass(name, bytes, 0, bytes.length);
                }
            }
            return super.findClass(name);
        }
    }
}
