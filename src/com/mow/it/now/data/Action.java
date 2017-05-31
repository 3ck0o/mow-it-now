package com.mow.it.now.data;

/**
 * Created by 3ck0o on 5/29/2017.
 */
public enum Action {
    RIGHT("D", 1),
    LEFT("G", -1),
    FORWARD("A", 0);

    private final String actionString;
    private final int rotationDirection;

    Action(String actionString, int rotationDirection) {
        this.actionString = actionString;
        this.rotationDirection = rotationDirection;
    }

    public String getActionString() {
        return actionString;
    }

    public int getRotationDirection() {
        return rotationDirection;
    }
}
