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
    private int getLeftHeight(TreeNode node) {
        int height = 0;
 
        // Following only left children gives
        // the extreme left height of this subtree.
        while (node != null) {
            height++;
            node = node.left;
        }
 
        return height;
    }
 
    // Measures the extreme right height
    // of the current subtree.
    private int getRightHeight(TreeNode node) {
        int height = 0;
 
        // Following only right children gives
        // the extreme right height of this subtree.
        while (node != null) {
            height++;
            node = node.right;
        }
 
        return height;
    }
 
    // Uses the complete-tree property to count
    // perfect subtrees without visiting every node.
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
 
        int leftHeight =
            getLeftHeight(root);
 
        int rightHeight =
            getRightHeight(root);
 
        // Equal extreme heights mean this complete
        // subtree is a perfect binary tree.
        if (leftHeight == rightHeight) {
 
            // A perfect tree with leftHeight levels has
            // 2^leftHeight - 1 nodes.
            // Left shift calculates 2^leftHeight.
            return (1 << leftHeight) - 1;
        }
 
        // When the subtree is not perfect, both sides
        // are counted recursively along with the root.
        return 1
            + countNodes(root.left)
            + countNodes(root.right);
    }
}