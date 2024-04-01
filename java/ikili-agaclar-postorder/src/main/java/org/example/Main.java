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

    BinaryTree() {
        root = null;
    }

    // İkili ağaç düğümlerini postorder olarak dolaşan yardımcı metot
    void postorderTraversal(Node node) {
        if (node == null)
            return;

        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    // İkili ağacı çizdirme metodu
    void drawTree(Node node, int x, int y, int xOffset, int level, Graphics g) {
        if (node == null)
            return;

        drawTree(node.left, x - xOffset, y + 50, xOffset / 2, level + 1, g);
        drawTree(node.right, x + xOffset, y + 50, xOffset / 2, level + 1, g);

        g.setColor(Color.WHITE);
        g.fillOval(x, y, 30, 30);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, 30, 30);
        g.drawString(Integer.toString(node.data), x + 10, y + 20);

        if (node.left != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x + 15, y + 30, x - xOffset + 15, y + 80);
        }

        if (node.right != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x + 15, y + 30, x + xOffset + 15, y + 80);
        }
    }

    // İkili ağacı grafik ekrana çizdirme metodu
    void drawTreeGraphics() {
        JFrame frame = new JFrame("Binary Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.getContentPane().setBackground(Color.WHITE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawTree(root, getWidth() / 2, 50, getWidth() / 4, 1, g);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("Postorder traversal:");
        tree.postorderTraversal(tree.root);

        tree.drawTreeGraphics();
    }
}
