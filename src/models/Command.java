package models;

public abstract class Command{
    protected String name;

    public Command(String name){
        this.name = name;
    }

    abstract public void run(int lineNumber, String input);
    //String prompt();
    public String getName(){
        return name;
    }
}
