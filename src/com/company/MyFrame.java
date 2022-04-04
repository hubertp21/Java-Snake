package com.company;

import javax.swing.*;

public class MyFrame extends JFrame {

    MyPanel panel;

    MyFrame(){

        panel = new MyPanel();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.addKeyListener(panel);
        panel.setFocusable(true);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
