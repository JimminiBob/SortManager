package org.sparta.jn.logging;

import java.io.IOException;
import java.util.logging.*;

public class App {
    //Handler - Where do I log to?
    //Aspect Oriented Programming - AOP

    private static final Logger logger = Logger.getLogger("my logger");
    public static void main(String[] args) {
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL); // Logger and ConsoleHandler are separate
        consoleHandler.setFilter(new CustomFilter());

        try {
            FileHandler fileHandler = new FileHandler("src/main/resources/mylog.log", true); //true wont override
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new CustomFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        logger.addHandler(consoleHandler);
        logger.setLevel(Level.ALL);
        logger.setUseParentHandlers(false); //turn of root logger's handlers

        logger.log(Level.INFO, "This is an info message");
        logger.log(Level.WARNING, "This is a warning message");
        logger.log(Level.FINE, "This is a fine message Hello");


    }
}
