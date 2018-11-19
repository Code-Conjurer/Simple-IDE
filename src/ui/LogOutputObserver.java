package ui;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class LogOutputObserver implements Observer {
    ConsoleDisplay consoleDisplay;

    public LogOutputObserver(ConsoleDisplay consoleDisplay){
        this.consoleDisplay = consoleDisplay;
    }

    @Override
    public void update(Observable o, Object arg) {
        if(arg instanceof String)
            consoleDisplay.appendText( (String) arg);
        else if(arg instanceof List){
            for(String s : (List<String>) arg)
                consoleDisplay.appendText(s);
        }
    }
}
