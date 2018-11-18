package models;

import java.util.Observable;
import java.util.Observer;

public class LogObserver implements Observer {
    private Log log;

    @Override
    public void update(Observable o, Object arg) {
        log = (Log) o;
        log.printLog();
    }
}
