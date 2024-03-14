class TreeNode {
    int val;
    TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
        this.left = this.right = null;
    }
}

public class BSTTraversal {
    TreeNode root;

    public BSTTraversal() {
        this.root = null;
    }

    public void insert(int val) {
        this.root = insertNode(this.root, val);
    }

    private TreeNode insertNode(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        if (val < root.val) {
            root.left = insertNode(root.left, val);
        } else if (val > root.val) {
            root.right = insertNode(root.right, val);
        }

        return root;
    }

    public void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.val + " ");
            inorderTraversal(node.right);
        }
    }

    public void preorderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    public void postorderTraversal(TreeNode node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.val + " ");
        }
    }

    public static void main(String[] args) {
        BSTTraversal bst = new BSTTraversal();
        int[] sequence = {50, 30, 70, 20, 40, 60, 80};

        for (int num : sequence) {
            bst.insert(num);
        }

        System.out.println("Inorder traversal:");
        bst.inorderTraversal(bst.root);
        System.out.println();

        System.out.println("Preorder traversal:");
        bst.preorderTraversal(bst.root);
        System.out.println();

        System.out.println("Postorder traversal:");
        bst.postorderTraversal(bst.root);
        System.out.println();
    }
}

// A binary search tree (BST) is a binary tree data structure in which each node has at most two child nodes, 
// referred to as the left child and the right child. BST maintains an ordering among its elements, 
// making it efficient for searching, insertion, and deletion operations.

// The maximum number of nodes possible in a binary tree of depth  2^(d+1) -1


