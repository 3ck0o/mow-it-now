package com.mow.it.now.services.impl;

import com.mow.it.now.data.*;
import com.mow.it.now.services.MowerService;

import java.util.ArrayList;
import java.util.List;

import static com.mow.it.now.utils.CoordinatesUtils.sum;

/**
 * Created by 3ck0o on 5/29/2017.
 */
public class MowerServiceImpl implements MowerService {

    private List<Direction> orderedDirections = new ArrayList<>();

    public MowerServiceImpl() {
        orderedDirections.add(Direction.NORTH);
        orderedDirections.add(Direction.EAST);
        orderedDirections.add(Direction.SOUTH);
        orderedDirections.add(Direction.WEST);
    }

    @Override
    public boolean moveMower(Mower mower, List<Action> actions) {
        for (Action action : actions) {
            if(!moveMower(mower, action)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean moveMower(Mower mower, Action action) {
        if (action == Action.LEFT || action == Action.RIGHT) {
            return rotateMower(mower, action);
        }
        if (action == Action.FORWARD) {
            return moveMowerForward(mower);
        }
        return false;
    }

    private boolean moveMowerForward(Mower mower) {
        Position mowerPosition = mower.getPosition();
        Coordinates forwardCoordinates = mowerPosition.getDirection().getForwardCoordinates();
        Coordinates newMowerCoordinates = sum(mowerPosition.getCoordinates(), forwardCoordinates);
        if (mowerPositionIsInvalid(newMowerCoordinates, mower.getField())) {
            return false;
        }
        mowerPosition.setCoordinates(newMowerCoordinates);
        return true;
    }

    private boolean mowerPositionIsInvalid(Coordinates mowerCoordinates, Field field) {
        return mowerCoordinates.getX() > field.getWidth()
                || mowerCoordinates.getY() > field.getLength()
                || mowerCoordinates.getX() < 0
                || mowerCoordinates.getY() < 0;
    }

    private boolean rotateMower(Mower mower, Action action) {
        Position mowerPosition = mower.getPosition();
        mowerPosition.setDirection(getNewDirectionAfterAction(mowerPosition.getDirection(), action));
        return true;
    }

    private Direction getNewDirectionAfterAction(Direction direction, Action action) {
        int newDirectionIndex = (orderedDirections.indexOf(direction) + action.getRotationDirection() + 4) % 4;
        return orderedDirections.get(newDirectionIndex);
    }
}
