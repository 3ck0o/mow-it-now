package com.mow.it.now.data;

/**
 * Created by 3ck0o on 5/29/2017.
 */
public class Position {
    private Coordinates coordinates;
    private Direction direction;

    public Position(Coordinates coordinates, Direction direction) {
        this.coordinates = coordinates;
        this.direction = direction;
    }

    public Position(int x, int y, Direction direction) {
        this.coordinates = new Coordinates(x, y);
        this.direction = direction;
    }

    public Position(Position positionData) {
        this.coordinates = positionData.coordinates;
        this.direction = positionData.direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return String.format("%s %s", coordinates, direction.getString());
    }
}
