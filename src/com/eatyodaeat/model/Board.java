package com.eatyodaeat.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class Board extends JFrame implements ActionListener {


    List<Character> cards = new ArrayList<>();
    List<Character> cardsClicked = new ArrayList<>();
    Set<String> stringMatch = new HashSet<>();
    int numClicks = 0;
    int matches = 0;
    int turn = 0;
    JPanel cardLayout = new JPanel();
    boolean lost = false;
    JButton reset = new JButton();
    JProgressBar turnTracker = new JProgressBar();
    JPanel gameOver = new GameOver();

    // JPanel is a container that stores the components of the GUI
    GridLayout yodaGrid = new GridLayout(3, 3, 10, 10);

    // Load images into Icons
    Icon yodaImage = new ImageIcon("images/baby_yoda.jpeg");
    Icon c3p0Image = new ImageIcon("images/c3p0.jpg");
    Icon mandoImage = new ImageIcon("images/mando.png");
    Icon stormTropperImage = new ImageIcon("images/storm_tropper.jpeg");
    Icon vaderImage = new ImageIcon("images/darth_vader.png");
    Icon foodImage = new ImageIcon("images/macaroon.jpeg");
    Icon backCard = new ImageIcon("images/white_back");

    // TODO logic
    @Override
    public void actionPerformed(ActionEvent e) {
        // number of cards clicked
        numClicks++;
        stringMatch.add(e.getActionCommand());
        System.out.println(turn);



        System.out.println(stringMatch);

        for (int i = 0; i < 9; i++) {
//            System.out.println(numClicks);
            if (e.getSource() instanceof Character) {
                cards.get(i).turnOver();
//                System.out.println(e.getActionCommand());
                cardsClicked.add((Character) e.getSource());


//                System.out.println(numClicks);
//                System.out.println(cardsClicked);
            }
            while (numClicks == 2) {



                // will be game over
                if (vaderMatches()){
                    gameOver();
                    stringMatch.clear();
                    gameOver();
                    lost = true;
                    numClicks = 0;
                }

                // will be game over
                if (yodaFed()){
                    yodaWin();
                    stringMatch.clear();
                    lost = true;
                    numClicks = 0;
                }

                if (stringMatch.size() == 1) {
                    System.out.println("you win");
                    matches++;
                    stringMatch.clear();
                    numClicks = 0;

                }

                if (stringMatch.size() >= 2) {

                    System.out.println("you lose");
                    stringMatch.clear();
                    reset();
                    System.out.println(stringMatch);
                    lost = true;
                    numClicks = 0;
                    turn++;
                }
            }
        }
    }

    public Board() {
        setTitle("Yoda Board");
        setSize(850, 850);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the grid, starting with 9
        cardLayout.setLayout(yodaGrid);


        // Create the JButtons to put into the JPanel
        Character character1 = new Character("yodaFed", yodaImage, false, backCard);
        Character character2 = new Character("c3p0", c3p0Image, false, backCard);
        Character character3 = new Character("mando", mandoImage, false, backCard);
        Character character4 = new Character("stormy", stormTropperImage, false, backCard);
        Character character5 = new Character("vader", vaderImage, false, backCard);
        Character character6 = new Character("yodaFed", foodImage, false, backCard);
        Character character2_2 = new Character("c3p0", c3p0Image, false, backCard);
        Character character3_2 = new Character("mando", mandoImage, false, backCard);
        Character character4_2 = new Character("stormy", stormTropperImage, false, backCard);

        // Put each card into the "cards" ArrayList
        cards.add(character1);
        cards.add(character2);
        cards.add(character3);
        cards.add(character4);
        cards.add(character5);
        cards.add(character6);
        cards.add(character2_2);
        cards.add(character3_2);
        cards.add(character4_2);

        // this method shuffles the ArrayList to randomize the Panel
        Collections.shuffle(cards);

        // For loop to place the Jbuttons on the panel
        placeButtons();

        // assigning layout to board
        add(cardLayout);
        setVisible(true);
        setResizable(false);


        // added and Start button to JFrame
        add(new JPanel() {{
            add(reset);
        }}, BorderLayout.SOUTH);


        // added and Turn tracker to JFrame
        add(new JPanel() {{
            add(turnTracker);
        }}, BorderLayout.NORTH);


    }

    private void placeButtons() {
        for (int i = 0; i < 9; i++) {
            cardLayout.add(cards.get(i));
            cards.get(i).addActionListener(this);
            cards.get(i).setIcon(backCard);

        }
    }

    public boolean vaderMatches() {
        return stringMatch.stream()
                .anyMatch(String -> String.equals("vader"));
    }

    public boolean yodaFed() {
        return (stringMatch.stream().anyMatch(String -> String.equals("yodaFed")) && stringMatch.size() == 1);
    }

    public void gameOver() {
        this.dispose();
        System.out.println(

                "WELCOME TO THE DARKSIDE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+

                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡠⢄⡲⠖⠛⠉⠉⠉⠉⠉⠙⠛⠿⣿⣶⣦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠔⣡⠖⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠘⣿⣿⣿⣿⣷⣦⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠔⣡⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡔⢡⣶⠏⠀⠀⠀⠀⠀⠀⣠⣴⣶⣶⣶⣶⣶⣶⣦⣄⣸⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠌⢀⣿⠏⠀⠀⠀⠀⠀⠀⠸⠿⠋⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡞⠀⡼⢿⣦⣄⠠⠤⠐⠒⠒⠒⠢⠤⣄⣠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⠀⠀⠀⣸⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⢠⠞⠁⠀⠀⠠⠇⣀⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠈⠙⠛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢀⣴⣁⠀⣀⣤⣴⣾⣿⣿⣿⣿⡿⢿⣿⣶⣄⠀⠀⠀⠀⠀⣿⣷⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⣿⡇⠀⢸⣿⣿⣿⡇⠘⠟⣻⣿⣧⠀⠀⠀⠀⢿⣿⣤⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣿⣿⣿⣿⣿⡿⠀⠀⠸⣿⠿⠋⠉⠁⠛⠻⠿⢿⣧⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣿⣿⣿⡿⠋⠁⠀⢀⣄⡀⠀⠀⠀⢀⣀⣤⣴⣿⣿⣧⠀⢀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣇⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣿⣿⠏⢀⠀⢀⡴⠿⣿⣿⣷⣶⣾⣿⣿⣿⣿⣿⣿⣿⣇⠀⢷⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣿⣿⣤⣿⣷⡈⠀⠀⠀⠙⠻⣿⣿⣿⣿⠿⠛⠛⣻⣿⣿⡄⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡄⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣄⠀⠀⠀⠀⠈⠋⢉⣠⣴⣾⣿⣿⣿⣿⣷⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⢸⣿⣿⢻⡏⢹⠙⡆⠀⠀⠀⠒⠚⢛⣉⣉⣿⣿⣿⣿⣿⣿⡇⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⢀⡞⠁⠉⠀⠁⠀⣄⣀⣠⣴⣶⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⣈⡛⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠛⠋⠉⠉⠉⠙⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠻⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡷⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⣻⠿⠿⢿⣿⠿⠿⠋⠁⠀⠙⣿⡁⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠛⠋⠉⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⠴⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣈⣹⣦⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣤⡀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣀⣀⣀⣀⣀⣼⣿⣄⣀⣀⡄⠀⣀⣀⣠⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⢰⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠉⠀⠀⣰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀\n" +
                "⠀⠀⠀⢀⣤⣤⣤⣶⣿⣿⣿⣿⠿⠿⠟⠋⢹⠇⠀⠀⢀⣼⣿⣿⣿⣿⣿⡿⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\n" +
                "⠀⢀⣴⣿⣿⣿⣿⣿⣿⣿⡟⠁⠀⠀⠀⢀⡏⠀⠀⢀⣾⠋⣹⣿⣿⣿⡟⠀⠀⣸⡟⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇\n" +
                "⢠⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⡼⠀⠀⢀⣾⠏⢀⣿⣿⣿⠋⠀⠀⣰⣿⣧⡀⠹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇");


        SwingUtilities.updateComponentTreeUI(this);

    }

    public void yodaWin() {
        this.dispose();
        System.out.println(
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣴⣶⡿⠿⠿⠟⠛⠛⠛⠛⠛⠛⠿⠿⢿⣶⣶⣤⣀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣴⣾⠿⠛⠋⢁⣀⣤⣤⣶⣶⣶⣶⣶⣶⣶⣶⣶⣦⣤⣄⣈⠉⠛⠿⣷⣦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⣾⠟⠋⣁⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣤⣀⠉⠻⢿⣦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⣶⡿⠋⢀⣴⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⣄⠙⠻⣷⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⢀⣴⡿⠋⣠⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠈⢻⣷⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⣠⣿⠟⢀⣴⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠙⣿⣆⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⣰⣿⠃⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠿⠿⠿⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠈⢿⣧⡀⠀⠀⠀⠀⠀⠀\n" +
                "⡀⠂⠐⠒⠂⠐⠿⠁⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠟⠋⠉⠀⠀⠀⠀⠤⠄⠀⠀⠀⠈⠉⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣆⠈⢻⣷⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠠⠀⠀⢤⣄⣀⠀⠀⠀⠀⠉⠉⠛⠛⠻⠿⠿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠤⠤⠤⠄⠀⠀⠀⠀⠀⠀⠀⠙⠻⢿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠧⠈⠿⠧⠀⠀⠤⠤⠄\n" +
                "⠀⠀⠀⢢⡀⢻⣿⣿⣿⣶⣶⣤⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⡠⠀⢀⠌\n" +
                "⠀⠀⠀⢸⣷⠄⢻⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠀⠠⠄⠒⠒⠠⠀⠀⠀⠀⠀⠀⠀⠀⢀⠄⠒⠀⠐⠢⠀⠀⠀⠀⠀⣠⣴⣶⣿⣿⣿⣿⣿⣿⣿⣿⠟⠀⠔⠁⠀\n" +
                "⠀⠀⠀⣼⡟⠐⡄⠻⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⢀⡔⠈⣿⣿⣶⣄⠀⠀⠀⠀⠀⠀⠀⢀⣴⠈⢻⣿⣶⣄⠀⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢃⣴⠁⠀⠀⠀\n" +
                "⠀⠀⠀⣿⡇⠀⣿⣦⡈⠻⢿⣿⣿⣿⣿⣿⡇⠀⠀⢺⣿⣾⣿⣿⣿⣿⡆⠀⠀⠀⠀⠀⠀⣿⣿⣷⣿⣾⣿⡿⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⡿⢋⡀⢸⣿⡄⠀⠀⠀\n" +
                "⠀⠀⠀⣿⡇⠀⣿⣿⣿⣦⣄⡀⠀⠀⠈⠉⠃⠀⠀⠀⠈⠙⠛⠛⠛⠛⠁⠀⠐⠒⠒⠀⠀⠙⠛⠛⠛⠛⠉⠀⠀⠀⠘⠛⠛⠛⠛⠛⠛⣉⣥⣶⣿⡇⢸⣿⠀⠀⠀⠀\n" +
                "⠀⠀⠀⣿⣧⠀⣿⣿⣿⣿⣿⣿⣿⣶⣶⣤⡤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠤⠀⠒⠂⠀⠄⠀⠀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⣴⣶⣾⣿⣿⣿⣿⣿⠃⢸⣿⠀⠀⠀⠀\n" +
                "⠀⠀⠀⢹⣿⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣻⣿⣷⣦⣤⣤⣤⣤⣤⣤⡤⢤⣤⣤⣤⣴⣶⣶⣶⣶⣶⣶⣶⣶⣿⣿⣟⣿⠿⢿⣿⣿⣿⣿⣿⣿⣿⠀⣼⡿⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠈⣿⣇⠈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣻⣿⣿⣿⣿⣿⣿⡟⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀⠴⣿⣿⣿⣿⣿⣿⠇⢠⣿⠇⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠸⣿⡄⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠛⢿⣿⣿⣿⣿⣷⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠛⠋⢉⣿⣿⠁⠀⠀⠀⣀⣨⣿⣿⣿⣿⡟⠀⣾⡟⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠹⣷⡀⠹⣿⣿⣿⣿⣿⣿⣿⣿⡆⠀⠀⠀⠉⠙⢛⣻⣻⣿⣿⣿⡿⠿⠟⠛⠉⠀⠀⠀⠀⣼⣿⣿⢠⢤⣶⢺⣿⣿⣿⣿⣿⡟⠀⣼⡿⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠹⣷⡄⠙⣿⣿⣿⣿⣿⣿⣻⣿⣤⡀⠀⠀⠀⠈⠉⠉⣽⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⣻⣿⣿⣷⣿⣿⣿⣿⣿⣿⣿⠏⢀⣾⡟⠁⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠙⣿⣆⠈⠻⣿⣿⣿⣿⠃⠙⠿⣿⡶⠀⠀⠀⠀⠘⠽⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢻⣯⣿⣭⣿⣿⣿⣿⣿⡿⠃⣠⣾⠟⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠈⢻⣷⣄⠙⠿⣿⣿⣦⣾⣧⣬⠃⠀⠀⠀⠀⠀⡆⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⡿⠋⢀⣴⡿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⢿⣷⣄⠈⠻⢿⣿⣿⡟⠀⠀⠀⠀⠀⢀⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⠟⠋⣠⣴⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⣿⣦⣄⠉⠛⠧⣄⡀⠀⠀⠀⢸⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣨⡿⠟⠉⣀⣴⣾⠟⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⢿⣶⣤⣀⡉⠙⠓⠲⠾⠤⢤⣤⣤⣤⡤⠤⠤⠶⠒⠛⠉⣀⣤⣴⣿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠛⠻⠿⣶⣶⣦⣤⣤⣤⣤⣤⣤⣤⣴⣶⣶⡿⠿⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠉⠉⠉⠉⠉⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");


        SwingUtilities.updateComponentTreeUI(this);

    }
    public void reset() {
       this.dispose();
//        this.repaint();
//        this.remove(cardLayout);
//        Collections.shuffle(cards);
//        placeButtons();
//        Thread.sleep(500);
        new Board();
        add(cardLayout);
        SwingUtilities.updateComponentTreeUI(this);

        }


    // main class for testing

    public static void main(String[] arguments) {
        Board board = new Board();

    }
}
