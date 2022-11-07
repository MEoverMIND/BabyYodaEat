package com.eatyodaeat.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Character extends JButton {
    private static Map<String,Icon> imageMap = new HashMap<>();
    private String name;  // "yoda", "eggs", "trooper", "vader"
    private boolean isClicked = false;
    private Icon icon;
    private Icon back;



// TODO
    /*
     * 1. is Darthvader() needs to be built
     */

// ctor - only ctor and all fields required

    public Character(String name,Icon front, boolean isClicked, Icon back) {

        setIcon(back);
        setName(name);
        setClicked(isClicked);
        setBack(front);
    }



    // returns True or False if two charactrs match
    public boolean matches(Character other) {
        return this.name.equals(other.name);
    }

    // maybe not
    public void isDarthVader() {
        String answer = "";

        if (this.name.equals("vader") && isClicked) {
            System.out.println("SURPRISE!!! welcome to the dark side ");
            System.out.println("Answer this question to see the light");
            // prompt
            if (answer == "") {
                // turn continues
                System.out.println("good job");
            }
            else {
                System.out.println(
                                "⠀⠀⠀⠀⢠⢤⠀⠀⠀⠠⢢⢭⣿⠿⣿⣵⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠘⠯⠀⠀⠀⣹⠛⠓⠓⠛⠋⠙⢻⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⢰⠴⡄⠀⠀⣷⠆⠀⠀⡀⠀⣀⣸⣦⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⢠⢺⠀⠇⢀⡀⣿⡄⠛⠟⠡⣏⠉⠙⡿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⢀⢪⠹⡀⠉⢉⢟⡟⢿⢄⣔⣓⡾⣧⢰⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⢫⠸⠁⢡⠀⠸⠀⣧⣾⠢⡀⠹⠿⠇⡜⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠈⢄⠀⠀⠀⠀⠀⣼⣿⣷⠌⠐⢒⢮⣷⡦⢷⣦⡀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⠀⠀⠀⠑⢤⠀⢀⠸⣿⣿⣿⣯⡓⠉⠙⢷⣇⠈⣿⣿⣄⣤⠤⣶⡒⢧⠀\n" +
                                "⠀⠀⠀⠀⡔⣋⣩⣤⣾⣿⣿⣿⣿⣷⠤⢶⣓⢻⡋⢹⢹⡟⠛⢹⣏⣿⢸⡄\n" +
                                "⠀⢀⣀⣠⡿⢿⠿⢻⡛⢫⡝⡿⠛⠃⠀⣯⠙⡇⢳⣸⠀⣿⢋⡀⣯⠙⠇⣧\n" +
                                "⢹⡉⡷⢶⣴⡏⢻⡼⡿⠟⣧⢻⠛⢀⠀⠹⣤⠟⠀⣛⣀⣩⠭⠵⠖⠛⠛⠉\n" +
                                "⠘⡇⣷⠰⡆⣿⠙⣧⠿⢀⣙⣘⣯⠭⠴⠖⠚⠋⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀\n" +
                                "⠀⢻⣈⣻⠥⠼⠖⠚⠋⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");

                // Game ends
                }
            }
        }


    public static Map<String, Icon> getImageMap() {
        return imageMap;
    }

    public static void setImageMap(Map<String, Icon> imageMap) {
        Character.imageMap = imageMap;
    }



    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    @Override
    public Icon getIcon() {
        return icon;
    }

    @Override
    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public Icon getBack() {
        return back;
    }

    public void setBack(Icon back) {
        this.back = back;
    }



//    @Override
//    public void actionPerformed(ActionEvent e) {
//       if (this.isClicked) {
//           setIcon(this.icon);
//       }
//    }

    static {
        // populate the map when the class gets loaded
    }



}
