package org.sparta.jn.sortmanager.sorters;

public class QuickSort implements Sortable{
    private final String NAME = "QuickSort";
    @Override
    public int[] sortArray(int[] arrayToSort) {
        int[] arrOut = arrayToSort.clone();
        quickSort(arrOut, 0, arrOut.length - 1);
        return arrOut;
    }
    public int[] quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
        return arr;
    }

    private int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;
        return i+1;
    }


    @Override
    public String getSorterName() {
        return this.NAME;
    }

}