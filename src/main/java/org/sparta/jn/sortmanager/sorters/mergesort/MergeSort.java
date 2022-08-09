package org.sparta.jn.sortmanager.sorters.mergesort;

public class MergeSort {

    public static int[] intArrSort(int[] arrIn) {
        int[] arrayToSort = arrIn;
        if (arrIn.length <= 1) {
            return arrayToSort;
        }
        int mid = arrIn.length / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[arrIn.length - mid];

        for (int i = 0; i < mid; i++) {
            leftArray[i] = arrayToSort[i];
        }
        for (int i = mid; i < arrIn.length ; i++) {
            rightArray[i - mid] = arrayToSort[i];
        }
        intArrSort(leftArray);
        intArrSort(rightArray);

        arrayToSort = ArrayMerger.merge(leftArray, rightArray);

        return arrayToSort;
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
