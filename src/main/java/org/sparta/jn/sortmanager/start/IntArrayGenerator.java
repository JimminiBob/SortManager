package org.sparta.jn.sortmanager.start;

import java.util.Arrays;
import java.util.Random;

public class IntArrayGenerator {

    public static int[] build(int length) {
        int[] randomArr = new int[length];
        Random rd = new Random();
        for (int i = 0; i < length; i++) {
            randomArr[i] = rd.nextInt(-100, 100);
        }
        return randomArr;
    }
}
