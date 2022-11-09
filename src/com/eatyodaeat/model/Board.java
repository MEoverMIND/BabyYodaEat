package com.eatyodaeat.model;

import com.eatyodaeat.model.Card;

import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.List;

// class BoardLogicTest implements ActionListener {

public class Board extends JFrame  {

    private List<Card> Deck = new ArrayList<>();
    private List<Card> Catcher = new ArrayList<>();
    private List<Card> flipBack = new ArrayList<>();
    private Timer timer = null;
    private boolean isCleared = false;

    Board() {
    }

    public void initUI() {

        this.setTitle("Yoda Board");
        this.setSize(850, 850);
        this.setLayout(new GridLayout(3, 3, 10, 10));
        this.setLocationRelativeTo(null);

        creatCard();
        loadCard();
        flipCard();

        this.setVisible(true);
    }

    public void creatCard() {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= 5; j++) {
                Icon Face = new ImageIcon("images/" + i + "Character.jpeg");
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

