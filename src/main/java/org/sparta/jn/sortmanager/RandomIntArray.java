package org.sparta.jn.sortmanager;

import java.util.Arrays;
import java.util.Random;

public class RandomIntArray {

    public int[] build(int length) {
        int[] randomArr = new int[length];
        Random rd = new Random();
        for (int i = 0; i < length; i++) {
            randomArr[i] = rd.nextInt(-100, 100);
        }
        return randomArr;
    }

//    public static void main(String[] args) {
//
//        RandomIntArray randArrGen = new RandomIntArray();
//
//        System.out.println(Arrays.toString(randArrGen.build(10)));
//    }
}
