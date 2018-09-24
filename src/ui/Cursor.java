package ui;
/*
import unnamed.ScreenMatrix;

import java.awt.event.KeyEvent;

public class Cursor {
    private int x, y;
    private int xBound, yBound;
   // private ScreenMatrix currentScreen;
    //private char charUnder;
    private final char CURSOR_SYMBOL = 178;

    //public Cursor(int xBound, int yBound, ScreenMatrix currentScreen){
    public Cursor(int xBound, int yBound){
        x = 0;
        y = 0;
        this.xBound = xBound;
        this.yBound = yBound;
        //this.currentScreen = currentScreen;
        //charUnder = setCharUnder();
    }

    //requires: any int corresponding to a KeyEvent Key Code
    //modifies: this
    //effects:
    public boolean moveCursor(int arrowKeyCode){
        switch (arrowKeyCode){
            case KeyEvent.VK_LEFT:
                if(x != 0)
                    x--;
                break;
            case KeyEvent.VK_RIGHT:
                x++;
                break;
            case KeyEvent.VK_DOWN:
                if(y != 0)
                    y--;
                break;
            case KeyEvent.VK_UP:
                y++;
                break;
            default:
                return false;
        }
        if(!isInBoundsX())
            x--;
        else if(isInBoundsY())
            y--;

        return true;
    }

    private boolean isInBoundsX(){
        if(x >= 0 && x < xBound)
            return true;
        else
            return false;
    }

    private boolean isInBoundsY(){
        if(y >= 0 && y < yBound)
            return true;
        else
            return false;
    }

    /*
    private char setCharUnder(){
        return currentScreen.getCharAt(x, y);
    }

    public char getCharUnder() {
        return charUnder;
    }


    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    public char getCURSOR_SYMBOL() {
        return CURSOR_SYMBOL;
    }

}*/