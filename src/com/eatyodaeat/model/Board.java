package com.eatyodaeat.model;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

public class Board extends JFrame {
    private List<Card> Deck = new ArrayList<>();
    private List<Card> Catcher = new ArrayList<>();
    private List<Card> flipBack = new ArrayList<>();
    private Timer timer = null;
    private boolean isCleared = false;

    Board() {
    }

    public void initUI() {
        this.setTitle("Baby Yoda is hangry!!!");
        this.setSize(850, 850);
        this.setLayout(new GridLayout(3, 4));
        this.setLocationRelativeTo(null);

        creatCard();
        loadCard();
        flipCard();

        this.setVisible(true);
    }

    public void creatCard() {
        for (int dup = 0; dup < 2; dup++) {
            for (int i = 0; i <= 5; i++) {
                Icon Face = new ImageIcon("images/" + i + "Card.jpeg");
                Icon Back = new ImageIcon("images/white_back.jpeg");
                Card card = new Card(Face, Back, false, i, false, false);
                card.setIcon(Back);
                Deck.add(card);
            }
        }
        Collections.shuffle(Deck);
    }

    public void loadCard() {
        for (Card card : Deck) {
            this.add(card);
        }
    }

    public void flipCard() {
        for (Card card : Deck) {
            card.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!card.cantClick) {
                        if (card.isFaceUp) {
                            card.setIcon(card.BackSide);
                            card.isFaceUp = false;
                        } else {
                            card.setIcon(card.FaceSide);
                            card.isFaceUp = true;
                            Catcher.add(card);

                        }
                        card.cantClick = true;
                    }
                    setStatus();

                    // check end game
                    for (Card card : Deck) {
                        if (!card.isFaceUp) {
                            isCleared = false;
                            break;
                        } else {
                            isCleared = true;
                        }
                    }
                    checkEndGame();
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
        }
    }

    public void setStatus() {
        int delay = 800; //milliseconds
        if (Catcher.size() == 2) {
            if (Catcher.get(0).matched(Catcher.get(1))) {
                for (Card card : Deck) {
                    if (card.isFaceUp) {
                        card.isMatched = true;
                        card.cantClick = true;
                    }
                }


            } else {
                flipBack.addAll(Catcher);
                ActionListener taskPerformer = new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        for (Card card : flipBack) {
                            if (!card.isMatched) {
                                card.setIcon(card.BackSide);
                                card.isFaceUp = false;
                                card.cantClick = false;
                            }
                        }
                        flipBack.clear();
                    }
                };
                if (timer != null) timer.stop();
                timer = new Timer(delay, taskPerformer);
                timer.start();
            }
            Catcher.removeAll(Catcher);
        }
    }

    private void checkEndGame() {
        if (isCleared) {
            int out = JOptionPane.showConfirmDialog(this, "Play", "Goodbye", JOptionPane.YES_NO_OPTION);
            if (out == JOptionPane.YES_OPTION) {
                this.setVisible(false);
                Board board = new Board();
                board.initUI();
            } else if (out == JOptionPane.NO_OPTION) {
                this.setVisible(false);
            }
        }
    }
}
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
//    // TODO logic
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        for (int i = 0; i < 9; i++) {
//            if (e.getSource() instanceof Character && numClicks < 0) {
//                cards.get(i).turnOver();
//                numClicks++;
//                cardsClicked.add(cards.get(i));
//                cardFlipped1 = cards.get(i);}
//            if (numClicks < 2) {
//                cards.get(i).turnOver();
//                numClicks++;
//                cardsClicked.add(cards.get(i));
//                cardFlipped2 = cards.get(i);}
//        }
//        if (vaderMatches()){
//            System.exit(0);
//        };
//
//    }
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

