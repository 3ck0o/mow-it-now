package com.mow.it.now.services;

import com.mow.it.now.data.Action;
import com.mow.it.now.data.Mower;

import java.util.List;

/**
 * Created by 3ck0o on 5/31/2017.
 */
public interface MowerService {

    /**
     * Moves the mower according to the action
     *
     * @param mower The mower to move
     * @param action The action to perform
     * @return true if the action was performed successfully, false otherwise
     */
    boolean moveMower(Mower mower, Action action);

    /**
     * Moves the mower according to the list of actions
     *
     * @param mower The mower to move
     * @param actions The list of actions to perform
     * @return true if the actions were performed successfully, false otherwise
     */
    boolean moveMower(Mower mower, List<Action> actions);
}
