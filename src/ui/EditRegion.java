package ui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TextArea;
import models.LogEngine;

//TODO: figure out how threading works, and implement
public class EditRegion extends TextArea {

    private LogEngine logEngine;

    public EditRegion(LogEngine logEngine) {
        this.logEngine = logEngine;

        textProperty().addListener(new ChangeListener() {

            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                logEngine.update( (String) newValue);
            }

        });
    }
}
