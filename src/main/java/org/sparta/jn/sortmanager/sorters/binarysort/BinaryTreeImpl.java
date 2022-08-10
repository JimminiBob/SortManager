package org.sparta.jn.sortmanager.sorters.binarysort;

import org.sparta.jn.sortmanager.exceptions.ChildNotFoundException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//public - methods you can access
//private - implementation
//abstract Nodes - show values
public class BinaryTreeImpl implements BinaryTree {
    private final Node rootNode;

    public BinaryTreeImpl(int elements) {
        rootNode = new Node(elements);
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
        for(int element: elements) {
            addElement(element);
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
        Node node = findNode(element);
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

        return null;

//        return inOrder(rootNode);
    }

    @Override
    public int[] getSortedTreeDesc() {

        return new int[0];
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

    public void addToArray(Node node, int[] array, int index) {
        if (node == null) {
            return;
        }

        addToArray(node.getLeftChild());
        array.add(node.getValue());
        addToArray(node.getRightChild();
    }


    public static void main(String[] args) {
        BinaryTreeImpl tree = new BinaryTreeImpl(5);
        tree.addElement(11);
        tree.addElement(2);
        tree.addElement(6);
//        System.out.println(tree.getNumberOfElements());
//        System.out.println(tree.getLeftChild(11));
//        System.out.println(Arrays.toString(tree.getSortedTreeAsc()));;
//        ArrayList<Object> arrayList = new ArrayList<>();
    }
}

