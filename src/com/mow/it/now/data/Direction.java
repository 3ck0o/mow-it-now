package com.mow.it.now.data;

/**
 * Created by 3ck0o on 5/29/2017.
 */
public enum Direction {
    NORTH("N", 0, 1), EAST("E", 1, 0), SOUTH("S", 0, -1), WEST("W", -1, 0);

    private final String directionString;
    private final Coordinates forwardCoordinates;

    Direction(String directionString, int xForward, int yForward) {
        this.directionString = directionString;
        this.forwardCoordinates = new Coordinates(xForward, yForward);
    }

    public String getString() {
        return directionString;
    }

    public Coordinates getForwardCoordinates() {
        return forwardCoordinates;
    }
}
