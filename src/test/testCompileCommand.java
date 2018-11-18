package test;

import commands.Compile;
import commands.Write;
import models.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import models.Log;

public class testCompileCommand {

    Log log;
    Command compile;
    Command write;

    @BeforeEach
    public void setup(){
        compile = new Compile(new Log("title"));
        write = new Write(new Log("title"));
    }

    @Test
    public void testCompileFromFile(){
        write.execute("public class Main{");
        write.execute("public void main(String[] args){");
        write.execute("System.out.println(\"wowza\");");
        write.execute("}");
        write.execute("}");
        compile.execute("Main");
    }
}
