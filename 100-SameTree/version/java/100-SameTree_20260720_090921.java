// Last updated: 20/07/2026, 09:09:21
1import java.util.HashMap;
2import java.util.Map;
3
4/**
5 * Definition for a binary tree node.
6 * public class TreeNode {
7 *     int val;
8 *     TreeNode left;
9 *     TreeNode right;
10 *     TreeNode() {}
11 *     TreeNode(int val) { this.val = val; }
12 *     TreeNode(int val, TreeNode left, TreeNode right) {
13 *         this.val = val;
14 *         this.left = left;
15 *         this.right = right;
16 *     }
17 * }
18 */
19class Solution {
20    // Tracks our position in the postorder array, moving from right to left
21    private int postorderIndex;
22    private Map<Integer, Integer> inorderIndexMap;
23
24    public TreeNode buildTree(int[] inorder, int[] postorder) {
25        // Start from the last element of the postorder traversal
26        postorderIndex = postorder.length - 1;
27        inorderIndexMap = new HashMap<>();
28        
29        // Map values to their indices for O(1) lookups during split points
30        for (int i = 0; i < inorder.length; i++) {
31            inorderIndexMap.put(inorder[i], i);
32        }
33
34        return arrayToTree(postorder, 0, inorder.length - 1);
35    }
36
37    private TreeNode arrayToTree(int[] postorder, int left, int right) {
38        // Base case: if there are no elements to construct the subtree
39        if (left > right) {
40            return null;
41        }
42
43        // Select the postorderIndex element as the root and decrement the index pointer
44        int rootValue = postorder[postorderIndex--];
45        TreeNode root = new TreeNode(rootValue);
46
47        // Find where this root splits the inorder sequence
48        int inorderRootIndex = inorderIndexMap.get(rootValue);
49
50        // CRITICAL STEP: Build the RIGHT subtree first!
51        // Because we are reading postorder from right-to-left, the element immediately 
52        // preceding a root node in a postorder array is its right child.
53        root.right = arrayToTree(postorder, inorderRootIndex + 1, right);
54        
55        // Build the LEFT subtree next
56        root.left = arrayToTree(postorder, left, inorderRootIndex - 1);
57
58        return root;
59    }
60}