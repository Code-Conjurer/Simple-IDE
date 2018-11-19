package ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import models.LogEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

//TODO: figure out how threading works, and implement
public class EditRegion extends TextArea {

    private LogEngine logEngine;
    private boolean isAppending;//TODO: Change variable name

    public EditRegion(LogEngine logEngine) {
        this.logEngine = logEngine;
        isAppending = true;
        logEngine.addObserver(new LogObserver());

        textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(isAppending)
                    logEngine.update( (String) newValue);
            }
        });
    }

    private void updateText(List list){
        isAppending = false;
        clear();
        for(String s: (ArrayList<String>) list) {
            if(s == list.get( list.size() - 1 ))
                appendText(s);
            else
                appendText(s + "\n");
        }
        isAppending = true;
    }

    private class LogObserver implements Observer{
        @Override
        public void update(Observable o, Object arg) {
            updateText((List) arg);
        }
    }
}
