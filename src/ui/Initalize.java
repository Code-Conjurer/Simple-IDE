package ui;

import unnamed.ScreenMatrix;

import java.util.Scanner;

public class Initalize{
final int SIZE_X = 20;
final int SIZE_Y = 20;

    public Initalize(){
        ScreenMatrix screenLog = new ScreenMatrix(SIZE_X, SIZE_Y);
        Cursor cursor = new Cursor(SIZE_X, SIZE_Y);
        screenLog.debugGenerateMatrix();
        screenLog.print();
        String command = "";
        Scanner sc = new Scanner(System.in);
        while(true){
            screenLog.print();
            System.out.println("Please enter a command");
            command = sc.nextLine();
            if (command.equals("quit"))
                break;
            //keyCode = new KeyHandler().getKeyCode();
        }
    }

    public static void main(String[] args){
        new Initalize();
    }
}
