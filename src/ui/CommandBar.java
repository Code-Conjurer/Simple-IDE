package ui;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import models.LogEngine;

public class CommandBar extends TextField {

    private LogEngine logEngine;

    public CommandBar(LogEngine logEngine){

        this.logEngine = logEngine;

        setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER){
                    logEngine.pushCommand(getText());
                    clear();
                }
            }
        });
    }
}
