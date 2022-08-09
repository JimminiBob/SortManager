package org.sparta.jn.sortmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sparta.jn.sortmanager.sorts.ArrayMerger;

import java.util.Arrays;

public class ArrayMergerTest {
    @Test
    @DisplayName("Merges two sorted arrays and returns a merged sorted array")
    void mergesTwoSortedArraysAndReturnsAMergedArray() {
        int[] ints1 = {2, 14, 22, 23, 65, 99};
        int[] ints2 = {9, 11, 32, 46, 62, 100, 929};
        int[] expected = {2, 14, 22, 23, 65, 99, 9, 11, 32, 46, 62, 100, 929};
        Arrays.sort(expected);
        Assertions.assertArrayEquals(expected, ArrayMerger.merge(ints1, ints2));
    }

     @Test
     @DisplayName("Merges two negative numbers array and returns a merged sorted array")
     void mergesTwoNegativeNumbersArrayAndReturnsAMergedSortedArray() {
         int[] ints1 = {-122, -98, -88, -53, -42};
         int[] ints2 = {-200, -152,-72, -41, -12};
         int[] expected = {-122, -98, -88, -53, -42, -200, -152,-72, -41, -12};
         Arrays.sort(expected);
         Assertions.assertArrayEquals(expected, ArrayMerger.merge(ints1, ints2));

     }

     @Test
     @DisplayName("Merge two arrays with a single element and returns a merged sorted array")
     void mergeTwoArraysWithASingleElementAndReturnsAMergedSortedArray() {
         int[] int1 = {0};
         int[] int2 = {99};
         int[] expected = {0, 99};
         Assertions.assertArrayEquals(expected, ArrayMerger.merge(int1, int2));
     }
     
     @Test
     @DisplayName("Merge two arrays with a single element of the same value and returns a merged sorted array ")
     void mergeTwoArraysWithASingleElementOfTheSameValueAndReturnsAMergedSortedArray() {
         int[] int1 = {5};
         int[] int2 = {5};
         int[] expected = {5, 5};
         Assertions.assertArrayEquals(expected, ArrayMerger.merge(int1, int2));
     }
     
     @Test
     @DisplayName("Merge two arrays with the maximum integer value and still returns a merged sorted array")
     void mergeToArraysWithTheMaximumIntegerValueAndStillReturnsAMergedSortedArray() {
         int[] int1 = {3, Integer.MAX_VALUE};
         int[] int2 = {5, Integer.MAX_VALUE};
         int[] expected = {3, 5, Integer.MAX_VALUE, Integer.MAX_VALUE};
         Assertions.assertArrayEquals(expected, ArrayMerger.merge(int1, int2));
     }

    @Test
    @DisplayName("Merge two arrays one with max in and other with min int and should return sorted merged int")
    void mergeTwoArraysOneWithMaxInAndOtherWithMinIntAndShouldReturnSortedMergedInt() {
        int[] int1 = {3, 50, Integer.MAX_VALUE};
        int[] int2 = {Integer.MIN_VALUE, 5, 10};
        int[] expected = {Integer.MIN_VALUE, 3, 5, 10 , 50, Integer.MAX_VALUE};
        Assertions.assertArrayEquals(expected, ArrayMerger.merge(int1, int2));

    }
}
