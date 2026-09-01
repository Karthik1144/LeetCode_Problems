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
    public boolean isValidBST(TreeNode root) {
        if(root.left == null  && root.right == null)
            return true;
        return find(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }
    public boolean find(TreeNode root,long min,long max){
        if(root == null )
            return true;

        boolean left = find(root.left,root.val,max);
        boolean right = find(root.right,min,root.val);

        if(left == false || right == false)
            return false;

        if(root.val >= min || root.val <= max)
            return false;
        
        return true;
    }
}