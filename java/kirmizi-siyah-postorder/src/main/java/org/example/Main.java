package org.example;

import javax.swing.*;
import java.awt.*;

class Node {
    int data;
    Node left, right;
    boolean isRed;
    Node parent;

    Node(int data) {
        this.data = data;
        this.isRed = true;
    }
}

class RedBlackTree {
    private Node root;

    private void insert(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            root.isRed = false;
        } else {
            insertHelper(root, newNode);
            fixRedRedViolation(newNode);
        }
    }

    private void insertHelper(Node root, Node newNode) {
        if (root.data < newNode.data) {
            if (root.right == null) {
                root.right = newNode;
                newNode.parent = root;
            } else {
                insertHelper(root.right, newNode);
            }
        } else {
            if (root.left == null) {
                root.left = newNode;
                newNode.parent = root;
            } else {
                insertHelper(root.left, newNode);
            }
        }
    }

    private void fixRedRedViolation(Node newNode) {
        if (newNode == root) {
            newNode.isRed = false;
            return;
        }
        Node parent = newNode.parent;
        Node grandparent = null;
        if (parent != null) {
            grandparent = parent.parent;
        }
        Node uncle;
        while (parent != null && parent.isRed) {
            grandparent = parent.parent;
            if (parent == grandparent.left) {
                uncle = grandparent.right;
                if (uncle != null && uncle.isRed) {
                    grandparent.isRed = true;
                    parent.isRed = false;
                    uncle.isRed = false;
                    newNode = grandparent;
                } else {
                    if (newNode == parent.right) {
                        rotateLeft(parent);
                        newNode = parent;
                        parent = newNode.parent;
                    }
                    rotateRight(grandparent);
                    boolean temp = parent.isRed;
                    parent.isRed = grandparent.isRed;
                    grandparent.isRed = temp;
                    newNode = parent;
                }
            } else {
                uncle = grandparent.left;
                if (uncle != null && uncle.isRed) {
                    grandparent.isRed = true;
                    parent.isRed = false;
                    uncle.isRed = false;
                    newNode = grandparent;
                } else {
                    if (newNode == parent.left) {
                        rotateRight(parent);
                        newNode = parent;
                        parent = newNode.parent;
                    }
                    rotateLeft(grandparent);
                    boolean temp = parent.isRed;
                    parent.isRed = grandparent.isRed;
                    grandparent.isRed = temp;
                    newNode = parent;
                }
            }
        }
        root.isRed = false;
    }

    private void rotateLeft(Node node) {
        Node rightChild = node.right;
        node.right = rightChild.left;
        if (node.right != null) {
            node.right.parent = node;
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

    private void rotateRight(Node node) {
        Node leftChild = node.left;
        node.left = leftChild.right;
        if (node.left != null) {
            node.left.parent = node;
        }
        leftChild.parent = node.parent;
        if (node.parent == null) {
            root = leftChild;
        } else if (node == node.parent.left) {
            node.parent.left = leftChild;
        } else {
            node.parent.right = leftChild;
        }
        leftChild.right = node;
        node.parent = leftChild;
    }

    private void postorderTraversal(Node node, Graphics g, int x, int y, int level) {
        if (node == null) {
            return;
        }
        postorderTraversal(node.left, g, x - level * 20, y + 80, level + 1);
        postorderTraversal(node.right, g, x + level * 20, y + 80, level + 1);
        drawNode(node, g, x, y);
    }

    private void drawNode(Node node, Graphics g, int x, int y) {
        g.setColor(node.isRed ? Color.RED : Color.BLACK);
        g.fillOval(x, y, 40, 40);
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(node.data), x + 15, y + 25);
    }

    private void drawTree() {
        JFrame frame = new JFrame("Red-Black Tree");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                postorderTraversal(root, g, getWidth() / 2, 40, 1);
            }
        };
        frame.add(panel);
    }

    void execute() {
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25, 35, 45, 55, 65, 75, 90};
        for (int value : values) {
            insert(value);
        }
        drawTree();
    }
}

public class Main {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.execute();
    }
}

