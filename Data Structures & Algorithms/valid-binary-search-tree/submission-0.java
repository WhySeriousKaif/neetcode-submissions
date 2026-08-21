class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = true;
        boolean right = true;

        if (root.left != null) {
            left = checkLeft(root, root.left) && isValidBST(root.left);
        }
        if (root.right != null) {
            right = checkRight(root, root.right) && isValidBST(root.right);
        }
        return left && right;
    }

    boolean checkLeft(TreeNode root, TreeNode node) {
        if (node == null) return true;
        if (node.val >= root.val) return false;
        return checkLeft(root, node.left) && checkLeft(root, node.right);
    }

    boolean checkRight(TreeNode root, TreeNode node) {
        if (node == null) return true;
        if (node.val <= root.val) return false;
        return checkRight(root, node.left) && checkRight(root, node.right);
    }
}