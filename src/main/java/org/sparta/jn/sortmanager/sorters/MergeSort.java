package org.sparta.jn.sortmanager.sorters;

public class MergeSort implements Sortable {
    private final String NAME = "MergeSort";

    @Override
    public int[] sortArray(int[] arrayToSort) {
        int[] arrayOut = arrayToSort.clone();
        return mergeSort(arrayOut);
    }

    private int[] mergeSort(int[] arrIn) {
        int arrInLength = arrIn.length;
        if (arrInLength < 2) {
            return arrIn;
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
        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(arrIn, leftArray, rightArray);
        return arrIn;
    }

    public void merge(int[] arrIn, int[] leftArray, int[] rightArray) {
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
    public String getSorterName() {
        return this.NAME;
    }

}
