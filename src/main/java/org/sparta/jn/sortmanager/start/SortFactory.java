package org.sparta.jn.sortmanager.start;

import org.sparta.jn.sortmanager.exceptions.SortLoaderException;
import org.sparta.jn.sortmanager.sorters.QuickSort;
import org.sparta.jn.sortmanager.sorters.Sortable;
import org.sparta.jn.sortmanager.sorters.binarysort.BinarySort;
import org.sparta.jn.sortmanager.sorters.BubbleSort;
import org.sparta.jn.sortmanager.sorters.MergeSort;

import java.util.ArrayList;
import java.util.List;

public class SortFactory {

    private static List<String> sorterStrList = new ArrayList<>();

    public static Sortable getSorter(int choice) throws SortLoaderException {



        switch (choice) {
            case 1:
                return new BubbleSort();
            case 2:
                return new BinarySort();
            case 3:
                return new MergeSort();
            case 4:
                return new QuickSort();
            default:
                throw new SortLoaderException(choice + " is an invalid Sorter choice");

        }
    }
    public static List<String> getSorterStrList() {
        sorterStrList.add("BubbleSort");
        sorterStrList.add("BinarySort");
        sorterStrList.add("MergeSort");
        sorterStrList.add("QuickSort");
        return sorterStrList;
    }

}
