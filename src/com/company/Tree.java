package com.company;

public class Tree {
    private Node root;

    public boolean search(int value) {
        return search(root, value);
    }

    private boolean search(Node node, int value) {
        if (node == null) {
            return false;
        }
        if (node.value == value) {
            return true;
        }
        if (value > node.value) {
            return search(node.right, value);
        } else {
            return search(node.left, value);
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = insert(current.left, value);
        } else if (value > current.value) {
            current.right = insert(current.right, value);
        }
        return current;
    }

    public int maxValue() {
        Node tempNode = root;
        while (tempNode.right != null) {
            tempNode = tempNode.right;
        }
        return tempNode.value;
    }

    public int minValue() {
        Node tempNode = root;
        while (tempNode.left != null) {
            tempNode = tempNode.left;
        }
        return tempNode.value;
    }

    public void printTree() {
        printTree(root, 0);
    }

    private static void printTree(Node node, int spaces) {
        if (node == null)
            return;
        printTree(node.right, spaces + 1);
        if (spaces != 0) {
            for (int i = 0; i < spaces - 1; i++)
                System.out.print("|\t");
            System.out.println("|->" + node.value);
        } else
            System.out.println(node.value);
        printTree(node.left, spaces + 1);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(5);
        tree.insert(2);
        tree.insert(1);
        tree.insert(7);
        tree.insert(4);
        tree.insert(8);
        tree.insert(3);
        tree.insert(9);
        tree.insert(6);
        tree.printTree();
    }
}
