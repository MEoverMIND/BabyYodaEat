package com.eatyodaeat;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Board  implements ActionListener {

    Character[] cards = new Character[9];
    JFrame board = new JFrame();
    JPanel cadLayout = new JPanel();
    JPanel startField = new JPanel();
    JPanel turnField = new JPanel();
    // Jpanel is a container that stores the components of the GUI
    JPanel cardLayout = new JPanel();
    GridLayout grid = new GridLayout(3, 3, 10, 10);



    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public Board() {
        board.setTitle("Yoda Board");
        board.setSize(800, 800);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Jpanel is a cardLayout that stores the components of the GUI
        // JPanel cardLayout = new JPanel();


        // Set the grid, starting with 9
        cardLayout.setLayout(grid);

        // set the start button field?
        startField.setBackground(Color.GREEN);




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
        board.add( new JPanel(){{ add(start);}}, BorderLayout.SOUTH);
        board.add( new JPanel(){{ add(turn);}}, BorderLayout.NORTH);

        cardLayout.add(character1);
        cardLayout.add(character2);
        cardLayout.add(character3);
        cardLayout.add(character4);
        cardLayout.add(character5);
        cardLayout.add(character6);
        cardLayout.add(character2_2);
        cardLayout.add(character3_2);
        cardLayout.add(character4_2);
        board.add(cardLayout);
        board.setVisible(true);
        board.setResizable(false);


    }



    // main class for testing

    public static void main(String[] arguments) {
        Board frame = new Board();
    }
}