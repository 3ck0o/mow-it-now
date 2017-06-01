package com.mow.it.now;

import com.mow.it.now.data.Mower;

import java.util.List;

/**
 * Created by 3ck0o on 5/29/2017.
 */
public class Main {

    public static void main(String[] args) {
        MowerManager mowerManager = new MowerManager();
        List<Mower> mowers = mowerManager.processCommandFile(args[0]);
        mowers.forEach(mower -> System.out.println(mower.getPosition()));
    }
}
