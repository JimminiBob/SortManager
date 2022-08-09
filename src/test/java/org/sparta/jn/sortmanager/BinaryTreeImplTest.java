package org.sparta.jn.sortmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.sparta.jn.sortmanager.sorters.binarysort.BinaryTreeImpl;

public class BinaryTreeImplTest {

    @Test
    @DisplayName("If only one nude return int 1")
    void ifOnlyOneNudeReturnInt1() {
        BinaryTreeImpl tree = new BinaryTreeImpl(50);
        tree.addElementToTree(1);
        Assertions.assertEquals(1, tree.getNumberOfElements());

    }
}
