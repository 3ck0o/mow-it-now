package com.mow.it.now.services;

import com.mow.it.now.data.Action;
import com.mow.it.now.data.Field;
import com.mow.it.now.data.Position;

import java.util.List;

/**
 * Created by 3ck0o on 5/31/2017.
 */
public interface ParserService {

    /**
     * Parse a line of command containing the field coordinates
     *
     * @param line The line to parse (Ex: 5 5)
     * @return A new field
     */
    Field parseField(String line);

    /**
     * Parse a line of command containing the mower position
     *
     * @param line The line to parse (Ex: 3 3 N)
     * @return A mower position
     */
    Position parseMowerPosition(String line);

    /**
     * Parse a line of command containing the mower actions
     *
     * @param line The line to parse (Ex: DAGAAAAADAGAA)
     * @return A list of actions to perform
     */
    List<Action> parseMowerActions(String line);
}
