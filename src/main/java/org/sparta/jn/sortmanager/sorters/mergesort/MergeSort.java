package org.sparta.jn.sortmanager.sorters.mergesort;

import org.sparta.jn.sortmanager.sorters.Sortable;

public class MergeSort implements Sortable {
    private final String NAME = "MergeSort";

    public static int[] sort(int[] arrIn) {
        int[] arrOut = arrIn;
        int arrInLength = arrOut.length;
        if (arrInLength < 2) {
            return arrOut;
        }
        int mid = arrInLength / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[arrInLength - mid];

        for (int i = 0; i < mid; i++) {
            leftArray[i] = arrOut[i];
        }
        for (int i = mid; i < arrInLength ; i++) {
            rightArray[i - mid] = arrOut[i];
        }
        sort(leftArray);
        sort(rightArray);

        merge(arrOut, leftArray, rightArray);
        return arrOut;
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

    @Override
    public int[] sortArray(int[] arrayToSort) {
        return sort(arrayToSort);
    }

    @Override
    public String getSorterName() {
        return this.NAME;
    }

}
