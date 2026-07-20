// Last updated: 20/07/2026, 10:12:40
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
    public TreeNode sortedArrayToBST(int[] nums) {
        // Kick off the recursive tree construction using the full array boundaries
        return constructBST(nums, 0, nums.length - 1);
    }

    private TreeNode constructBST(int[] nums, int left, int right) {
        // Base case: If the left pointer crosses the right pointer, the subtree segment is empty
        if (left > right) {
            return null;
        }

        // Find the middle element to serve as the root. 
        // Using (left + right) / 2 could cause integer overflow for large indices.
        int mid = left + (right - left) / 2;
        
        // Create the root node with the middle value
        TreeNode root = new TreeNode(nums[mid]);

        // Recursively construct the left subtree using the elements to the left of 'mid'
        root.left = constructBST(nums, left, mid - 1);

        // Recursively construct the right subtree using the elements to the right of 'mid'
        root.right = constructBST(nums, mid + 1, right);

        return root;
    }
}