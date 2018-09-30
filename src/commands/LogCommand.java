package commands;

import unnamed.Log;

public abstract class LogCommand implements Command{

    protected Log log;
    protected String name;
  //  protected boolean isWaiting = false;

    /*
    public LogCommand(){
        log = null;
        name = null;
    }*/

    /*
    public LogCommand(Log log){
        this.log = log;
    }*/
    public void input(String in){
        //stub
    }

    /*
    protected void waitForInput(){
        isWaiting = true;
    }

    protected void resumeAfterInput(){
        isWaiting = false;
    }

    public boolean getWaiting(){
        return isWaiting;
    }
*/
    @Override
    public String propmt(){
        return "Command: " + name;
    }

    @Override
    public String getName() {
        return name;
    }
}
