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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();

        path(root,new StringBuilder(),ans);

        return ans;
    }
    void path(TreeNode root,StringBuilder str,List<String> ans){
        if(root == null)
            return;

        int len = str.length();

        if(len>0){
            str.append("->");
        }
        str.append(root.val);

        if(isLeaf(root)){
            ans.add(str.toString());
        }
        else{
            path(root.left,str,ans);
            path(root.right,str,ans);
        }
        str.setLength(len);
    } 

    boolean isLeaf(TreeNode root){
        if(root.left == null && root.right == null)
            return true;
        return false;
    }
}