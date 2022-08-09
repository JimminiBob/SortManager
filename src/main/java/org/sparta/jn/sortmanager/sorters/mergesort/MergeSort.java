package org.sparta.jn.sortmanager.sorters.mergesort;

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
            if (leftArray[leftArrPointer] < rightArray[leftArrPointer]) {
                arrIn[arrInPointer] = leftArray[leftArrPointer];
                leftArrPointer++;
            } else {
                arrIn[arrInPointer] = rightArray[rightArrPointer];
                rightArrPointer++;
            }
            arrInPointer++;
        }
    }
}
