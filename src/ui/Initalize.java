package ui;

import unnamed.ScreenMatrix;

public class Initalize{
final int SIZE_X = 20;
final int SIZE_Y = 20;

    public Initalize(){
        ScreenMatrix screenLog = new ScreenMatrix(SIZE_X, SIZE_Y);
        Cursor cursor = new Cursor(SIZE_X, SIZE_Y);
        screenLog.debugGenerateMatrix();
        screenLog.print();
        while(true){
            screenLog.print();
            //keyCode = new KeyHandler().getKeyCode();
        }
    }

    public static void main(String[] args){
        new Initalize();
    }
}
