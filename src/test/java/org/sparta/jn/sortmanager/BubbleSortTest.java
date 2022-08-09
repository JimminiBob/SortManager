package org.sparta.jn.sortmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sparta.jn.sortmanager.sorts.BubbleSort;

public class BubbleSortTest {
    @Test
    @DisplayName("Test If array has 1 number then no change")
    void testIfArrayHas1NumberThenNoChange() {
        int[] numbers = {99};
        int[] expected = {99};
        int[] sorted = BubbleSort.intArraySorter(numbers);
        Assertions.assertArrayEquals(expected, sorted);

    }

    @Test
    @DisplayName("Test an unsorted array should return a sorted array")
    void testAnUnsortedArrayShouldReturnASortedArray() {
        int[] numbers = {99, 1, 4, 2, 32, -1};
        int[] sorted = BubbleSort.intArraySorter(numbers);
        int[] expected = {-1, 1 , 2, 4, 32, 99};

        Assertions.assertArrayEquals(expected, sorted);

        //        Assertions.assertAll((() -> Assertions.assertEquals(-1,sorted[0])),
//                            () -> Assertions.assertEquals(1,sorted[1]),
//                            () -> Assertions.assertEquals(2,sorted[2]),
//                            () -> Assertions.assertEquals(4,sorted[3]),
//                            () -> Assertions.assertEquals(32,sorted[4]),
//                            () -> Assertions.assertEquals(99,sorted[5]));
    }

    @Test
    @DisplayName("Test for all negative numbers in array should return sorted array")
    void testForAllNegativeNumbersInArrayShouldReturnSortedArray() {
        int[] numbers = {-99, -1, -4, -2, -32, -1};
        int[] sorted = BubbleSort.intArraySorter(numbers);
        int[] expected = {-99, -32, -4, -2, -1, -1};
        Assertions.assertArrayEquals(expected, sorted);
    }

    @Test
    @DisplayName("Test with max integer value in array and returns a sorted away")
    void testWithMaxIntegerValueInArrayAndReturnsASortedAway() {
        int[] numbers = {99, 1, Integer.MAX_VALUE,4 , 2, 32, -1};
        int[] sorted = BubbleSort.intArraySorter(numbers);
        int[] expected = {-1, 1 , 2, 4, 32, 99, Integer.MAX_VALUE};
        Assertions.assertArrayEquals(expected, sorted);
    }

    @Test
    @DisplayName("Test with min integer value in an array and returns a sorted away")
    void testWithMinIntegerValueInAnArrayAndReturnsASortedAway() {
        int[] numbers = {99, 1, Integer.MIN_VALUE,4 , 2, 32, -1};
        int[] sorted = BubbleSort.intArraySorter(numbers);
        int[] expected = {Integer.MIN_VALUE, -1, 1 , 2, 4, 32, 99};
        Assertions.assertArrayEquals(expected, sorted);
    }
}
