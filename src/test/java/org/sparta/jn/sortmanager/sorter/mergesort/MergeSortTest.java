package org.sparta.jn.sortmanager.sorter.mergesort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sparta.jn.sortmanager.sorters.mergesort.MergeSort;

public class MergeSortTest {

    @Test
    @DisplayName("Sort array of one length")
    void sortArrayOfOneLength() {
        int[] unsorted = {10};
        int[] expected = {10};
        MergeSort mergeSort = new MergeSort();
        int[] sorted = mergeSort.sortArray(unsorted);
        Assertions.assertArrayEquals(expected, sorted);
    }
  @Test
  @DisplayName("Sort unsorted array with 3 elements return a sorted array")
  void sortUnsortedArrayWith3ElementsReturnASortedArray() {
      int[] unsorted = {7, 1 ,9};
      int[] expected = {1, 7, 9};
      MergeSort mergeSort = new MergeSort();
      int[] sorted = mergeSort.sortArray(unsorted);
      Assertions.assertArrayEquals(expected, sorted);
  }

  @Test
  @DisplayName("Sort unsorted array with 10 elements return a sorted array")
  void sortUnsortedArrayWith10ElementsReturnASortedArray() {
      int[] unsorted = {7, 1 ,9, 45, 11, 12, 0, 100, 6, 25};
      int[] expected = {0, 1, 6, 7, 9, 11, 12, 25, 45, 100};
      MergeSort mergeSort = new MergeSort();
      int[] sorted = mergeSort.sortArray(unsorted);
      Assertions.assertArrayEquals(expected, sorted);
  }

    @Test
    @DisplayName("Sort an array with negative numbers should return sorted array")
    void sortAnArrayWithNegativeNumbersShouldReturnSortedArray() {
        int[] unsorted = {-26, 43, -44, -74, -19, 81, -33, -73, 57, 28};
        int[] expected = {-74, -73, -44, -33, -26, -19, 28, 43, 57, 81};
        MergeSort mergeSort = new MergeSort();
        int[] sorted = mergeSort.sortArray(unsorted);
        Assertions.assertArrayEquals(expected, sorted);
        
    }

}
