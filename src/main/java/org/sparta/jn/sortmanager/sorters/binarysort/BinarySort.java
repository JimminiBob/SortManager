package org.sparta.jn.sortmanager.sorters.binarysort;

import org.sparta.jn.sortmanager.sorters.Sortable;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinarySort implements Sortable {
    private final String NAME = "BinarySort";
    private static final Logger logger = Logger.getLogger("my logger");
    private static ConsoleHandler consoleHandler = new ConsoleHandler();


    @Override
    public int[] sortArray(int[] arrayToSort) {
        consoleHandler.setLevel(Level.INFO);

        BinaryTreeImpl tree = new BinaryTreeImpl(arrayToSort[0]);
        int count = 1;
        do {
            tree.addElement(arrayToSort[count]);
            count++;
        } while (count < arrayToSort.length);
        int[] sortedArray = tree.getSortedTreeAsc().clone();
        return sortedArray;
    }

    @Override
    public String getSorterName() {
        return this.NAME;
    }
//        BinaryTreeImpl tree = new BinaryTreeImpl(arrayToSort[0]);
//        for (int i = 1; i < arrayToSort.length; i++) {
//            tree.addElements(i);
//        }
//    }
}
