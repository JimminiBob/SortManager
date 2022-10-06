package org.sparta.jn.sortmanager.sorters.binarysort;

import org.sparta.jn.sortmanager.exceptions.ChildNotFoundException;
import org.sparta.jn.sortmanager.sorters.Sortable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//public - methods you can access
//private - implementation
//abstract Nodes - show values
public class BinaryTreeImpl implements BinaryTree, Sortable {
    private Node rootNode;
    private int index;
    private static final Logger logger = Logger.getLogger("my logger");


    public BinaryTreeImpl(int element) {
        logger.log(Level.FINER, "BinaryTreeImpl(int elements) constructor called, rootNode value is " + element);
        rootNode = new Node(element);
    }

    public BinaryTreeImpl() {
        logger.log(Level.FINER, "BinaryTreeImpl() constructor called, rootNode value is null");
        rootNode = null;
    }

    @Override
    public void addElement(int element) {
        addNodeToTree(rootNode, element);
    }

    @Override
    public int getRootElement() {
        return rootNode.getValue();
    }

    @Override
    public int getNumberOfElements() {
        return countNode(rootNode);
    }

    @Override
    public void addElements(int[] elements) {
        if (rootNode == null && elements.length >= 1) {
            rootNode = new Node(elements[0]);
        } else if (elements.length >= 1) {
            addNodeToTree(rootNode, elements[0]);
        }
        if (elements.length > 1) {
            for (int element = 1; element < elements.length; element++) {
                addNodeToTree(rootNode, elements[element]);

            }
        }
    }

    public boolean findElement(int element) {
        Node node = findNode(element);
        if (node != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        logger.log(Level.FINE, "getLeftChild starts");
        Node node = findNode(element);
        logger.log(Level.FINE, "getLeftChild ends");
        return node.getLeftChild().getValue();


//        try {
//            return node.getLeftChild().getValue();
//        } catch (ChildNotFoundException e) {
//            System.err.println("That element has no left child!");
//            return 0;
//        }
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node node = findNode(element);
        return node.getRightChild().getValue();
    }

    @Override
    public int[] getSortedTreeAsc() {
        index = 0;
        int[] arr = new int[getNumberOfElements()];
        return treeToArrayAsc(rootNode, arr);

    }

    @Override
    public int[] getSortedTreeDesc() {
        return null;
    }

    private int[] treeToArrayAsc(Node node, int[] arr) {
        if (!node.isLeftChildEmpty()) {
            treeToArrayAsc(node.getLeftChild(), arr);
        }
        arr[index++] = node.getValue();
        if (!node.isRightChildEmpty()) {
            treeToArrayAsc(node.getRightChild(), arr);
        }
        return arr;
    }

    private void addNodeToTree(Node node, int element) { //grunt work
        if (element <= node.getValue()) {
            if (node.isLeftChildEmpty()) {
                node.setLeftChild(new Node(element));
            } else {
                addNodeToTree(node.getLeftChild(), element);
            }
        } else if (element > node.getValue()) {
            if (node.isRightChildEmpty()) {
                node.setRightChild(new Node(element));
            } else {
                addNodeToTree(node.getRightChild(), element);
            }
        }
    }

    private Node findNode(int element) {
        Node node = rootNode;
        while(node != null) {
            if (element == node.getValue()) {
                return node;
            }

            if(element < node.getValue()) {
                node = node.getLeftChild();
            } else if (element > node.getValue()) {
                node = node.getRightChild();
            }
        }
        return null;
    }

    private int countNode(Node node) {
        int count = 1;
        if (node == null) {
            return 0;
        }
        count = count + countNode(node.getLeftChild()) + countNode(node.getRightChild());
        return count;
    }


    @Override
    public int[] sortArray(int[] arrayIn) {
        int[] arrayOut = arrayIn.clone();
        addElements(arrayOut);
        treeToArrayAsc(rootNode, arrayOut);
        return arrayOut;
    }

    @Override
    public String getSorterName() {
        return null;
    }

    public static void main(String[] args) {
        BinaryTreeImpl tree = new BinaryTreeImpl(7);
        tree.addElement(2);
        tree.addElement(4);
        tree.addElement(2);
        tree.addElement(7);
        System.out.println(tree.getNumberOfElements());
        System.out.println(Arrays.toString(tree.getSortedTreeAsc()));;


    }
}

