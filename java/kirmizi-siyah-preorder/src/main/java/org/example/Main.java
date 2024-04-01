package org.example;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

class RedBlackTree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        int key;
        Node left, right;
        boolean color;

        Node(int key, boolean color) {
            this.key = key;
            this.color = color;
        }
    }

    public Node root;

    private boolean isRed(Node node) {
        if (node == null)
            return false;
        return node.color == RED;
    }

    // Sol Rotasyon
    private Node rotateLeft(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private Node rotateRight(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void preorderTraversal() {
        preorderTraversal(root);
    }

    private void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public void drawTree() {
        JFrame frame = new JFrame("Red-Black Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawNode(g, root, 400, 50, 300);
            }
        };
        frame.add(panel);
        frame.setVisible(true);
    }

    private void drawNode(Graphics g, Node node, int x, int y, int offsetX) {
        if (node != null) {
            Color color = node.color == RED ? Color.RED : Color.BLACK;
            g.setColor(color);
            g.fillOval(x - 15, y - 15, 30, 30);
            g.setColor(Color.WHITE);
            g.drawString(Integer.toString(node.key), x - 5, y + 5);
            if (node.left != null) {
                g.setColor(Color.BLACK);
                g.drawLine(x, y, x - offsetX, y + 50);
                drawNode(g, node.left, x - offsetX, y + 50, offsetX / 2);
            }
            if (node.right != null) {
                g.setColor(Color.BLACK);
                g.drawLine(x, y, x + offsetX, y + 50);
                drawNode(g, node.right, x + offsetX, y + 50, offsetX / 2);
            }
        }
    }
    public Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key, RED);
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }
}

public class Main {
    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 60);
        tree.root = tree.insert(tree.root, 70);

        System.out.println("Preorder Dolasim:");
        tree.preorderTraversal();

        tree.drawTree();
    }
}
