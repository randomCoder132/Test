package com.company;
import javax.swing.*;

public class myFrame extends JFrame {
    private MyPanel panel;
    public myFrame(){

        panel = new MyPanel(); // setting up the frame and pannel
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);


    }

}
