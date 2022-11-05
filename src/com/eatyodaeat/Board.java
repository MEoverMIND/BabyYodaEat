package com.eatyodaeat;

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

        JProgressBar turn = new JProgressBar();
        JButton start = new JButton();
        JButton character1 = new Character("yoda", yodaImage,false);
        JButton character2 = new Character("c3p0", c3p0Image,false);
        JButton character3 = new Character("mando", mandoImage,false);
        JButton character4 = new Character("stormy", stormTropperImage,false);
        JButton character5 = new Character("vader", vaderImage,false);
        JButton character6 = new Character("food", foodImage,false);
        JButton character2_2 = new Character("c3p0", c3p0Image,false);
        JButton character3_2 = new Character("mando", mandoImage,false);
        JButton character4_2 = new Character("stormy", stormTropperImage,false);

          // commented out all Jbutton Intialization

//        JButton a = new JButton(foodImage);
//        JButton b = new JButton(c3p0Image);
//        JButton c = new JButton(mandoImage);
//        JButton d = new JButton(stormTropperImage);
//        JButton e = new JButton(vaderImage);
//        JButton f = new JButton(stormTropperImage);
//        JButton g = new JButton(mandoImage);
//        JButton h = new JButton(c3p0Image);
//        JButton i = new JButton(yodaImage);


        // added and Turn tracker to JFrame
        add( new JPanel(){{ add(start);}}, BorderLayout.SOUTH);
        add( new JPanel(){{ add(turn);}}, BorderLayout.NORTH);

        container.add(character1);
        container.add(character2);
        container.add(character3);
        container.add(character4);
        container.add(character5);
        container.add(character6);
        container.add(character2_2);
        container.add(character3_2);
        container.add(character4_2);
        add(container);
        setVisible(true);
        setResizable(false);

    }

    // main class for testing

    public static void main(String[] arguments) {
        Board frame = new Board();
    }
}