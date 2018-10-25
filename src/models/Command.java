package models;

public abstract class Command{
    protected String name;

    public Command(String name){
        this.name = name;
    }

    abstract public void run(String... args);

    public String getName(){

        return name;
    }
    
}
