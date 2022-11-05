package com.eatyodaeat;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Character extends JButton {
    private static Map<String,Icon> imageMap = new HashMap<>();
    private String name;  // "yoda", "eggs", "trooper", "vader"
    private boolean isClicked;
    private Icon icon;

    // ctor - only ctor and all fields required
    public Character(String name,Icon icon, boolean isClicked) {
        setName(name);
        setIcon(icon);
        setClicked(isClicked);
    }


    // returns True or False if two charactrs match
    public boolean matches(Character other) {
        return this.name.equals(other.name);
    }

    // maybe not
    public boolean isDarthVader() {
        return this.name.equals("vader");

        // TODO will some how trigger a game over

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

    static {
        // populate the map when the class gets loaded
    }

}
