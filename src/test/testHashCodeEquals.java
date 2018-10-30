package test;

import commands.Write;
import models.Command;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unnamed.Log;
import unnamed.ProgramLoop;

import java.util.HashMap;

public class testHashCodeEquals {

    Command writeCommand;
    Command newWriteCommand;

    @BeforeEach
    public void beforeEach(){
        writeCommand = new Write(new Log("title", new ProgramLoop()));
    }

    @Test
    public void testEqual(){
        newWriteCommand = new Write(new Log("title", new ProgramLoop()));
        assertTrue(writeCommand.equals(newWriteCommand));
    }

    @Test
    public void testHashCode(){
        HashMap<Command, String> map = new HashMap<>();
        map.put(writeCommand, "not null");
        String s = map.get(newWriteCommand);
        assertFalse(s == null);
    }


}
