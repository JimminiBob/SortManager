package org.sparta.jn.sortmanager.sorters.bubblesort;

import org.sparta.jn.sortmanager.logger.CustomFormatter;
import org.sparta.jn.sortmanager.sorters.Sortable;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BubbleSort implements Sortable {

    private static final Logger logger = Logger.getLogger("my logger");
    private static ConsoleHandler consoleHandler = new ConsoleHandler();


    public static int[] intArraySorter(int[] arrayIn) {
        consoleHandler.setFormatter(new CustomFormatter());
        logger.log(Level.INFO, "intArraySorter started");

        int[] arrayOut = arrayIn;
        int length = arrayIn.length;

        for (int i = 0; i < length - 1; i++) {
            logger.log(Level.FINE, "forloop for times to iterate started, i is " + i);

            for (int j = 0; j < length - i - 1; j++) {
                logger.log(Level.FINE, "forloop for comparison, i is " + i + "j is " + j);

                if (arrayOut[j] > arrayOut[j+1]) {
                    swapValue(arrayOut, j);
                }
            }
            logger.log(Level.FINE, "forloop for times to iterate ends");

        }
        logger.log(Level.INFO, "intArraySorter ends");

        return arrayOut;
    }

    private static void swapValue(int[] arrayToSwap, int j) {
        logger.log(Level.INFO, "intArraySorter ends");

        int temp = arrayToSwap[j];
        arrayToSwap[j] = arrayToSwap[j +1];
        arrayToSwap[j +1] = temp;
    }

    @Override
    public int[] sortArray(int[] arrayToSort) {
        return BubbleSort.intArraySorter(arrayToSort);
    }
}
