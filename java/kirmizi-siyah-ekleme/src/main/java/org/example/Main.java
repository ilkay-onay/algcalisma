import javax.swing.*;
import java.awt.*;

class RedBlackTree {
    private static final Color RED = Color.RED;
    private static final Color BLACK = Color.BLACK;

    class Node {
        int data;
        Node parent, left, right;
        Color color;

        public Node(int data) {
            this.data = data;
            color = RED;
            parent = null;
            left = null;
            right = null;
        }
    }

    private Node root;

    public RedBlackTree() {
        root = null;
    }

    private void insert(int data) {
        Node newNode = new Node(data);
        root = insertNode(root, newNode);
        fixViolation(newNode);
    }

    private Node insertNode(Node root, Node newNode) {
        if (root == null) {
            return newNode;
        }

        if (newNode.data < root.data) {
            root.left = insertNode(root.left, newNode);
            root.left.parent = root;
        } else if (newNode.data > root.data) {
            root.right = insertNode(root.right, newNode);
            root.right.parent = root;
        }

        return root;
    }

    private void fixViolation(Node node) {
        Node parent = null;
        Node grandParent = null;

        while (node != root && node.color != BLACK && node.parent.color == RED) {
            parent = node.parent;
            grandParent = node.parent.parent;

            if (parent == grandParent.left) {
                Node uncle = grandParent.right;

                if (uncle != null && uncle.color == RED) {
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandParent;
                } else {
                    if (node == parent.right) {
                        rotateLeft(parent);
                        node = parent;
                        parent = node.parent;
                    }

                    rotateRight(grandParent);
                    Color temp = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = temp;
                    node = parent;
                }
            } else {
                Node uncle = grandParent.left;

                if (uncle != null && uncle.color == RED) {
                    grandParent.color = RED;
                    parent.color = BLACK;
                    uncle.color = BLACK;
                    node = grandParent;
                } else {
                    if (node == parent.left) {
                        rotateRight(parent);
                        node = parent;
                        parent = node.parent;
                    }

                    rotateLeft(grandParent);
                    Color temp = parent.color;
                    parent.color = grandParent.color;
                    grandParent.color = temp;
                    node = parent;
                }
            }
        }

        if (root != null) {
            root.color = BLACK;
        }
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

    private void drawTree(Node root) {
        JFrame frame = new JFrame("Red-Black Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawNode(g, root, 400, 50, 200);
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }

    private void drawNode(Graphics g, Node node, int x, int y, int xOffset) {
        if (node == null) {
            return;
        }

        g.setColor(node.color);
        g.fillOval(x, y, 30, 30);
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(node.data), x + 10, y + 20);

        if (node.left != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x + 15, y + 30, x - xOffset + 15, y + 80);
            drawNode(g, node.left, x - xOffset, y + 80, xOffset / 2);
        }

        if (node.right != null) {
            g.setColor(Color.BLACK);
            g.drawLine(x + 15, y + 30, x + xOffset + 15, y + 80);
            drawNode(g, node.right, x + xOffset, y + 80, xOffset / 2);
        }
    }

    public static void main(String[] args) {
        RedBlackTree tree = new RedBlackTree();

        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(15);
        tree.insert(17);
        tree.insert(25);
        tree.insert(40);

        tree.drawTree(tree.root);
    }
}
