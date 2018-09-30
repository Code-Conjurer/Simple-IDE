package commands;

public interface Command{

    void run(int lineNumber, String input);
    String propmt();
    String getName();
}
