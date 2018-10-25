package test;

import Exceptions.CommandNotFoundException;
import unnamed.CommandInterpreter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unnamed.Log;

import static org.junit.jupiter.api.Assertions.fail;

public class TestCommandNotFound {

    CommandInterpreter commandBundle;

    @BeforeEach
    public void init(){
        commandBundle = new CommandInterpreter(new Log("title"));
    }

    @Test
    public void TestExceptionThrown(){
        try{
            commandBundle.handleCommand("``write");
        }catch (CommandNotFoundException e){
            fail("Exception thrown");
        }
    }

    @Test
    public void TestExceptionNotThrown(){
        try{
            commandBundle.handleCommand("``commandThatDoesNotExist");
        }catch(CommandNotFoundException e) {
            fail("command thrown");
        }
    }

}
