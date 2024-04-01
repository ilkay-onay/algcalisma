import javax.swing.*;
import java.awt.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    void insert(int data) {
        root = insertRecursive(root, data);
    }

    Node insertRecursive(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRecursive(root.left, data);
        else if (data > root.data)
            root.right = insertRecursive(root.right, data);

        return root;
    }

    void delete(int data) {
        root = deleteRecursive(root, data);
    }

    Node deleteRecursive(Node root, int data) {
        if (root == null)
            return root;

        if (data < root.data)
            root.left = deleteRecursive(root.left, data);
        else if (data > root.data)
            root.right = deleteRecursive(root.right, data);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            root.data = minValue(root.right);
            root.right = deleteRecursive(root.right, root.data);
        }

        return root;
    }

    int minValue(Node root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    void drawTree() {
        JFrame frame = new JFrame("Binary Search Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().add(new TreePanel());
        frame.setVisible(true);
    }

    class TreePanel extends JPanel {
        private int width;
        private int height;
        private int radius = 20;

        TreePanel() {
            width = 500;
            height = 500;
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.WHITE);
            if (root != null) {
                drawNode(g, root, width / 2, 30, width / 4);
            }
        }

        void drawNode(Graphics g, Node node, int x, int y, int xOffset) {
            g.setColor(Color.BLACK);
            g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
            g.drawString(String.valueOf(node.data), x - 6, y + 4);

            if (node.left != null) {
                int xLeft = x - xOffset;
                int yLeft = y + 50;
                g.drawLine(x, y + radius, xLeft, yLeft - radius);
                drawNode(g, node.left, xLeft, yLeft, xOffset / 2);
            }

            if (node.right != null) {
                int xRight = x + xOffset;
                int yRight = y + 50;
                g.drawLine(x, y + radius, xRight, yRight - radius);
                drawNode(g, node.right, xRight, yRight, xOffset / 2);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        tree.delete(20);
        tree.delete(30);

        tree.drawTree();
    }
}