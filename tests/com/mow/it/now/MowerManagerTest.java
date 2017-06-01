package com.mow.it.now;

import com.mow.it.now.data.Direction;
import com.mow.it.now.data.Mower;
import com.mow.it.now.data.Position;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.api.Assertions;

/**
 * Created by 3ck0o on 6/1/2017.
 */
class MowerManagerTest {

    private static final String MOWER_COMMANDS_TESTING_FILE = "default_mower_commands.txt";

    private final MowerManager testObj = new MowerManager();

    @Test
    void processCommandFile() {
        List<Mower> mowers = testObj.processCommandFile(MOWER_COMMANDS_TESTING_FILE);

        Assertions.assertEquals(mowers.size(), 2);
        Assertions.assertEquals(mowers.get(0).getPosition(), new Position(1, 3, Direction.NORTH));
        Assertions.assertEquals(mowers.get(1).getPosition(), new Position(5, 1, Direction.EAST));
    }

}