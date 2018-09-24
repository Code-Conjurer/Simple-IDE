package ui;
/*
import unnamed.ScreenMatrix;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    ScreenMatrix screenLog;
    TextArea textArea;

    public Window(String windowName, ScreenMatrix screenLog){
        this.screenLog = screenLog;
        textArea = new TextArea(screenLog.getSizeX(), screenLog.getSizeY());
        textArea.setRows(screenLog.getSizeX());
        textArea.setColumns(screenLog.getSizeX());
        setMinimumSize(new Dimension(1000, 1000));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(textArea);
        setVisible(true);
    }

    public void update(){
        textArea.setText("");
        setScreenLogText(textArea, screenLog);
    }

    private void setScreenLogText(TextArea textArea, ScreenMatrix screenMatrix){
        String textLine = "";
        for(int i = 0; i < screenMatrix.getSizeX(); i++){
            for(int j = 0; j < screenMatrix.getSizeY(); j++){
                textLine += screenMatrix.getCharAt(i, j);
            }
            textArea.append(textLine);
        }
    }
}
*/