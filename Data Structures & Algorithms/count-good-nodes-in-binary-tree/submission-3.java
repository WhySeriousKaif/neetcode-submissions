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
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;//considering root is the also good nodes 
        // if we have more than two one nodes
        // we will go by preorder traversal root-> left then right 
        int ans =1;// considering the root as 1
        ans+=search(root.left,root.val);
        ans+=search(root.right,root.val);
        return ans;
        
    }
    //here we have done the preorder traversal we can go ahead with other two traverals and so here we in preorder we have counted the root with condition then we are moveing towards the left and right 
    public int search(TreeNode curr,int max){
        if(curr==null) return 0;
        // say for example , for a node which has left node or right node or no node means null so curr if null then it will return 0 only....
        int count=0;
        // for the any tree to be good nodes the new node >= the prev all nodes , we have a max variable which basically a tracker for so far which is the max nodes we got 
        // we are trying to find all those subtree where the above condition is met...

        if(curr.val>=max){
            max=curr.val;
            count+=1;
        }
        // after we count the root then we will check left and right subtree .. \\
        // ans=root+count(left)+count(right);
        count+=search(curr.left,max);
        count+=search(curr.right,max);
        return count;
    }
}
