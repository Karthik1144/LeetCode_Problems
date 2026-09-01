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
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long,Integer> map = new HashMap<>();
        map.put(0L,1);
        dfs(root,targetSum,0,map);
        return count;
    }
    public void dfs(TreeNode root,int target,long sum,HashMap<Long,Integer> map){
        if(root == null)
            return;

        sum += root.val;

        if(map.containsKey(sum-target))
            count += map.get(sum-target);

        map.put(sum,map.getOrDefault(sum,0)+1);

        dfs(root.left,target,sum,map);
        dfs(root.right,target,sum,map);


        map.put(sum,map.get(sum)-1);
        sum -= root.val;
    }
}