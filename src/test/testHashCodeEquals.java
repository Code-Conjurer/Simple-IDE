package test;

import commands.Write;
import models.Command;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import models.Log;

import java.util.HashMap;

public class testHashCodeEquals {

    Command writeCommand;
    Command newWriteCommand;

    @BeforeEach
    public void beforeEach(){
        writeCommand = new Write(new Log("title"));
        newWriteCommand = new Write(new Log("title"));
    }

    @Test
    public void testEqual(){
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
