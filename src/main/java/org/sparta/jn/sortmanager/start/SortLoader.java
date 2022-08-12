package org.sparta.jn.sortmanager.start;


import org.sparta.jn.sortmanager.display.DisplayManager;
import org.sparta.jn.sortmanager.exceptions.SortLoaderException;
import org.sparta.jn.sortmanager.logger.CustomFormatter;
import org.sparta.jn.sortmanager.sorters.Sortable;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

//Order of operation
public class SortLoader {
    private static final Logger logger = Logger.getLogger("my logger");
//    private static ConsoleHandler consoleHandler = new ConsoleHandler();

    public static void start() {
        DisplayManager.printSorterChoice();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        Sortable sortable = SortFactory.getSorter(choice);
        logger.log(Level.INFO, "sortable is " + sortable.getClass());

        DisplayManager.printRequestArraySize();
        choice = scanner.nextInt();

        int[] arrayToSort = IntArrayGenerator.build(choice);
        logger.log(Level.INFO, "arrayToSort is " + Arrays.toString(arrayToSort));

        long start = System.nanoTime();
        int[] sortedArray = sortable.sortArray(arrayToSort);
        long end = System.nanoTime();
        long sortTime = end - start;

        logger.log(Level.INFO, "arrayToSort is " + Arrays.toString(arrayToSort));
        logger.log(Level.INFO, "sortedArray is " + Arrays.toString(sortedArray));

        DisplayManager.printResults(sortable.getSorterName(), arrayToSort, sortedArray, sortTime
        );
    }


    public static void main(String[] args) {
        start();
    }

}
