package com.eatyodaeat.view;

import java.awt.*;

import javax.swing.*;

public class Board extends JFrame {

    public Board() {
        super("Bunch");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Jpanel is a container that stores the components of the GUI
        JPanel container = new JPanel();

        // Set the grid, starting with 9
        GridLayout grid = new GridLayout(3, 3, 10, 10);
        container.setLayout(grid);

        Icon yodaImage = new ImageIcon("images/baby_yoda.jpeg");
        Icon c3p0Image = new ImageIcon("images/c3p0.jpg");
        Icon mandoImage = new ImageIcon("/Users/shimidolo/Desktop/pixle art/mando.png");
        Icon stormTropperImage = new ImageIcon("/Users/shimidolo/Desktop/pixle art/storm_tropper.jpeg");
        Icon vaderImage = new ImageIcon("/Users/shimidolo/Desktop/pixle art/darth_vader.png");
        Icon foodImage = new ImageIcon("/Users/shimidolo/Desktop/pixle art/macaroon.jpeg");

        JButton a = new JButton(foodImage);
        JButton b = new JButton(c3p0Image);
        JButton c = new JButton(mandoImage);
        JButton d = new JButton(stormTropperImage);
        JButton e = new JButton(vaderImage);
        JButton f = new JButton(stormTropperImage);
        JButton g = new JButton(mandoImage);
        JButton h = new JButton(c3p0Image);
        JButton i = new JButton(yodaImage);




        container.add(a);
        container.add(b);
        container.add(c);
        container.add(d);
        container.add(e);
        container.add(f);
        container.add(g);
        container.add(h);
        container.add(i);
        add(container);
        setVisible(true);
        setResizable(false);


    }

    public static void main(String[] arguments) {
        Board frame = new Board();
    }
}