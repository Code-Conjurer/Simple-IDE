package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unnamed.Log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LogTest {

    Log log;
    final int TEST_LIST_SIZE = 5;

    @BeforeEach
    public void setUp(){
        log = new Log("Log's Title");
    }

    @Test
    public void testAddLine(){
        assertEquals(0, log.getNumberOfLines());
        for(int i = 0; i < TEST_LIST_SIZE; i++) {
            log.addLine("new line");
            assertEquals(i + 1, log.getNumberOfLines());
        }

        //Test that adding a null lines adds empty a String
        log = new Log("title");
        log.addLine(null);
        assertTrue(log.getLine(0).equals(""));

    }

    @Test
    public void testChangeLine(){
        for(int i = 0; i < TEST_LIST_SIZE; i++){
            log.addLine("new Line : " + i);
            log.changeLine(i, "changed line : " + i);
            assertTrue( log.getLine(i).equals("changed line : " + i) );
        }
    }

    @Test
    public void testRemoveLine(){
        //Test that one line can be removed
        log.addLine("new Line");
        log.removeLine(0);
        assertEquals(0, log.getNumberOfLines());

        setupLogWithValues();

        //Test removing the first line
        log.removeLine(0);
        assertEquals(TEST_LIST_SIZE - 1, log.getNumberOfLines());

        setupLogWithValues();

        //Test removing a line in the middle
        log.removeLine(TEST_LIST_SIZE/2);
        assertEquals(TEST_LIST_SIZE - 1, log.getNumberOfLines());
        log.addLine("new line");//add a line back

        //Test removing lines from the end
        for(int i = TEST_LIST_SIZE - 1; i > 0 ; i--){
            assertEquals(log.getNumberOfLines(), i + 1);
            log.removeLine(i);
            assertEquals(log.getNumberOfLines(), i);
        }

        assertEquals(log.getNumberOfLines(), 1);
    }
    private void setupLogWithValues(){
        log = new Log("title");
        //Setup log to have TEST_LIST_SIZE number of lines
        for(int i = 0; i < TEST_LIST_SIZE; i++){
            log.addLine("new Line : " + i);
        }
    }


}
