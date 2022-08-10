package org.sparta.jn.sortmanager.start;

import org.sparta.jn.sortmanager.sorters.binarysort.BinaryTreeImpl;
import org.sparta.jn.sortmanager.sorters.mergesort.MergeSort;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        BinaryTreeImpl tree = new BinaryTreeImpl(5);
        tree.addElement(1);
        tree.addElement(10);
        tree.addElement(10);
        tree.addElement(3);
        tree.addElement(6);
        tree.addElement(11);
//        System.out.println(tree.findElement(6));

//        System.out.println(tree.getNumberOfElements());

        int[] array = {7, 1 ,9};
        MergeSort.sort(array);
        System.out.println(Arrays.toString(array));

    }
}
