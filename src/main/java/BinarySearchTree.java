public class BinarySearchTree {
    class Node {
        int key;
        Node left;
        Node right;

        public Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    Node root;

    public BinarySearchTree() {
        root = null;
    }

    public void insert(int key) {
        root = insertNode(root, key);
    }

    private Node insertNode(Node root, int key) {
        if (root == null) {
            root = new Node(key);
            return root;
        }

        if (key < root.key)
            root.left = insertNode(root.left, key);
        else if (key > root.key)
            root.right = insertNode(root.right, key);

        return root;
    }

    public void delete(int key) {
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node root, int key) {
        if (root == null)
            return root;

        if (key < root.key)
            root.left = deleteNode(root.left, key);
        else if (key > root.key)
            root.right = deleteNode(root.right, key);
        else {
            // Node to be deleted found

            // Case 1: Node with no child or only one child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Case 2: Node with two children
            root.key = getMinValue(root.right);

            // Delete the inorder successor
            root.right = deleteNode(root.right, root.key);
        }

        return root;
    }

    private int getMinValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    public boolean search(int key) {
        return searchNode(root, key);
    }

    private boolean searchNode(Node root, int key) {
        if (root == null)
            return false;

        if (key == root.key)
            return true;
        else if (key < root.key)
            return searchNode(root.left, key);
        else
            return searchNode(root.right, key);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        // Insert nodes into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Search for a key in the BST
        int searchKey = 40;
        System.out.println("Key " + searchKey + " found? " + bst.search(searchKey));

        // Delete a node from the BST
        int deleteKey = 30;
        bst.delete(deleteKey);
        System.out.println("Key " + deleteKey + " deleted.");

        // Search again after deletion
        System.out.println("Key " + searchKey + " found? " + bst.search(searchKey));
    }
}
