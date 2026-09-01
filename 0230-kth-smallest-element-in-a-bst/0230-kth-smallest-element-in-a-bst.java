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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        find(root,pq);
        for(int i=0;i<k-1;i++)
            pq.poll();

        return pq.poll();
    }
    void find(TreeNode root,PriorityQueue<Integer> pq){
        if(root == null)
            return ;

        pq.offer(root.val);
        find(root.left,pq);
        find(root.right,pq);

        return;
    }
}