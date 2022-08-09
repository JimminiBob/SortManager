package org.sparta.jn.sortmanager.start;

import org.sparta.jn.sortmanager.sorters.binarysort.BinaryTreeImpl;

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

        System.out.println(tree.getNumberOfElements());

    }
}
