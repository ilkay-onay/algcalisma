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

    // İkili ağacı preorder şeklinde dolaşarak çizdirme
    private void drawTree(Node node, int x, int y, int level, Graphics g) {
        if (node != null) {
            int circleRadius = 20;
            int space = 50;

            g.setColor(Color.WHITE);
            g.fillOval(x - circleRadius, y - circleRadius, 2 * circleRadius, 2 * circleRadius);
            g.setColor(Color.BLACK);
            g.drawOval(x - circleRadius, y - circleRadius, 2 * circleRadius, 2 * circleRadius);
            g.drawString(String.valueOf(node.data), x - 6, y + 4);

            if (node.left != null) {
                g.setColor(Color.BLACK);
                g.drawLine(x - circleRadius, y + circleRadius, x - space, y + space);
                drawTree(node.left, x - space, y + space, level + 1, g);
            }

            if (node.right != null) {
                g.setColor(Color.BLACK);
                g.drawLine(x + circleRadius, y + circleRadius, x + space, y + space);
                drawTree(node.right, x + space, y + space, level + 1, g);
            }
        }
    }

    public void draw(Graphics g) {
        drawTree(root, 400, 50, 1, g);
    }
}

public class Main extends JPanel {
    private BinaryTree binaryTree;

    public Main() {
        binaryTree = new BinaryTree();
        // İkili ağaç örneği oluşturma
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);
        binaryTree.root.right.left = new Node(6);
        binaryTree.root.right.right = new Node(7);

        setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        binaryTree.draw(g);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Binary Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new Main());
        frame.pack();
        frame.setVisible(true);
    }
}
