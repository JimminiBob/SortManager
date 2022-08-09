package org.sparta.jn.sortmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sparta.jn.sortmanager.sorters.mergesort.MergeSort;

import java.util.Arrays;

public class MergeSortTest {

    @Test
    @DisplayName("Sort array of one length")
    void sortArrayOfOneLength() {
        int[] unsorted = {10};
        MergeSort.intArrSort(unsorted);
        int[] expected = {10};
        Assertions.assertArrayEquals(expected, unsorted);
    }
  @Test
  @DisplayName("Sort unsorted array with 3 elements return a sorted array")
  void sortUnsortedArrayWith3ElementsReturnASortedArray() {
      int[] unsorted = {7, 1 ,9};
      MergeSort.intArrSort(unsorted);

      int[] expected = {1, 7, 9};
      Assertions.assertArrayEquals(expected, unsorted);
  }

  @Test
  @DisplayName("Sort unsorted array with 10 elements return a sorted array")
  void sortUnsortedArrayWith10ElementsReturnASortedArray() {
      int[] unsorted = {7, 1 ,9, 45, 11, 12, 0, 100, 6, 25};
      MergeSort.intArrSort(unsorted);

      int[] expected = {0, 1, 6, 7, 9, 11, 12, 25, 45, 100};
      Assertions.assertArrayEquals(expected, unsorted);

  }

}
