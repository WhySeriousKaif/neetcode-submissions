/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    ArrayList<Integer> arr;
    public int kthSmallest(TreeNode root, int k) {
        arr = new ArrayList<>();

        inorder(root, k);
        return arr.get(k - 1);
    }
    void inorder(TreeNode root, int k) {
        if (root == null)
            return;

        if (root.left != null)
            inorder(root.left,k);
        arr.add(root.val);
        if (root.right != null)
            inorder(root.right,k);
    }
}
