package com.mow.it.now.data;

/**
 * Created by 3ck0o on 5/30/2017.
 */
public class Coordinates {
    private int x, y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("%s %s", x, y);
    }
}
