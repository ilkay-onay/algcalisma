package org.example;

import javax.swing.*;
import java.awt.*;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class BinaryTree {
    private TreeNode root;

    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private TreeNode insertRecursive(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }

        if (data < root.data) {
            root.left = insertRecursive(root.left, data);
        } else if (data > root.data) {
            root.right = insertRecursive(root.right, data);
        }

        return root;
    }

    public void drawTree() {
        JFrame frame = new JFrame("Binary Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().add(new TreePanel());
        frame.setVisible(true);
    }

    private class TreePanel extends JPanel {
        private static final int WIDTH = 800;
        private static final int HEIGHT = 600;
        private static final int RADIUS = 20;

        public TreePanel() {
            setPreferredSize(new Dimension(WIDTH, HEIGHT));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawNode(g, root, WIDTH / 2, 50, WIDTH / 4);
        }

        private void drawNode(Graphics g, TreeNode node, int x, int y, int xOffset) {
            if (node != null) {
                g.drawOval(x - RADIUS, y - RADIUS, 2 * RADIUS, 2 * RADIUS);
                g.drawString(Integer.toString(node.data), x - 6, y + 4);

                if (node.left != null) {
                    g.drawLine(x, y, x - xOffset, y + 50);
                    drawNode(g, node.left, x - xOffset, y + 50, xOffset / 2);
                }

                if (node.right != null) {
                    g.drawLine(x, y, x + xOffset, y + 50);
                    drawNode(g, node.right, x + xOffset, y + 50, xOffset / 2);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        tree.insert(4);
        tree.insert(7);
        tree.insert(9);
        tree.drawTree();
    }
}
