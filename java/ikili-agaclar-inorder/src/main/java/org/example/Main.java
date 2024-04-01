import javax.swing.*;
import java.awt.*;

class TreeNode {
    int data;
    TreeNode left, right;

    public TreeNode(int data) {
        this.data = data;
        left = right = null;
    }
}

class BinaryTree {
    private TreeNode root;

    public BinaryTree() {
        root = null;
    }

    public void insert(int data) {
        root = insertRecursive(root, data);
    }

    private TreeNode insertRecursive(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data < root.data)
            root.left = insertRecursive(root.left, data);
        else if (data > root.data)
            root.right = insertRecursive(root.right, data);

        return root;
    }

    public void inorder() {
        inorderRecursive(root);
    }

    private void inorderRecursive(TreeNode root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + " ");
            inorderRecursive(root.right);
        }
    }

    public void drawTree() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.getContentPane().add(new TreePanel(root));
        frame.setVisible(true);
    }
}

class TreePanel extends JPanel {
    private TreeNode root;
    private int xPosition = 300;
    private int yPosition = 30;
    private int xOffset = 30;
    private int yOffset = 50;

    public TreePanel(TreeNode root) {
        this.root = root;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (root != null)
            drawTree(g, root, xPosition, yPosition, xOffset);
    }

    private void drawTree(Graphics g, TreeNode root, int x, int y, int xOffset) {
        g.setColor(Color.BLACK);
        g.drawOval(x - 15, y - 15, 30, 30);
        g.drawString(String.valueOf(root.data), x - 5, y + 5);

        if (root.left != null) {
            g.drawLine(x, y, x - xOffset, y + yOffset);
            drawTree(g, root.left, x - xOffset, y + yOffset, xOffset / 2);
        }

        if (root.right != null) {
            g.drawLine(x, y, x + xOffset, y + yOffset);
            drawTree(g, root.right, x + xOffset, y + yOffset, xOffset / 2);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(5);
        tree.insert(3);
        tree.insert(8);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(9);

        System.out.print("Inorder traversal: ");
        tree.inorder();

        tree.drawTree();
    }
}

