// Last updated: 20/07/2026, 10:12:53
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
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = null;

    public void recoverTree(TreeNode root) {
        // Step 1: Perform inorder traversal to find the two swapped nodes
        traverse(root);
        
        // Step 2: Swap the values of the two mismatched nodes back
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        traverse(root.left);

        // If a violation of ascending order is found
        if (prev != null && root.val < prev.val) {
            // The first anomaly is always the larger element (the previous node)
            if (first == null) {
                first = prev;
            }
            // The second anomaly is always the smaller element (the current node)
            second = root;
        }
        
        // Track the current node as the previous node for the next step
        prev = root;

        traverse(root.right);
    }
}