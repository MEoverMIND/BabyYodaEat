package com.eatyodaeat.model;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Character extends JButton {
    private String name;  // "yoda", "eggs", "trooper", "vader"
    private boolean isClicked = false;
    private Icon icon;
    private Icon back;
    private Icon front;


// ctor - only ctor and all fields required

    public Character(String name,Icon front, boolean isClicked, Icon back) {
        setFront(front);
        setName(name);
        setClicked(isClicked);
        setBack(back);
    }

    public void turnOver() {
        if(!isClicked) {
            setIcon(getFront());
            isClicked = true;
        }

    }


    // returns True or False if two characters match
    public boolean matches(Character other) {
        return this.name.equals(other.name);
    }

    // returns True or False if yoda matches egg match
    public boolean yodaEats(Character other) {
        return this.getName().equals("yoda") || this.getName().equals("food") &&
                other.getName().equals("yoda") || other.getName().equals("food") ;
    }

    // returns True or False if its vader
    public boolean isDarthVader() {
        return this.name.equals("vader");
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

    public Icon getFront() {
        return front;
    }

    public void setFront(Icon front) {
        this.front = front;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Character) {
            Character other = (Character) obj;
            result = Objects.equals(this.getName(),   other.getName());
        }
        return result;
    }
}
