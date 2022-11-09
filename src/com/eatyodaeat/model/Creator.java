package com.eatyodaeat.model;

import javax.swing.*;
import java.awt.*;

public class Creator extends JFrame {
    public Creator() {
        initUI();
    }


    private void initUI() {;
        Font font = new Font("Tahoma",Font.BOLD,28);

        this.pack();
        this.setSize(450,400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        JLabel label = new JLabel("JAVA JEDI", JLabel.CENTER);
        label.setFont(font);
        JLabel label1 = new JLabel("VERONICA PICHAY", JLabel.CENTER);
        label1.setFont(font);
        JLabel label2 = new JLabel("CHASE BROOKS", JLabel.CENTER);
        label2.setFont(font);
        JLabel label3 = new JLabel("DAVID JEFFERSON", JLabel.CENTER);
        label3.setFont(font);
        JPanel panel = new JPanel(new GridLayout(4,1,5,5));
        panel.add(label);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        this.add(panel);
    }
}