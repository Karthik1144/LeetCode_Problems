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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)
            return ans;

        dfs(root,targetSum,0,new ArrayList<>(),ans);

        return ans;
    }
    public void dfs(TreeNode root,int targetSum,int sum,List<Integer> l,List<List<Integer>> ans){
        if(root==null)
            return;

         sum += root.val;
        l.add(root.val);

        if(root.left == null && root.right==null){
            if(targetSum == sum)
                ans.add(new ArrayList<>(l));
        }

       
        dfs(root.left,targetSum,sum,l,ans);
        dfs(root.right,targetSum,sum,l,ans);

        l.remove(l.size()-1);
    }
}