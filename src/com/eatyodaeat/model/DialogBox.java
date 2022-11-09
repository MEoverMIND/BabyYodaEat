package com.eatyodaeat.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogBox extends JFrame {
    private JLabel Title;
    private JPanel Control;


    DialogBox() {
        this.setTitle("BABY YODA EAT");
        this.setSize(300, 300);
        this.setLayout(new GridLayout(3, 3, 10, 10));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Title = new JLabel("WELCOME TO BABY YODA MATCHING GAME", JLabel.CENTER);

        Control = new JPanel();
        Control.setLayout(new FlowLayout());

        JButton startBtn = new JButton("Start");
        startBtn.addActionListener(e -> {
            Title.setText("Gaming");
            start();
        });
        Control.add(startBtn);

        JButton aboutBtn = new JButton("Creators");
        aboutBtn.addActionListener(e -> {
            Title.setText("Creators");
            about();
        });
        Control.add(aboutBtn);

        JButton exitBtn = new JButton("Exit");
        exitBtn.addActionListener(e -> System.exit(1));
        Control.add(exitBtn);

        this.add(Title);
        this.add(Control);
        this.setVisible(true);
    }

    public void start() {
        Board board = new Board();
        board.initUI();
    }

    public void about() {
        new Creator().setVisible(true);
    }

    public static void main(String[] args) {
        new DialogBox();
    }

}
