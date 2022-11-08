package com.eatyodaeat.model;

import java.awt.*;
import javax.swing.*;


public class ProgressBar {
    JFrame frame = new JFrame();
    JProgressBar bar = new JProgressBar(0, 500);

    public ProgressBar() {
        bar.setValue(0);
        bar.setBounds(0, 0, 420, 50);
        bar.setStringPainted(true);
        bar.setFont(new Font("MV Boli", Font.BOLD, 23));
        bar.setForeground(Color.red);
        bar.setBackground(Color.green);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        fill();
    }

    public void fill() {
        int counter = 500;

        while(counter >= 0) {
            bar.setValue(counter);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        counter -= 1;
        }
        bar.setString("TIMES UP!");
    }

    public static void main(String[] args) {
        ProgressBar progressBar = new ProgressBar();
        progressBar.start();
    }

    private void start() {
    }

}
