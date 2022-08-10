package org.sparta.jn.sortmanager.sorters.binarysort;

import org.sparta.jn.sortmanager.exceptions.ChildNotFoundException;

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
        return 0;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        return 0;
    }

    @Override
    public int[] getSortedTreeAsc() {
        return new int[0];
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
}

