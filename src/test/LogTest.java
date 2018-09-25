package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unnamed.Log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class LogTest {

    Log log;
    final int TEST_LIST_SIZE = 5;

    @BeforeEach
    public void setUp(){
        log = new Log("Log's Title");
    }

    @Test void testAddLineFirst(){
        log.addLine("new line");
        assertEquals(1, log.getNumberOfLines());
    }

    @Test
    public void testAddLineMultiple() {
        assertEquals(0, log.getNumberOfLines());
        for (int i = 0; i < TEST_LIST_SIZE; i++) {
            log.addLine("new line");
            assertEquals(i + 1, log.getNumberOfLines());
        }
    }

    @Test
    public void testAddLineNull(){
        log = new Log("title");
        log.addLine(null);
        assertTrue(log.getLine(0).equals(""));

    }

    @Test
    public void testChangeLineFirst(){
        log.addLine("first line");
        log.changeLine(0, "new first line");
        assertTrue(log.getLine(0).equals("new first line"));
    }

    @Test
    public void testChangeLineMiddle(){
        setupLogWithValues();
        log.changeLine(TEST_LIST_SIZE/2, "changed line");


    }

    @Test
    public void testChangeLineLast(){
        setupLogWithValues();
        log.changeLine(TEST_LIST_SIZE - 1, "changed line");
        assertTrue(log.getLine(TEST_LIST_SIZE - 1).equals("changed line"));
    }

    @Test
    public void testChangeLineNull(){
        log.addLine("first line");
        log.changeLine(0, null);
        assertTrue(log.getLine(0).equals(""));
    }

    @Test
    public void testRemoveLineFirst(){
        log.addLine("new Line");
        log.removeLine(0);
        assertEquals(0, log.getNumberOfLines());
    }

    @Test
    public void testRemoveLineMiddle(){
        log.addLine("1st line");
        log.addLine("2nd line");
        log.addLine("3rd line");
        log.removeLine(1);
        assertTrue(log.getLine(TEST_LIST_SIZE - 1).equals("3rd line"));
    }

    @Test
    public void testRemoveLineLast(){
        setupLogWithValues();
        log.addLine("last line");
        log.removeLine(TEST_LIST_SIZE);
        assertFalse(log.getLine(TEST_LIST_SIZE - 1).equals("last line"));

    }
    private void setupLogWithValues(){
        log = new Log("title");
        //Setup log to have TEST_LIST_SIZE number of lines
        for(int i = 0; i < TEST_LIST_SIZE; i++){
            log.addLine("new Line : " + i);
        }
    }


}
