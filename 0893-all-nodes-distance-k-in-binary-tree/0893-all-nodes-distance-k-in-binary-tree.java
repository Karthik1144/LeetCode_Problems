/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                q.offer(node.left);
                parentMap.put(node.left,node);
            }  
            if(node.right!=null){
                q.offer(node.right);
                parentMap.put(node.right,node);
            }
        }

        Queue<TreeNode> bfs = new LinkedList<>();
        Set<TreeNode> vis = new HashSet<>();
        bfs.offer(target);
        vis.add(target);
        int currLevel = 0 ;
        while(!bfs.isEmpty()){
            int size = bfs.size();
            if(currLevel == k)
                break;
            for(int i=0;i<size;i++){
                TreeNode node = bfs.poll();
                if(node.left !=null && !vis.contains(node.left)){
                    vis.add(node.left);
                    bfs.offer(node.left);
                }
                if(node.right!=null && !vis.contains(node.right)){
                    vis.add(node.right);
                    bfs.offer(node.right);
                }
                if(parentMap.containsKey(node) && !vis.contains(parentMap.get(node))){
                    vis.add(parentMap.get(node));
                    bfs.offer(parentMap.get(node));
                }
            }
            currLevel ++;

        }

        List<Integer> ans = new ArrayList<>();
        while(!bfs.isEmpty()){
            ans.add(bfs.poll().val);
        } 
        return ans;
    }
}