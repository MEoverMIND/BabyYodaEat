package com.eatyodaeat.model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

class BoardLogicTest implements ActionListener {


    List<Character> cards = new ArrayList<>();
    List<Character> cardsClicked = new ArrayList<>();
    Set<Character> matchSet = new HashSet<>();
    Set<String> stringMatch = new HashSet<>();
    int numClicks = 0;
    JFrame board = new JFrame();
    JPanel cardLayout = new JPanel();


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
        Character cardFlipped1;
        Character cardFlipped2;

        // 1. reset cards

        for (int i = 0; i < 9; i++) {
//            System.out.println(numClicks);
            if (e.getSource() instanceof Character && numClicks < 2) {
                cards.get(i).turnOver();
                System.out.println(e.getActionCommand());
                cardsClicked.add((Character) e.getSource());
                stringMatch.add(e.getActionCommand());
                System.out.println(stringMatch);
                System.out.println(numClicks);
                System.out.println(cardsClicked);

            }
            while (numClicks == 2) {
                if (stringMatch.size() != 1) {
                    System.out.println("you lose");
                    stringMatch.clear();
                    numClicks = 0;
                    for (Character card : cardsClicked)
                    {
                        if(card.isClicked()) {
                            card.turnOver();
                        }
                    }

                }
                if (stringMatch.size() == 1) {
                    System.out.println("you win");
                    numClicks = 0;
                }
            }
//                }
//                if (cardsMatch()) {
//                    System.out.println("match");
//                    matchSet.clear();
//                    numClicks = 0;
//                }
//                if (!cardsMatch()) {
//                    System.out.println("dont match");
//                    matchSet.clear();
//                    numClicks = 0;
//                    break;
//                }

        }
        numClicks++;
}



    public BoardLogicTest() {
        board.setTitle("Yoda Board");
        board.setSize(850, 850);
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the grid, starting with 9
        cardLayout.setLayout(yodaGrid);


        // Create the JButtons to put into the JPanel
        Character character1 = new Character("yodaFed", yodaImage, false,backCard );
        Character character2 = new Character("c3p0", c3p0Image, false,backCard);
        Character character3 = new Character("mando", mandoImage, false,backCard);
        Character character4 = new Character("stormy", stormTropperImage, false,backCard);
        Character character5 = new Character("vader", vaderImage, false,backCard);
        Character character6 = new Character("yodaFed", foodImage, false,backCard);
        Character character2_2 = new Character("c3p0", c3p0Image, false,backCard);
        Character character3_2 = new Character("mando", mandoImage, false,backCard);
        Character character4_2 = new Character("stormy", stormTropperImage, false,backCard);

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
        board.add(cardLayout);
        board.setVisible(true);
        board.setResizable(false);


//        // added and Start button to JFrame
//        board.add(new JPanel() {{
//            add(start);
//        }}, BorderLayout.SOUTH);
//
//        // added and Turn tracker to JFrame
//        board.add(new JPanel() {{
//            add(turn);
//        }}, BorderLayout.NORTH);


   }

    private void placeButtons() {
        for (int i = 0; i < 9; i++) {
            cardLayout.add(cards.get(i));
            cards.get(i).addActionListener(this);
            cards.get(i).setIcon(backCard);


        }
    }

    public boolean vaderMatches() {
        return matchSet.stream()
                .anyMatch(Character->Character.getName().equals("vader"));
    }

    public boolean yodaFed() {
        return matchSet.stream()
                .allMatch(Character->Character.getName().equals("yodaFed"));
    }

    public boolean cardsMatch() {
        return matchSet.size() == 1;

    }


    // main class for testing

    public static void main(String[] arguments) {
        BoardLogicTest board = new BoardLogicTest();

    }
}
