package com.mow.it.now.services.impl;

import com.mow.it.now.data.Action;
import com.mow.it.now.data.Direction;
import com.mow.it.now.data.Field;
import com.mow.it.now.data.Position;
import com.mow.it.now.services.ParserService;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 3ck0o on 5/29/2017.
 */
public class ParserServiceImpl implements ParserService {

    private static final String FIELD_LINE_REGEX = "^(\\d+?)\\s(\\d+?)$";
    private static final String MOWER_POSITION_LINE_REGEX = "^(\\d+?)\\s(\\d+?)\\s([NEWS])$";
    private static final String MOWER_ACTIONS_LINE_REGEX = "^([GAD]+)$";

    @Override
    public Field parseField(String line) {
        Matcher matcher = Pattern.compile(FIELD_LINE_REGEX).matcher(line);
        if (!matcher.find()) {
            return null;
        }
        return new Field(Integer.valueOf(matcher.group(1)), Integer.valueOf(matcher.group(2)));
    }

    @Override
    public Position parseMowerPosition(String line) {
        Matcher matcher = Pattern.compile(MOWER_POSITION_LINE_REGEX).matcher(line);
        if (!matcher.find()) {
            return null;
        }
        return new Position(Integer.valueOf(matcher.group(1)),
                Integer.valueOf(matcher.group(2)),
                getDirection(matcher.group(3)));
    }

    @Override
    public List<Action> parseMowerActions(String line) {
        Matcher matcher = Pattern.compile(MOWER_ACTIONS_LINE_REGEX).matcher(line);
        ArrayList<Action> output = new ArrayList<>();
        if (!matcher.find()) {
            return output;
        }
        String[] actions = line.split("");
        for (String actionToParse : actions) {
            output.add(getAction(actionToParse));
        }
        return output;
    }

    private Direction getDirection(String directionToParse) {
        Direction[] directions = Direction.values();
        for (Direction direction : directions) {
            if (direction.getString().equals(directionToParse)) {
                return direction;
            }
        }
        return null;
    }

    private Action getAction(String actionToParse) {
        Action[] actions = Action.values();
        for (Action action : actions) {
            if (action.getActionString().equals(actionToParse)) {
                return action;
            }
        }
        return null;
    }

}
