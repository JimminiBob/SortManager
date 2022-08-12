package org.sparta.jn.sortmanager.sorter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sparta.jn.sortmanager.sorters.QuickSort;
import org.sparta.jn.sortmanager.sorters.Sortable;
import org.sparta.jn.sortmanager.sorters.binarysort.BinarySort;
import org.sparta.jn.sortmanager.sorters.bubblesort.BubbleSort;
import org.sparta.jn.sortmanager.sorters.mergesort.MergeSort;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SortableTest {
    private static final Logger logger = Logger.getLogger("my logger");
    private static ConsoleHandler consoleHandler = new ConsoleHandler();


    @Test
    @DisplayName("All sortables able to sort an unsorted array and return sorted array")
    void allSortablesAbleToSortAnUnsortedArrayAndReturnSortedArray() {
        consoleHandler.setLevel(Level.INFO);
        Sortable bubbleSort = new BubbleSort();
        Sortable binarySort = new BinarySort();
        Sortable mergeSort = new MergeSort();
        Sortable quickSort = new QuickSort();

        int[] unsorted = {-26, 43, -44, -74, -19, 81, -33, -73, 57, 28};
        int[] sorted;
        int[] expected = {-74, -73, -44, -33, -26, -19, 28, 43, 57, 81};

//        bubbleSort.sortArray(unsorted);
//        logger.log(Level.INFO, "unsorted is " + Arrays.toString(unsorted));
        binarySort.sortArray(unsorted);
        logger.log(Level.INFO, "After binarySort unsorted is " + Arrays.toString(unsorted));
        mergeSort.sortArray(unsorted);
        logger.log(Level.INFO, "After mergeSort unsorted is " + Arrays.toString(unsorted));
        quickSort.sortArray(unsorted);
        logger.log(Level.INFO, "After quickSort unsorted is " + Arrays.toString(unsorted));
    }
}
