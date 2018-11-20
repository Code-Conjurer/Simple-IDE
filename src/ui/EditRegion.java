package ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import models.LogEngine;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.stream.StreamSupport;

//TODO: figure out how threading works, and implement
public class EditRegion extends TextArea {

    private LogEngine logEngine;
    private boolean isAppending;//TODO: Change variable name
    private boolean shiftPressed = false;
    private int layer = 0;

    public EditRegion(LogEngine logEngine) {
        this.logEngine = logEngine;
        isAppending = true;
        logEngine.addObserver(new LogObserver());

        textProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                if(isAppending) {
                    logEngine.update((String) newValue);
                }
            }
        });

        setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SHIFT){
                    shiftPressed = false;
                }else if(shiftPressed == true && event.getCode() == KeyCode.DIGIT9) {
                    insertText(getCaretPosition(),")");
                    backward();
                }else if (shiftPressed == true && event.getCode() == KeyCode.OPEN_BRACKET){
                    layer++;
                }else if(event.getCode() == KeyCode.ENTER) {
                    for(int i = 0; i < layer; i++){
                        insertText(getCaretPosition(), "\t");

                    }
                }
            }
        });

        setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.SHIFT){
                    shiftPressed = true;
                }else if(shiftPressed == true && event.getCode() == KeyCode.CLOSE_BRACKET) {
                    if (layer > 0) {
                        deletePreviousChar();
                        layer--;
                    }
                }
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
