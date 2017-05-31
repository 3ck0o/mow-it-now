package com.mow.it.now.data;

/**
 * Created by 3ck0o on 5/29/2017.
 */
public class Field {

    private int width, length;

    public Field(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
