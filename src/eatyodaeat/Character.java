package eatyodaeat;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Character extends JButton {
    private static Map<String,Icon> imageMap = new HashMap<>();
  "yoda"    Icon for yoda
  "eggs"     Icon for eggs

    private String name;  // "yoda", "eggs", "trooper", "vader"
    private boolean isClicked;

    public CharacterButton(String name) {
        setIconImage(imageMap.get(name));
    }

    public boolean matches(CharacterButton other) {
        return this.name.equals(other.name);
    }

    // maybe not
    public boolean isDarthVader() {
        return this.name.equals("vader");
    }

    static {
        // populate the map when the class gets loaded
    }

}
