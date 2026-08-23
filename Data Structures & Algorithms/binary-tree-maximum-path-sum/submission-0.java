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

    int  maxSum;
    public  int solve(TreeNode root){
        if(root==null) return 0;

        int l=solve(root.left);
        int r=solve(root.right);
        int val1=l+r+root.val; //neeche_hi_mil_gya
        int val2=Math.max(l,r)+root.val;//koi_ek_acha=
        int val3=root.val;//only_root_achacha
        maxSum = Math.max(maxSum, Math.max(val1, Math.max(val2, val3)));
        return Math.max(val2,val3);
        
    }
    public int maxPathSum(TreeNode root) {
        maxSum=Integer.MIN_VALUE;
        solve(root);
        return maxSum;
    }
}
