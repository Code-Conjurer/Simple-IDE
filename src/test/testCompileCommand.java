package test;

import commands.Compile;
import models.Command;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unnamed.Log;
import unnamed.ProgramLoop;

public class testCompileCommand {

    Log log;
    Command compile;

    @BeforeEach
    public void setup(){
        compile = new Compile(new Log("title", new ProgramLoop()));
    }

    @Test
    public void testCompileFromFile(){
        compile.run("Main");
    }
}
