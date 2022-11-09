package com.eatyodaeat.model;

import javax.swing.*;

public class Creator extends JFrame {

    public Creator(String title, String imagePath) {
        super(title);
        add(new JLabel(new ImageIcon(imagePath)));

        // upper-right corner X behavior: hides frame, but does not terminate application
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        pack();
        setSize(700, 700);
        toFront();
        setAlwaysOnTop(true);

        setLocationRelativeTo(null);  // places it in center of screen
        setVisible(true);
    }
}













