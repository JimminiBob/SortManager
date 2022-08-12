package org.sparta.jn.sortmanager.sorters;

import org.sparta.jn.sortmanager.logger.CustomFormatter;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BubbleSort implements Sortable {
    private final String NAME = "BubbleSort";

    private static final Logger logger = Logger.getLogger("my logger");
    private static ConsoleHandler consoleHandler = new ConsoleHandler();

    public static int[] intArraySorter(int[] arrayIn) {
        consoleHandler.setFormatter(new CustomFormatter());
        consoleHandler.setLevel(Level.INFO);
        logger.log(Level.INFO, "intArraySorter started");

        int[] arrayOut = arrayIn.clone();
        int length = arrayIn.length;

        for (int i = 0; i < length - 1; i++) {
            logger.log(Level.FINE, "forloop for times to iterate, i is " + i);

            for (int j = 0; j < length - i - 1; j++) {
                logger.log(Level.FINE, "forloop for comparison, i is " + i + "j is " + j);

                if (arrayOut[j] > arrayOut[j+1]) {
                    swapValue(arrayOut, j);
                }
            }
            logger.log(Level.FINE, "forloop for times to iterate ends");

        }
        logger.log(Level.INFO, "intArraySorter method ends");
        return arrayOut;
    }

    private static void swapValue(int[] arrayToSwap, int j) {
        consoleHandler.setFormatter(new CustomFormatter());
        consoleHandler.setLevel(Level.INFO);
        logger.log(Level.FINE, "swapValue starts arrayToSwap: "
                + Arrays.toString(arrayToSwap) + " j is: " + j);

        int temp = arrayToSwap[j];
        arrayToSwap[j] = arrayToSwap[j +1];
        arrayToSwap[j +1] = temp;
        logger.log(Level.FINE, "swapValue method ends");

    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        return BubbleSort.intArraySorter(arrayToSort);
    }

    @Override
    public String getSorterName() {
        return this.NAME;
    }
}
