package models;

public abstract class Command{
    protected String name;

    public Command(String name){
        this.name = name;
    }

    abstract public void run(int arg1, String arg2);

    public String getName(){
        return name;
    }
    
}
