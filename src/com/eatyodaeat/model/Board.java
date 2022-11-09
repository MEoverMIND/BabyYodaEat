//package com.eatyodaeat.model;
//
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//import javax.swing.*;
////
////
////public class Board {
////    private ArrayList<Tile> tiles;
////
////    public Board() {
////        tiles = new ArrayList<>();
////        addTiles();
////        shuffle();
////    }
////
////    public Board(int size) {
////        this();
////        if (size < tiles.size())
////            shortenList(size);
////    }
////
////    public void addTiles() {
////        tiles.addAll(Arrays.asList(Tile.values()));
////
////    }
////
////    public void shortenList (int num) {
////        tiles = new ArrayList<>(tiles.subList(0, num));
////    }
////
////    private void shuffle() {
////        Collections.shuffle(tiles);
////    }
////
////    public ArrayList<Tile> getTiles() {
////        return tiles;
////    }
////}
////
////
//public class Board implements ActionListener{
//
//
//    List<Character> cards = new ArrayList<>();
//    List<Character> cardsClicked = new ArrayList<>();
//    Character cardFlipped1;
//    Character cardFlipped2;
//    int numClicks;
//    JFrame board = new JFrame();
//    // JPanel startField = new JPanel();
//    // JPanel turnField = new JPanel();
//    JPanel cardLayout = new JPanel();
//    // JPanel is a container that stores the components of the GUI
//    GridLayout grid = new GridLayout(3, 3, 10, 10);
//    // Load images into Icons
//    Icon yodaImage = new ImageIcon("images/baby_yoda.jpeg");
//    Icon c3p0Image = new ImageIcon("images/c3p0.jpg");
//    Icon mandoImage = new ImageIcon("images/mando.png");
//    Icon stormTropperImage = new ImageIcon("images/storm_tropper.jpeg");
//    Icon vaderImage = new ImageIcon("images/darth_vader.png");
//    Icon foodImage = new ImageIcon("images/macaroon.jpeg");
//    Icon backCard = new ImageIcon("images/white_back");
//
//
//
//
//    // TODO logic
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() instanceof Card)
//        {
//            if (firstOpenedCard != null && secondOpenedCard != null)                   //Player can only select a new card as long as there's no
//            {                                                                          //2 cards selected yet
//                return;
//            }
//
//            if (firstOpenedCard == null)            //When card is clicked, select and evaluate
//            {
//                firstOpenedCard = (Card) e.getSource();
//                firstOpenedCard.showCard();
//                firstOpenedCard.removeActionListener(this);
//            } else if (secondOpenedCard == null)
//            {
//                secondOpenedCard = (Card) e.getSource();
//                secondOpenedCard.showCard();
//                secondOpenedCard.removeActionListener(this);
//            }
//
//    public Board() {
//        board.setTitle("Yoda Board");
//        board.setSize(850, 850);
//        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//        // Set the grid, starting with 9
//        cardLayout.setLayout(grid);
//
//        // Start and Turn buttons
//       JProgressBar turn = new JProgressBar();
//        JButton start = new JButton();
//
//        // Create the JButtons to put into the JPanel
//        Character character1 = new Character("yoda", yodaImage, false,backCard );
//        Character character2 = new Character("c3p0", c3p0Image, false,backCard);
//        Character character3 = new Character("mando", mandoImage, false,backCard);
//        Character character4 = new Character("stormy", stormTropperImage, false,backCard);
//        Character character5 = new Character("vader", vaderImage, false,backCard);
//        Character character6 = new Character("food", foodImage, false,backCard);
//        Character character2_2 = new Character("c3p0", c3p0Image, false,backCard);
//        Character character3_2 = new Character("mando", mandoImage, false,backCard);
//        Character character4_2 = new Character("stormy", stormTropperImage, false,backCard);
//
//        // Put each card into the "cards" ArrayList
//        cards.add(character1);
//        cards.add(character2);
//        cards.add(character3);
//        cards.add(character4);
//        cards.add(character5);
//        cards.add(character6);
//        cards.add(character2_2);
//        cards.add(character3_2);
//        cards.add(character4_2);
//
//        // this method shuffles the ArrayList to randomize the Panel
//        Collections.shuffle(cards);
//
//        // For loop to place the Jbuttons on the panel
//        for (int i = 0; i < 9; i++) {
//            cardLayout.add(cards.get(i));
//            cards.get(i).addActionListener(this);
//            cards.get(i).setIcon(backCard);
//
//        }
//
//        // added and Start button to JFrame
//        board.add(new JPanel() {{
//            add(start);
//        }}, BorderLayout.SOUTH);
//
//        // added and Turn tracker to JFrame
//        board.add(new JPanel() {{
//            add(turn);
//        }}, BorderLayout.NORTH);
//
//
//        board.add(cardLayout);
//        board.setVisible(true);
//        board.setResizable(false);
//
//
//   }
//
//    public boolean vaderMatches() {
//        return cardsClicked.stream()
//                .anyMatch(Character->Character.getName().equals("vader"));
//
//    }
//
//    public boolean stormyMatched() {
//        return cardsClicked.stream()
//                .allMatch(Character->Character.getName().equals("stormy"));
//
//    }
//
//
//    // main class for testing
//
//    public static void main(String[] arguments) {
//        Board board = new Board();
//
//    }
//}
//
