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
        int[] arr = new int[getNumberOfElements()];
        treeToArrayAsc(rootNode, arr, 0);
        return arr;

    }

    @Override
    public int[] getSortedTreeDesc() {
        return null;
    }

    private int treeToArrayAsc(Node node, int[] arr, int count) { //Not working
        if (!node.isLeftChildEmpty()) {
            count = treeToArrayAsc(node.getLeftChild(), arr, count);
            arr[count] = node.getValue();
        }

        if (count < arr.length - 1) {
            count++;
            count = treeToArrayAsc(node.getRightChild(), arr, count);

        }
        return count;
    }

    private void addNodeToTree(Node node, int element) { //grunt work
        if (element < node.getValue()) {
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
        treeToArrayAsc(rootNode, arrayOut,0);
        return arrayOut;
    }

    @Override
    public String getSorterName() {
        return null;
    }

    public static void main(String[] args) {
        BinaryTreeImpl tree = new BinaryTreeImpl(5);
        tree.addElement(11);
        tree.addElement(2);
        tree.addElement(6);
        System.out.println(tree.getNumberOfElements());
        System.out.println(tree.getLeftChild(11));
        System.out.println(Arrays.toString(tree.getSortedTreeAsc()));;


    }
}

