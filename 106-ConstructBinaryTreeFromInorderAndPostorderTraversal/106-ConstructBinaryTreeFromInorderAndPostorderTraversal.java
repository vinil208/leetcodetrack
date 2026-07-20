// Last updated: 20/07/2026, 10:12:42
import java.util.HashMap;
import java.util.Map;

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
    // Tracks our position in the postorder array, moving from right to left
    private int postorderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // Start from the last element of the postorder traversal
        postorderIndex = postorder.length - 1;
        inorderIndexMap = new HashMap<>();
        
        // Map values to their indices for O(1) lookups during split points
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(postorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] postorder, int left, int right) {
        // Base case: if there are no elements to construct the subtree
        if (left > right) {
            return null;
        }

        // Select the postorderIndex element as the root and decrement the index pointer
        int rootValue = postorder[postorderIndex--];
        TreeNode root = new TreeNode(rootValue);

        // Find where this root splits the inorder sequence
        int inorderRootIndex = inorderIndexMap.get(rootValue);

        // CRITICAL STEP: Build the RIGHT subtree first!
        // Because we are reading postorder from right-to-left, the element immediately 
        // preceding a root node in a postorder array is its right child.
        root.right = arrayToTree(postorder, inorderRootIndex + 1, right);
        
        // Build the LEFT subtree next
        root.left = arrayToTree(postorder, left, inorderRootIndex - 1);

        return root;
    }
}