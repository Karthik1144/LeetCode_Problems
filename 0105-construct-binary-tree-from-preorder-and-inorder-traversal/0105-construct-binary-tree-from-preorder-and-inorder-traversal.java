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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            map.put(inorder[i],i);

        return construct(0,preorder.length-1,preorder,0,inorder.length-1,inorder,map);
    }
    public TreeNode construct(int preStart,int preEnd,int[] preOrder,int inStart,
    int inEnd,int[] inOrder,HashMap<Integer,Integer> map){
        if(preStart > preEnd || inStart > inEnd)
            return null;

        TreeNode root = new TreeNode(preOrder[preStart]);
        int inRoot = map.get(root.val);
        int numLeft = inRoot-inStart;

        root.left = construct(preStart+1, preStart+numLeft, preOrder, inStart,inRoot-1,inOrder,map );
        root.right = construct(preStart+numLeft+1,preEnd,preOrder,inRoot+1,inEnd,inOrder,map);
        return root;
    }
}