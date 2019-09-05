package commands;

import ui.ConsolePrinter;
import models.SingleArgCommand;
import models.Log;

import javax.tools.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.util.*;

public class Compile extends SingleArgCommand {

    private JavaCompiler compiler;
    private SimpleJavaFileManager fileManager;
    private String program;
    private String mainClassName = "Main";
    private String mainMethodName = "main";
    private Writer writer;
    //private OutputStream outputStream;

    public Compile() {
        super("compile");
        compiler = ToolProvider.getSystemJavaCompiler(); //gets java compiler, returns null otherwise (only having the JRE will return null)
        fileManager = new SimpleJavaFileManager(compiler.getStandardFileManager(null, null, null));
    }

    //TODO: implement pattern matching for class and method (make entire program sing string then check class/methods)
    @Override
    public void execute(Log log, String input) {
        List<String> logData = log.getData();
        program = "";
        mainClassName = input;

        log.clearConsole();
        for(String s : logData){
            program += s +"\n";
        }
        try {
            setupCompilerAndRun(mainClassName);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    private void printToConsole(Writer writer){

    }

    private void setupCompilerAndRun(String name) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        JavaFileObject compilationUnit =
                new StringJavaFileObject(name, program);

        JavaCompiler.CompilationTask compilationTask = compiler.getTask(
                null, fileManager, null, null, null, Arrays.asList(compilationUnit));

        compilationTask.call();

        CompiledClassLoader classLoader =
                new CompiledClassLoader(fileManager.getGeneratedOutputFiles());

        Class<?> mainClass = classLoader.loadClass(mainClassName);
        Method main = mainClass.getMethod(mainMethodName, String[].class);
        main.invoke(null, new Object[]{null});
    }

    private static class StringJavaFileObject extends SimpleJavaFileObject {
        private final String code;

        public StringJavaFileObject(String name, String code) {
            super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension),
                    Kind.SOURCE);
            this.code = code;
        }

        @Override
        public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
            return code;
        }
    }

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
            outputFiles = new ArrayList<ClassJavaFileObject>();
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