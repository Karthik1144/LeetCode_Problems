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
    class Tuple{
        TreeNode node;
        int row;
        int col;
        public Tuple(TreeNode node,int row,int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root,0,0));
        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if(!map.containsKey(y))
                map.put(y,new TreeMap<>()); 
            if(!map.get(y).containsKey(x))
                map.get(y).put(x,new PriorityQueue<>());
            map.get(y).get(x).offer(node.val);

            if(node.left!=null)
                q.offer(new Tuple(node.left,x+1,y-1));
            if(node.right!=null)
                q.offer(new Tuple(node.right,x+1,y+1));
        }
        List<List<Integer>> lst = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> ys:map.values()){
            lst.add(new ArrayList<>());
            for(PriorityQueue<Integer> nodes:ys.values()){
                while(!nodes.isEmpty()){
                    lst.get(lst.size()-1).add(nodes.poll());
                }
            }
        }
        return lst;
    }
}