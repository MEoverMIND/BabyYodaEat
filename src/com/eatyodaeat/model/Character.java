package com.eatyodaeat.model;

import javax.swing.*;
import java.util.Objects;

public class Character extends JButton {
    private String name;
    private boolean isClicked = false;
    private Icon icon;
    private Icon back;
    private Icon front;


// ctor - only ctor and all fields required

    public Character(String name, Icon front, boolean isClicked, Icon back) {
        setFront(front);
        setName(name);
        setClicked(isClicked);
        setBack(back);
        setActionCommand(name);

    }

    public void turnOver() {

        setIcon(front);
        isClicked = true;

    }
    // not used in current iteration, but plan to implement in future state
    public void flip() {
        setIcon(getBack());
        isClicked = false;

    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    // not used in current iteration, but plan to implement in future state
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

    // not used in current iteration, but plan to implement in future state
    public Icon getFront() {
        return front;
    }

    public void setFront(Icon front) {
        this.front = front;
    }

    // equals and Hash override for SET



    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Character) {
            Character other = (Character) obj;
            result = Objects.equals(this.getName(), other.getName());
        }
        return result;
    }
}
