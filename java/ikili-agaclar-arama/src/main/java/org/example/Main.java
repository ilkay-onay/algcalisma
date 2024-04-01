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

class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertNode(root, data);
    }

    private Node insertNode(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (data < root.data)
            root.left = insertNode(root.left, data);
        else if (data > root.data)
            root.right = insertNode(root.right, data);

        return root;
    }

    public void search(int data) {
        searchNode(root, data);
    }

    private void searchNode(Node root, int data) {
        if (root == null || root.data == data) {
            if (root != null) {
                System.out.println("Arama sonucu: " + data + " bulundu!");
            } else {
                System.out.println("Arama sonucu: " + data + " bulunamadı!");
            }
            return;
        }

        if (data < root.data)
            searchNode(root.left, data);
        else
            searchNode(root.right, data);
    }

    public void drawTree() {
        JFrame frame = new JFrame("Binary Tree Visualization");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setBackground(Color.white);
        TreePanel panel = new TreePanel(root);
        frame.add(panel);
        frame.setVisible(true);
    }
}

class TreePanel extends JPanel {
    private Node root;
    private int radius = 20;
    private int verticalGap = 50;

    public TreePanel(Node root) {
        this.root = root;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTree(g, getWidth() / 2, 30, root);
    }

    private void drawTree(Graphics g, int x, int y, Node node) {
        if (node == null)
            return;

        g.setColor(Color.black);
        g.drawOval(x - radius, y - radius, 2 * radius, 2 * radius);
        g.drawString(Integer.toString(node.data), x - 6, y + 4);

        if (node.left != null) {
            drawLine(g, x - radius, y + radius, x - 100, y + verticalGap - radius);
            drawTree(g, x - 100, y + verticalGap, node.left);
        }

        if (node.right != null) {
            drawLine(g, x + radius, y + radius, x + 100, y + verticalGap - radius);
            drawTree(g, x + 100, y + verticalGap, node.right);
        }
    }

    private void drawLine(Graphics g, int x1, int y1, int x2, int y2) {
        g.setColor(Color.black);
        g.drawLine(x1, y1, x2, y2);
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.insert(50);
        binaryTree.insert(30);
        binaryTree.insert(20);
        binaryTree.insert(40);
        binaryTree.insert(70);
        binaryTree.insert(60);
        binaryTree.insert(80);

        binaryTree.search(40);

        binaryTree.drawTree();
    }
}
