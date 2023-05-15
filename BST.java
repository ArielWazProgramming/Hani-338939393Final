public class BST {
    private Node root;

    private class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public void insert(int data) {
        root = insert(root, data);
    }

    private Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        } else if (data > node.data) {
            node.right = insert(node.right, data);
        }

        return node;
    }

    public boolean isHeightBalanced() {
        return isHeightBalanced(root);
    }

    private boolean isHeightBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        if (Math.abs(leftHeight - rightHeight) <= 1 && isHeightBalanced(node.left) && isHeightBalanced(node.right)) {
            return true;
        }

        return false;
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBST() {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node node, int minValue, int maxValue) {
        if (node == null) {
            return true;
        }

        if (node.data < minValue || node.data > maxValue) {
            return false;
        }

        return isBST(node.left, minValue, node.data - 1) && isBST(node.right, node.data + 1, maxValue);
    }

    public Node findMin() {
        return findMin(root);
    }

    private Node findMin(Node node) {
        if (node.left == null) {
            return node;
        }

        return findMin(node.left);
    }

    public Node findMax() {
        return findMax(root);
    }

    private Node findMax(Node node) {
        if (node.right == null) {
            return node;
        }

        return findMax(node.right);
    }

    public static void main(String[] args) {
        BST bst = new BST();

        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(1);
        bst.insert(9);
        bst.insert(6);

        System.out.println("Is BST: " + bst.isBST());
        System.out.println("Is Height Balanced: " + bst.isHeightBalanced());
        System.out.println("Min Node: " + bst.findMin().data);
        System.out.println("Max Node: " + bst.findMax().data);
    }
}
