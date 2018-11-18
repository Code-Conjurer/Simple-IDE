package models;

public abstract class Command{
    protected String name;

    public Command(String name){
        this.name = name;
    }

    abstract public void execute(Log log, String... args);

    public String getName(){

        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Command command = (Command) o;

        return name.equals(command.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
