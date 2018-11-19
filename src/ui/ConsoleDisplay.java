package ui;

import javafx.scene.control.TextArea;
import models.LogEngine;

import java.util.Observable;
import java.util.Observer;

public class ConsoleDisplay extends TextArea{

    public ConsoleDisplay(){

        setEditable(false);
        setFocusTraversable(false);
        //setMouseTransparent(true);
    }

    public void refresh(String text){
        clear();
        appendText(text);
    }

    public void print(String s){
        appendText(s);
    }

    public void println(String s){
        appendText(s + "\n");
    }

    public void println(){
        appendText("\n");
    }

}
