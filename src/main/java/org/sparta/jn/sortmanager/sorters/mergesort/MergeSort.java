package org.sparta.jn.sortmanager.sorters.mergesort;

import org.sparta.jn.sortmanager.RandomIntArray;

import java.util.Arrays;

public class MergeSort {

    public static void intArrSort(int[] arrIn) {
        int arrInLength = arrIn.length;
        if (arrInLength < 2) {
            return;
        }
        int mid = arrInLength / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[arrInLength - mid];

        for (int i = 0; i < mid; i++) {
            leftArray[i] = arrIn[i];
        }
        for (int i = mid; i < arrInLength ; i++) {
            rightArray[i - mid] = arrIn[i];
        }
        intArrSort(leftArray);
        intArrSort(rightArray);

        merge(arrIn, leftArray, rightArray);
    }

    private static void merge(int[] arrIn, int[] leftArray, int[] rightArray) {
        int leftLength = leftArray.length;
        int rightLength = rightArray.length;

        int leftArrPointer = 0;
        int rightArrPointer = 0;
        int arrInPointer = 0;

        while (leftArrPointer < leftLength && rightArrPointer < rightLength) {
            if (leftArray[leftArrPointer] < rightArray[rightArrPointer]) {
                arrIn[arrInPointer] = leftArray[leftArrPointer];
                leftArrPointer++;
            } else {
                arrIn[arrInPointer] = rightArray[rightArrPointer];
                rightArrPointer++;
            }
            arrInPointer++;
        }
        if (leftArrPointer == leftLength) {
            for (int i = rightArrPointer; i < rightLength; i++) {
                arrIn[arrInPointer] = rightArray[rightArrPointer];
                rightArrPointer++;
                arrInPointer++;
            }
        } else {
            for (int i = leftArrPointer; i < leftLength; i++) {
                arrIn[arrInPointer] = leftArray[leftArrPointer];
                leftArrPointer++;
                arrInPointer++;
            }
        }
    }

//    public static void main(String[] args) {
//        RandomIntArray arrayGen = new RandomIntArray();
//        int[] arr1 = arrayGen.build(5);
//        int[] arr2 = arrayGen.build(5);
//        int[] arr3 = new int[10];
//        Arrays.sort(arr1);
//        Arrays.sort(arr2);
//
//        MergeSort.merge(arr3,arr1,arr2);
//
//        System.out.println("arr1 is " + Arrays.toString(arr1));
//        System.out.println("arr2 is " + Arrays.toString(arr2));
//        System.out.println("arr3 is " + Arrays.toString(arr3));
//    }
}
