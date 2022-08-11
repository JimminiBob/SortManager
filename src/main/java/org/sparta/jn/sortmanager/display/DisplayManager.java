package org.sparta.jn.sortmanager.display;

import java.util.Scanner;

public class DisplayManager {
    int choice = 0;

    public static void printSorterChoice() {
        System.out.println("Enter the number of the sorter you wish to use");
        System.out.println("1. BinarySorter");
        System.out.println("2. BubbleSorter");
        System.out.println("3. MergeSorter");
        System.out.println("4. QuickSorter");
    }


}
