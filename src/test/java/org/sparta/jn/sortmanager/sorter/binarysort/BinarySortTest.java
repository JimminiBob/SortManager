package org.sparta.jn.sortmanager.sorter.binarysort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sparta.jn.sortmanager.sorters.Sortable;
import org.sparta.jn.sortmanager.sorters.binarysort.BinarySort;
import org.sparta.jn.sortmanager.start.IntArrayGenerator;

import java.util.Arrays;

public class BinarySortTest {
    @Test
    @DisplayName("Sorts an array with 10 elements")
    void sortsAnArrayWith10Elements() {
        int[] unsorted = {-26, 43, -44, -74, -19, 81, -33, -73, 57, 28};
        int[] expected = {-74, -73, -44, -33, -26, -19, 28, 43, 57, 81};
        Sortable binarySort = new BinarySort();
        int[] sorted = binarySort.sortArray(unsorted);
        Assertions.assertArrayEquals(expected, sorted);

    }

}
