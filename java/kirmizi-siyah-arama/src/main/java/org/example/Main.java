import javax.swing.*;
import java.awt.*;

class Node {
    int key;
    Node left, right;
    Color color;

    public Node(int key) {
        this.key = key;
        this.color = Color.RED;
        this.left = null;
        this.right = null;
    }
}

class RedBlackTree {
    private Node root;

    private void insert(int key) {
        root = insertNode(root, key);
        root.color = Color.BLACK;
    }

    private Node insertNode(Node root, int key) {
        if (root == null)
            return new Node(key);

        if (key < root.key)
            root.left = insertNode(root.left, key);
        else if (key > root.key)
            root.right = insertNode(root.right, key);

        if (isRed(root.right) && !isRed(root.left))
            root = rotateLeft(root);
        if (isRed(root.left) && isRed(root.left.left))
            root = rotateRight(root);
        if (isRed(root.left) && isRed(root.right))
            flipColors(root);

        return root;
    }

    private boolean isRed(Node node) {
        if (node == null)
            return false;
        return node.color == Color.RED;
    }

    private Node rotateLeft(Node root) {
        Node temp = root.right;
        root.right = temp.left;
        temp.left = root;
        temp.color = root.color;
        root.color = Color.RED;
        return temp;
    }

    private Node rotateRight(Node root) {
        Node temp = root.left;
        root.left = temp.right;
        temp.right = root;
        temp.color = root.color;
        root.color = Color.RED;
        return temp;
    }

    private void flipColors(Node root) {
        root.color = Color.RED;
        root.left.color = Color.BLACK;
        root.right.color = Color.BLACK;
    }

    private void search(int key) {
        Node node = searchNode(root, key);
        if (node != null)
            System.out.println("Düğüm bulundu: " + node.key);
        else
            System.out.println("Düğüm bulunamadı.");
    }

    private Node searchNode(Node root, int key) {
        if (root == null || root.key == key)
            return root;

        if (key < root.key)
            return searchNode(root.left, key);
        else
            return searchNode(root.right, key);
    }

    private void drawTree() {
        JFrame frame = new JFrame("Red-Black Tree");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

    private void drawNode(Graphics g, Node node, int x, int y, int xOffset) {
        if (node == null)
            return;

        g.setColor(node.color);
        g.fillOval(x, y, 30, 30);
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(node.key), x + 10, y + 20);

        if (node.left != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x + 15, y + 30, x - xOffset + 15, y + 60);
        }

        if (node.right != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x + 15, y + 30, x + xOffset + 15, y + 60);
        }

        drawNode(g, node.left, x - xOffset, y + 60, xOffset / 2);
        drawNode(g, node.right, x + xOffset, y + 60, xOffset / 2);
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        tree.search(6);
        tree.search(10);

        tree.drawTree();
    }
}

