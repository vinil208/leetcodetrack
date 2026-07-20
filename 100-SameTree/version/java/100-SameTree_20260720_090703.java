// Last updated: 20/07/2026, 09:07:03
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
17    public boolean isSymmetric(TreeNode root) {
18        if (root == null) return true;
19        return isMirror(root.left, root.right);
20    }
21
22    private boolean isMirror(TreeNode t1, TreeNode t2) {
23        // Base Case 1: Both subtrees are empty
24        if (t1 == null && t2 == null) return true;
25        
26        // Base Case 2: Only one subtree is empty, or values don't match
27        if (t1 == null || t2 == null || t1.val != t2.val) return false;
28
29        // Recursive Step: Compare outer children and inner children crosswise
30        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
31    }
32}