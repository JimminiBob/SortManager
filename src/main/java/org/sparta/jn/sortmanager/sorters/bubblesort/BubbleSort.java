package org.sparta.jn.sortmanager.sorters.bubblesort;

public class BubbleSort {
    public static int[] intArraySorter(int[] arrayIn) {
        int[] arrayOut = arrayIn;
        int length = arrayIn.length;

        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arrayOut[j] > arrayOut[j+1]) {
                    swapValue(arrayOut, j);
                }
            }
        }
        return arrayOut;
    }

    private static void swapValue(int[] arrayToSwap, int j) {
        int temp = arrayToSwap[j];
        arrayToSwap[j] = arrayToSwap[j +1];
        arrayToSwap[j +1] = temp;
    }
}
