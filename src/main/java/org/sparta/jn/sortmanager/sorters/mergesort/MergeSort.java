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

        return ArrayMerger.merge(leftArray, rightArray);

    }

}
