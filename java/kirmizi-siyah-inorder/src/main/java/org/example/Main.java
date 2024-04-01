package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

class Node {
    int data;
    Node parent, left, right;
    boolean isRed;

    Node(int data) {
        this.data = data;
        this.isRed = true;
    }
}

class RedBlackTree {
    Node root;

    void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            root.isRed = false;
        } else {
            Node current = root;
            Node parent;
            while (true) {
                parent = current;
                if (data < current.data) {
                    current = current.left;
                    if (current == null) {
                        parent.left = newNode;
                        newNode.parent = parent;
                        adjustTreeAfterInsertion(newNode);
                        return;
                    }
                } else {
                    current = current.right;
                    if (current == null) {
                        parent.right = newNode;
                        newNode.parent = parent;
                        adjustTreeAfterInsertion(newNode);
                        return;
                    }
                }
            }
        }
    }

    void adjustTreeAfterInsertion(Node newNode) {
        Node parent, grandParent;
        while (newNode != root && newNode.isRed && newNode.parent.isRed) {
            parent = newNode.parent;
            grandParent = newNode.parent.parent;
            if (parent == grandParent.left) {
                Node uncle = grandParent.right;
                if (uncle != null && uncle.isRed) {
                    grandParent.isRed = true;
                    parent.isRed = false;
                    uncle.isRed = false;
                    newNode = grandParent;
                } else {
                    if (newNode == parent.right) {
                        rotateLeft(parent);
                        newNode = parent;
                        parent = newNode.parent;
                    }
                    rotateRight(grandParent);
                    boolean temp = parent.isRed;
                    parent.isRed = grandParent.isRed;
                    grandParent.isRed = temp;
                    newNode = parent;
                }
            } else {
                Node uncle = grandParent.left;
                if (uncle != null && uncle.isRed) {
                    grandParent.isRed = true;
                    parent.isRed = false;
                    uncle.isRed = false;
                    newNode = grandParent;
                } else {
                    if (newNode == parent.left) {
                        rotateRight(parent);
                        newNode = parent;
                        parent = newNode.parent;
                    }
                    rotateLeft(grandParent);
                    boolean temp = parent.isRed;
                    parent.isRed = grandParent.isRed;
                    grandParent.isRed = temp;
                    newNode = parent;
                }
            }
        }
        root.isRed = false;
    }

    void rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (rightChild.left != null) {
            rightChild.left.parent = node;
        }
        rightChild.parent = node.parent;
        if (node.parent == null) {
            root = rightChild;
        } else if (node == node.parent.left) {
            node.parent.left = rightChild;
        } else {
            node.parent.right = rightChild;
        }
        rightChild.left = node;
        node.parent = rightChild;
    }

    void rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        if (leftChild.right != null) {
            leftChild.right.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.right) {
            node.parent.right = leftChild;
        } else {
            node.parent.left = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
    }

    void inorderTraversal(Node node, Graphics g, int x, int y) {
        if (node == null) return;
        inorderTraversal(node.left, g, x - 30, y + 50);
        g.setColor(node.isRed ? Color.RED : Color.BLACK);
        g.fillOval(x, y, 30, 30);
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(node.data), x + 10, y + 20);
        inorderTraversal(node.right, g, x + 30, y + 50);
    }

    void drawTree() {
        JFrame frame = new JFrame("Red-Black Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.WHITE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                inorderTraversal(root, g, 400, 50);
            }
        };
        panel.setBackground(Color.WHITE);
        frame.add(panel);
    }
}

public class Main {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(60);

        tree.drawTree();
    }
}

