class Solution {

    public TreeNode lowestCommonAncestor(
        TreeNode root,
        TreeNode p,
        TreeNode q
    ) {

        // Base case
        if (root == null) {
            return null;
        }

        // Current node itself is p or q
        if (root == p || root == q) {
            return root;
        }

        // Search left and right
        TreeNode left = lowestCommonAncestor(
            root.left,
            p,
            q
        );

        TreeNode right = lowestCommonAncestor(
            root.right,
            p,
            q
        );

        // Found one node on each side
        if (left != null && right != null) {
            return root;
        }

        // Return whichever side found something
        if (left != null) {
            return left;
        }

        return right;
    }
}
