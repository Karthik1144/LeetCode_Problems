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
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root.left == null && root.right == null)
            return root.val;

        find(root);
        return maxSum;
    }
    public int find(TreeNode root){
        if(root == null)
            return 0;

        int lSum = Math.max(0,find(root.left));
        int rSum = Math.max(0,find(root.right));

        maxSum = Math.max(lSum+rSum+root.val,maxSum);

        return root.val+Math.max(lSum,rSum);
    }
}