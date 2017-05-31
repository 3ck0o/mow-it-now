package com.mow.it.now;

import com.mow.it.now.data.Field;
import com.mow.it.now.data.Mower;
import com.mow.it.now.services.MowerService;
import com.mow.it.now.services.ParserService;
import com.mow.it.now.services.impl.MowerServiceImpl;
import com.mow.it.now.services.impl.ParserServiceImpl;

/**
 * Created by 3ck0o on 5/29/2017.
 */
public class MowerManager {

    private final MowerService mowerServiceImpl = new MowerServiceImpl();
    private final ParserService parserServiceImpl = new ParserServiceImpl();

    public void start() {
        test();
    }

    private void test() {
        Field field = parserServiceImpl.parseField("5 5");
        Mower mower1 = new Mower(parserServiceImpl.parseMowerPosition("1 2 N"), field);
        mowerServiceImpl.moveMower(mower1, parserServiceImpl.parseMowerActions("GAGAGAGAA"));
        Mower mower2 = new Mower(parserServiceImpl.parseMowerPosition("3 3 E"), field);
        mowerServiceImpl.moveMower(mower2, parserServiceImpl.parseMowerActions("AADAADADDA"));

        System.out.println(mower1.getPosition());
        System.out.println(mower2.getPosition());
    }

}
