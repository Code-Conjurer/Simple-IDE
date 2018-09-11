package ui;

import ui.windows.ApplicationWindow;

import javax.swing.*;

public class Initalize{

    final static int WIDTH = 1000;
    final static int HEIGHT = 700;


    public static void main(String[] args){
        ApplicationWindow appWin = new ApplicationWindow(WIDTH, HEIGHT);

        //debugging
        JInternalFrame dummyFrame = new JInternalFrame();
        appWin.addInternalFrame(dummyFrame);

    }
    /*
    static JTextArea mainTextArea;

    public Initalize(){
        initializeWindow();
    }

    private void initializeWindow() {

        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
        add( new JTextArea(100, 100));

    }

    public static void main(String[] args){
        new Initalize();
    }
*/
}
