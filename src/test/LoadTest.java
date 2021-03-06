/*package test;

import Exceptions.CommandNotFoundException;
import unnamed.CommandInterpreter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import unnamed.Log;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoadTest {

    Log log;
    ArrayList<String> testList;
    ArrayList<String> compareList;

    @BeforeEach
    public void runBefore(){
        log = new Log("somename");
        testList = new ArrayList<>();
    }

    private void compare(){
        for(int i = 0; i < testList.size(); i++){
            assertTrue(testList.get(i).equals(log.getLine(i)));
        }
    }

    @Test
    public void runTest(){
        String fileName = "runTest";
        testList.add("1");
        testList.add("2");
        testList.add("3");
        log.LoadData(testList);

        try {
            new CommandInterpreter(log).handleCommand("``save -1 " + fileName);
        } catch (CommandNotFoundException e) {
            e.printStackTrace();
        }

        log = new Log("new name");
        try {
            new CommandInterpreter(log).handleCommand("``load -1 " + fileName);
        } catch (CommandNotFoundException e) {
            e.printStackTrace();
        }
        compare();

    }

    @Test
    public void runTestEmptySpace(){
        String fileName = "runTestEmptySpace";
        testList.add("");
        testList.add("2");
        testList.add("3");
        log.LoadData(testList);

        try {
            new CommandInterpreter(log).handleCommand("``save -1 " + fileName);
        } catch (CommandNotFoundException e) {
            e.printStackTrace();
        }

        log = new Log("new name");
        try {
            new CommandInterpreter(log).handleCommand("``load -1 " + fileName);
        } catch (CommandNotFoundException e) {
            e.printStackTrace();
        }
        compare();
    }

    @Test
    public void runTestLarge(){
        String fileName = "runTestLarge";

        for(int i = 0; i < 10000; i++){
            testList.add(Integer.toString(i));
        }
        log.LoadData(testList);

        try {
            new CommandInterpreter(log).handleCommand("``save -1 " + fileName);
        } catch (CommandNotFoundException e) {
            e.printStackTrace();
        }

        log = new Log("new name");
        try {
            new CommandInterpreter(log).handleCommand("``load -1 " + fileName);
        } catch (CommandNotFoundException e) {
            e.printStackTrace();
        }
        compare();
    }



}*/
