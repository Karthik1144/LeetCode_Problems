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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>>  ans = new ArrayList<>();
        if(root==null)
            return ans;
        Queue<TreeNode> fifo = new LinkedList<>();
        fifo.offer(root);
        while(!fifo.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int size = fifo.size();
            for(int i=0;i<size;i++){
                TreeNode node = fifo.poll();
                subList.add(node.val);
                if(node.left!=null)
                    fifo.offer(node.left);
                if(node.right!=null)
                    fifo.offer(node.right);
            }
            ans.add(new ArrayList<>(subList));
        }
        return ans;
    }
}