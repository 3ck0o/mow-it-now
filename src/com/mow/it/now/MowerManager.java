package com.mow.it.now;

import com.mow.it.now.data.*;
import com.mow.it.now.exceptions.IllegalCommandException;
import com.mow.it.now.services.MowerService;
import com.mow.it.now.services.ParserService;
import com.mow.it.now.services.impl.MowerServiceImpl;
import com.mow.it.now.services.impl.ParserServiceImpl;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 * Created by 3ck0o on 5/29/2017.
 */
public class MowerManager {

    private final MowerService mowerServiceImpl = new MowerServiceImpl();
    private final ParserService parserServiceImpl = new ParserServiceImpl();

    public List<Mower> processCommandFile(String fineName) {
        MowersContext context = new MowersContext();

        try {
            Stream<String> lines = Files.lines(Paths.get(fineName), Charset.forName("utf-8"));
            lines.forEach(line -> handleCommand(line, context));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return context.getMowers();
    }

    private void handleCommand(String line, MowersContext context) {
        if (context.getField() == null) {
            Field newField = parserServiceImpl.parseField(line);
            if (newField != null) {
                context.setField(newField);
                return;
            }
            throw new IllegalCommandException(format("A field has to be created before line : '%s'", line));
        }

        if (context.getMowers().isEmpty()) {
            Position newMowerPosition = parserServiceImpl.parseMowerPosition(line);
            if (newMowerPosition != null) {
                context.getMowers().add(new Mower(newMowerPosition, context.getField()));
                return;
            }
            throw new IllegalCommandException(format("A mower has to be created before line : '%s'", line));
        }

        Position newMowerPosition = parserServiceImpl.parseMowerPosition(line);
        if (newMowerPosition != null) {
            context.getMowers().add(new Mower(newMowerPosition, context.getField()));
            return;
        }

        List<Action> actions = parserServiceImpl.parseMowerActions(line);
        if (!actions.isEmpty()) {
            mowerServiceImpl.moveMower(context.getCurrentMower(), actions);
            return;
        }

        throw new IllegalCommandException(format("Impossible to parse line: '%s'", line));
    }

}
