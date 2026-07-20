// Last updated: 20/07/2026, 09:08:54
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
20    // Keeps track of our current root position in the preorder sequence
21    private int preorderIndex;
22    private Map<Integer, Integer> inorderIndexMap;
23
24    public TreeNode buildTree(int[] preorder, int[] inorder) {
25        preorderIndex = 0;
26        inorderIndexMap = new HashMap<>();
27        
28        // Map values to their index for O(1) lookups during split points
29        for (int i = 0; i < inorder.length; i++) {
30            inorderIndexMap.put(inorder[i], i);
31        }
32
33        return arrayToTree(preorder, 0, inorder.length - 1);
34    }
35
36    private TreeNode arrayToTree(int[] preorder, int left, int right) {
37        // Base case: If there are no elements to construct the subtree
38        if (left > right) {
39            return null;
40        }
41
42        // Select the preorderIndex element as the root and increment it
43        int rootValue = preorder[preorderIndex++];
44        TreeNode root = new TreeNode(rootValue);
45
46        // Find the index of this root in the inorder array
47        int inorderRootIndex = inorderIndexMap.get(rootValue);
48
49        // Recursively build the left and right subtrees
50        // Left subtree boundaries: elements from current 'left' up to rootIndex - 1
51        root.left = arrayToTree(preorder, left, inorderRootIndex - 1);
52        
53        // Right subtree boundaries: elements from rootIndex + 1 up to current 'right'
54        root.right = arrayToTree(preorder, inorderRootIndex + 1, right);
55
56        return root;
57    }
58}