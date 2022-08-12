package org.sparta.jn.sortmanager.sorter.binarysort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sparta.jn.sortmanager.sorters.Sortable;
import org.sparta.jn.sortmanager.sorters.binarysort.BinarySort;
import org.sparta.jn.sortmanager.sorters.binarysort.BinaryTreeImpl;

import java.util.Arrays;

public class BinaryTreeImplTest {

    @Test
    @DisplayName("If only one node return int 1")
    void ifOnlyOneNodeReturnInt1() {
        BinaryTreeImpl tree = new BinaryTreeImpl(15);
        Assertions.assertEquals(1, tree.getNumberOfElements());
    }

    @Test
    @DisplayName("If two elements in the tree return int 2")
    void ifTwoElementsInTheTreeReturnInt2() {
        BinaryTreeImpl tree = new BinaryTreeImpl(15);
        tree.addElement(3);
        Assertions.assertEquals(2, tree.getNumberOfElements());

    }

    @Test
    @DisplayName("If three elements in the tree return int 3")
    void ifThreeElementsInTheTreeReturnInt3() {
        BinaryTreeImpl tree = new BinaryTreeImpl(15);
        tree.addElement(3);
        tree.addElement(55);
        Assertions.assertEquals(3, tree.getNumberOfElements());
    }

    @Test
    @DisplayName("If there are 5 elements in the tree return 5")
    void ifThereAre5ElementsInTheTreeReturn5() {
        BinaryTreeImpl tree = new BinaryTreeImpl(15);
        tree.addElement(3);
        tree.addElement(55);
        tree.addElement(21);
        tree.addElement(99);
        Assertions.assertEquals(5, tree.getNumberOfElements());
    }

    @Test
    @DisplayName("Tree returns value in ascending order")
    void treeReturnsValueInAscendingOrder() {
        int[] unsorted = {-26, 43, -44, -74, -19, 81, -33, -73, 57, 28};
        int[] expected = {-74, -73, -44, -33, -26, -19, 28, 43, 57, 81};

        BinaryTreeImpl tree = new BinaryTreeImpl(-26);
        tree.addElements(unsorted);
        int[] sorted = tree.getSortedTreeAsc();
        Assertions.assertArrayEquals(expected, sorted);

    }


}
