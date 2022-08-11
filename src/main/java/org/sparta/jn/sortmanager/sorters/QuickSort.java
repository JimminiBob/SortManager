package org.sparta.jn.sortmanager.sorters;

public class QuickSort implements Sortable{
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
    public int[] sortArray(int[] arrayToSort) {
        return quickSort(arrayToSort, 0, arrayToSort.length - 1);
    }

//        public static void main(String[] args) {
//        int[] unsorted = {-26, 43, -44, -74, -19, 81, -33, -73, 57, 28};
//        int[] expected = {-74, -73, -44, -33, -26, -19, 28, 43, 57, 81};
//
//        System.out.println("arr3 is " + Arrays.toString(new QuickSort().sortArray(unsorted)));
//    }
}