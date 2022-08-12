package org.sparta.jn.sortmanager.sorters;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MergeSort implements Sortable {
    private static final Logger logger = Logger.getLogger("my logger");
    private static ConsoleHandler consoleHandler = new ConsoleHandler();
    private final String NAME = "MergeSort";

    @Override
    public int[] sortArray(int[] arrayToSort) {
        consoleHandler.setLevel(Level.INFO);
        logger.log(Level.INFO,"sortArray start arrayToSort is " + Arrays.toString(arrayToSort));
        int[] arrayOut = arrayToSort.clone();
        logger.log(Level.INFO,"sortArray end");
        return mergeSort(arrayOut);
    }

    private int[] mergeSort(int[] arrIn) {
        consoleHandler.setLevel(Level.INFO);
        logger.log(Level.INFO,"mergeSort start arrIn is " + Arrays.toString(arrIn));
        int arrInLength = arrIn.length;
        if (arrInLength < 2) {
            logger.log(Level.INFO, "(arrInLength < 2) started, arrInLength is " +arrInLength);
            return arrIn;
        }
        int mid = arrInLength / 2;
        int[] leftArray = new int[mid];
        int[] rightArray = new int[arrInLength - mid];

        for (int i = 0; i < mid; i++) {
            logger.log(Level.FINE, "forloop to assign leftArray, i is: " + i);
            leftArray[i] = arrIn[i];
        }
        logger.log(Level.FINE, "forloop to assign leftArray ended");

        logger.log(Level.INFO, "forloop to assign rightArray start");
        for (int i = mid; i < arrInLength ; i++) {
            logger.log(Level.FINE, "forloop to assign rightArray, i is: " + i);
            rightArray[i - mid] = arrIn[i];
        }
        logger.log(Level.INFO, "forloop to assign rightArray ended");

        mergeSort(leftArray);
        mergeSort(rightArray);

        merge(arrIn, leftArray, rightArray);
        logger.log(Level.INFO,"mergeSort start ended");
        return arrIn;
    }

    public void merge(int[] arrIn, int[] leftArray, int[] rightArray) {
        logger.log(Level.INFO,"merge method started");
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
        logger.log(Level.INFO,"merge method ended");
    }


    @Override
    public String getSorterName() {
        return this.NAME;
    }
}
