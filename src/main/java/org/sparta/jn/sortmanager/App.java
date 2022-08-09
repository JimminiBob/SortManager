package org.sparta.jn.sortmanager;

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
        tree.addElementToTree(1);
        tree.addElementToTree(5);
        tree.addElementToTree(10);
        tree.addElementToTree(3);
        tree.addElementToTree(6);
        tree.addElementToTree(11);

        System.out.println(tree.findElement(11));
   }
}
