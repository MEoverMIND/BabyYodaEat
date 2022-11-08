package com.eatyodaeat.model;

/**
 * Logic for comparing two flipped tile
 */


public class FlippedTile {
    private final Tile tileName;
    private final int id;
    private boolean Isflipped;
    private boolean Isdone;


    //ctor
    public FlippedTile(Tile tileName, int id, boolean Isflipped) {
        this.tileName = tileName;
        this.id = id;
        this.Isflipped = Isflipped;
        this.Isdone = false;
    }

    public void flip() {
        this.Isflipped = !this.Isflipped;
    }


    public Tile getTileName() {
        return tileName;
    }

    public int getId() {
        return id;
    }

    public boolean isIsflipped() {
        return Isflipped;
    }

    public void setIsflipped(boolean isflipped) {
        Isflipped = isflipped;
    }

    public boolean isIsdone() {
        return Isdone;
    }

    public void setIsdone() {
       this.Isdone = true;
    }

    public boolean isMatch(FlippedTile tile) {
        return tile.getTileName() == this.tileName;
    }


    /*
     * Overridden hashcode generator to use the card's ID
     *
     * @return the hash code of this card's ID
     */

    @Override
    public boolean equals(Object tiles) {
        if (this == tiles) return true;
        if (tiles == null || getClass() != tiles.getClass())
            return false;
        FlippedTile that = (FlippedTile) tiles;
        return id == that.id &&
                tileName == that.tileName;
    }
}