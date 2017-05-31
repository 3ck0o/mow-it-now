package com.mow.it.now.data;

/**
 * Created by 3ck0o on 5/29/2017.
 */
public class Mower {

    private Position position;
    private Field field;

    public Mower(Position position, Field field) {
        this.position = position;
        this.field = field;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position mowerPosition) {
        this.position = mowerPosition;
    }

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
