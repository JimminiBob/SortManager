package org.sparta.jn.sortmanager.start;

import org.sparta.jn.sortmanager.exceptions.SortLoaderException;
import org.sparta.jn.sortmanager.sorters.QuickSort;
import org.sparta.jn.sortmanager.sorters.Sortable;
import org.sparta.jn.sortmanager.sorters.binarysort.BinaryTreeImpl;
import org.sparta.jn.sortmanager.sorters.bubblesort.BubbleSort;
import org.sparta.jn.sortmanager.sorters.mergesort.MergeSort;

public class SortFactory {

    public static Sortable getSorter(int choice) throws SortLoaderException {
        switch (choice) {
            case 1:
                return new BubbleSort();
            case 2:
//                return new BinaryTreeImpl();
            case 3:
                return new MergeSort();
            case 4:
                return new QuickSort();
            default:
                throw new SortLoaderException(choice + " is an invalid Sorter choice");

        }
    }
}
