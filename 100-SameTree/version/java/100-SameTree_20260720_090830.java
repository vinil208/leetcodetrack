// Last updated: 20/07/2026, 09:08:30
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16class Solution {
17    public int maxDepth(TreeNode root) {
18        // Base case: if the current node is null, the depth is 0
19        if (root == null) {
20            return 0;
21        }
22        
23        // Recursively find the height/depth of the left and right subtrees
24        int leftDepth = maxDepth(root.left);
25        int rightDepth = maxDepth(root.right);
26        
27        // The total depth is 1 (current root) plus the maximum depth between both branches
28        return Math.max(leftDepth, rightDepth) + 1;
29    }
30}