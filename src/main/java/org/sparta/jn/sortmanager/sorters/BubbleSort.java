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
    @Override
    public int[] sortArray(int[] arrIn) {
        int[] arrToSort = arrIn.clone();
        BubbleSort.intArraySorter(arrToSort);
        return arrToSort;
    }
    public static int[] intArraySorter(int[] arrToSort) {
        consoleHandler.setLevel(Level.INFO);
        logger.log(Level.INFO, "intArraySorter started");
        int length = arrToSort.length;

        for (int i = 0; i < length - 1; i++) {
            logger.log(Level.FINE, "forloop for times to iterate, i is " + i);

            for (int j = 0; j < length - i - 1; j++) {
                logger.log(Level.FINE, "forloop for comparison, i is " + i + "j is " + j);

                if (arrToSort[j] > arrToSort[j+1]) {
                    swapValue(arrToSort, j);
                }
            }
            logger.log(Level.FINE, "forloop for times to iterate ends");

        }
        logger.log(Level.INFO, "intArraySorter method ends");
        return arrToSort;
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
    public String getSorterName() {
        return this.NAME;
    }
}
