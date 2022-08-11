package org.sparta.jn.sortmanager.start;

import java.util.Arrays;
import java.util.Random;

public class IntArrayGenerator {

    public int[] build(int length) {
        int[] randomArr = new int[length];
        Random rd = new Random();
        for (int i = 0; i < length; i++) {
            randomArr[i] = rd.nextInt(-100, 100);
        }
        return randomArr;
    }

    public static void main(String[] args) {

        IntArrayGenerator randArrGen = new IntArrayGenerator();
        int[] arr1 = randArrGen.build(10);
        System.out.println("Unsorted "+ Arrays.toString(arr1));
        Arrays.sort(arr1);
        System.out.println("Sorted " + Arrays.toString(arr1));
    }
}
