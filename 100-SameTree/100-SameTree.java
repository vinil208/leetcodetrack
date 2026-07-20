// Last updated: 20/07/2026, 10:12:52
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base Case 1: Both nodes are null -> They are identical
        if (p == null && q == null) {
            return true;
        }
        
        // Base Case 2: One node is null but the other isn't -> They are not identical
        if (p == null || q == null) {
            return false;
        }
        
        // Base Case 3: The values don't match -> They are not identical
        if (p.val != q.val) {
            return false;
        }
        
        // Recursively check if the left subtrees match AND the right subtrees match
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}