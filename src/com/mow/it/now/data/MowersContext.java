package com.mow.it.now.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 3ck0o on 6/1/2017.
 */
public class MowersContext {

    private Field field;
    private List<Mower> mowers = new ArrayList<>();

    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }

    public List<Mower> getMowers() {
        return mowers;
    }

    public void setMowers(List<Mower> mowers) {
        this.mowers = mowers;
    }

    public Mower getCurrentMower() {
        return mowers.get(mowers.size() - 1);
    }
}
