package com.eatyodaeat.model;

import java.awt.*;
import javax.swing.*;


public class ProgressBar {
    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar();

    public ProgressBar() {
        bar.setValue(0);
        bar.setBounds(0, 0, 420, 50);
        bar.setStringPainted(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);

        fill();
    }

    public void fill() {
        int counter = 0;

        while(counter <= 100) {
            bar.setValue(counter);


        }

    }



}
