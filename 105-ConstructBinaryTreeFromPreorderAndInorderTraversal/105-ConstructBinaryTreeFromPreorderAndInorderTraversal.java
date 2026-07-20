// Last updated: 20/07/2026, 10:12:44
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
    // Keeps track of our current root position in the preorder sequence
    private int preorderIndex;
    private Map<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        
        // Map values to their index for O(1) lookups during split points
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int left, int right) {
        // Base case: If there are no elements to construct the subtree
        if (left > right) {
            return null;
        }

        // Select the preorderIndex element as the root and increment it
        int rootValue = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Find the index of this root in the inorder array
        int inorderRootIndex = inorderIndexMap.get(rootValue);

        // Recursively build the left and right subtrees
        // Left subtree boundaries: elements from current 'left' up to rootIndex - 1
        root.left = arrayToTree(preorder, left, inorderRootIndex - 1);
        
        // Right subtree boundaries: elements from rootIndex + 1 up to current 'right'
        root.right = arrayToTree(preorder, inorderRootIndex + 1, right);

        return root;
    }
}