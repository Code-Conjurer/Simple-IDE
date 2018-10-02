package models;

public interface Command{

    void run(int lineNumber, String input);
    //String prompt();
    String getName();
}
