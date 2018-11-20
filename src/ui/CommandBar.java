package ui;

import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import models.LogEngine;

import java.util.ArrayList;

public class CommandBar extends TextField {

    private LogEngine logEngine;
    private ArrayList<String> previousCommands;
    private int commandSelector = 0;

    public CommandBar(LogEngine logEngine){
        previousCommands = new ArrayList<>();
        this.logEngine = logEngine;

        //TODO: fix index handling
        setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode() == KeyCode.ENTER){
                    String currentCommand = getText();
                    previousCommands.add(currentCommand);
                    commandSelector = previousCommands.size();//as is, will be out of bounds
                    logEngine.pushCommand(currentCommand);
                    clear();
                }else if(event.getCode() == KeyCode.UP){
                    if(commandSelector > 0) {
                        clear();
                        commandSelector--;
                        appendText(previousCommands.get(commandSelector));
                    }
                }else if(event.getCode() == KeyCode.DOWN){
                    if(commandSelector + 1 < previousCommands.size() && commandSelector >= 0){
                        clear();
                        commandSelector++;
                        appendText(previousCommands.get(commandSelector));
                    }
                }
            }
        });
    }
}
