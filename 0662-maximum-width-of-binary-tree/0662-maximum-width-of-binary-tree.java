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
    class Pair{
        TreeNode node;
        long col;
        Pair(TreeNode node,long col){
            this.node = node;
            this.col = col;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int maxWidth = 0;

        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            long minIndex = q.peek().col ,first = 0 , last = 0;

            int size = q.size();
            for(int i=0;i<size;i++){

                Pair curr = q.poll();
                TreeNode node =  curr.node;
                long col = curr.col-minIndex; 

                if(i==0){
                    first = col;
                }
                if(i==size-1){
                    last = col; 
                }

                if(node.left!=null)
                    q   .add(new Pair(node.left,2*col+1));
                if(node.right!=null)
                    q.add(new Pair(node.right,2*col+2));
            }
            maxWidth = (int) Math.max(maxWidth, last-first+1);
        } 
        return maxWidth;
    }
}