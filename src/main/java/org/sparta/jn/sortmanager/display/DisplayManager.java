package org.sparta.jn.sortmanager.display;

import org.sparta.jn.sortmanager.sorters.Sortable;
import org.sparta.jn.sortmanager.start.SortFactory;

import java.util.Arrays;
public class DisplayManager {

    public static void printSorterChoice() {
        System.out.println("Enter the number of the sorter you wish to use");
        int i = 1;
        for (String elements: SortFactory.getSorterStrList()) {
            System.out.println((i++ + ", " + elements));
        }
    }

    public static void printRequestArraySize() {
        System.out.println("Enter array size to sort");
    }

    public static void printResults(Sortable sortable, int[] arrayToSort) {
        System.out.println("Using " + sortable.getSorterName() + " to sort:");
        System.out.println(Arrays.toString(arrayToSort));
        int[] sortedArray = sortable.sortArray(arrayToSort);
        System.out.println("Results: \n" + Arrays.toString(sortedArray));
    }
}
