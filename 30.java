class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

 class BinaryTree {
    static class DepthParent {
        int depth;
        TreeNode parent;

        DepthParent(int depth, TreeNode parent) {
            this.depth = depth;
            this.parent = parent;
        }
    }

    public static boolean isBrothers(TreeNode root, int x, int y) {
        DepthParent xInfo = findDepthParent(root, x, null, 0);
        DepthParent yInfo = findDepthParent(root, y, null, 0);

        return xInfo.depth == yInfo.depth && xInfo.parent != yInfo.parent;
    }

    private static DepthParent findDepthParent(TreeNode node, int val, TreeNode parent, int depth) {
        if (node == null) {
            return null;
        }
        if (node.val == val) {
            return new DepthParent(depth, parent);
        }
        DepthParent left = findDepthParent(node.left, val, node, depth + 1);
        DepthParent right = findDepthParent(node.right, val, node, depth + 1);
        return left != null ? left : right;
    }

    public static void main(String[] args) {
        // Construct the binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.left= new TreeNode(4);
        root.right.left= new TreeNode(6);
        root.right.right= new TreeNode(7);


        int x = 4;
        int y = 6;
        System.out.println(isBrothers(root, x, y)); // Output: true
    }
}
