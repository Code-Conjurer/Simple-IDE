package ui.windows;

import javax.swing.*;
import java.awt.*;

public class ApplicationWindow extends JFrame {

    JDesktopPane virtualDesktop;

    public ApplicationWindow(int WIDTH, int HEIGHT){

        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        setLocationRelativeTo(null);
        setVisible(true);

        virtualDesktop = new JDesktopPane();
    }

    //REMOVE METHOD, ADD TO ITS OWN OBJECT(?)
    public void addInternalFrame(JInternalFrame internFrame){
        //internFrame.setLayout(new BorderLayout());
        //internFrame.setMinimumSize(new Dimension(100, 100));//hard coded, remove when possible
        //internFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        internFrame.setVisible(true);
        try {
            internFrame.setSelected(true);
        }catch(Exception e){}

        virtualDesktop.add(internFrame);
    }

}
