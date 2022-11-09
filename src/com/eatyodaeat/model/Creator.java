package com.eatyodaeat.model;

import javax.swing.*;
import java.awt.*;

public class Creator extends JFrame {
    public Creator() throws HeadlessException {
        initUI();
    }

    private void initUI() {
        this.setSize(450,400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        Label label = new Label("JAVA JEDI");
        label.setFont(new Font("Tahoma",Font.BOLD,28));
        Label label1 = new Label("VERONICA PICHAY");
        label1.setFont(new Font("Tahoma",Font.BOLD,28));
        Label label2 = new Label("CHASE BROOKS");
        label2.setFont(new Font("Tahoma",Font.BOLD,28));
        Label label3 = new Label("DAVID JEFFERSON");
        label3.setFont(new Font("Tahoma",Font.BOLD,28));
        Panel panel = new Panel();
        panel.add(label);
        panel.add(label1);
        panel.add(label2);
        panel.add(label3);
        this.add(panel);
    }
}