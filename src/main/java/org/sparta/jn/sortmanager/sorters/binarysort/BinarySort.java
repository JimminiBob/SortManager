package org.sparta.jn.sortmanager.sorters.binarysort;

import org.sparta.jn.sortmanager.sorters.Sortable;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BinarySort implements Sortable {
    private final String NAME = "BinarySort";
    private static final Logger logger = Logger.getLogger("my logger");
    private static ConsoleHandler consoleHandler = new ConsoleHandler();


    @Override
    public int[] sortArray(int[] arrIn) {
        consoleHandler.setLevel(Level.INFO);
        int[] arrOut = arrIn.clone();
        BinaryTreeImpl tree = new BinaryTreeImpl(arrOut[0]);
        int count = 1;
        if (arrIn.length > 1) {
            do {
                tree.addElement(arrOut[count]);
                count++;
            } while (count < arrOut.length);
        }
        logger.log(Level.INFO,"arrOut after sortArray " + Arrays.toString(arrOut));
        return tree.getSortedTreeAsc();
    }

    @Override
    public String getSorterName() {
        return this.NAME;
    }
}
