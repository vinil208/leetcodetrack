// Last updated: 20/07/2026, 09:05:45
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
17    public boolean isSameTree(TreeNode p, TreeNode q) {
18        // Base Case 1: Both nodes are null -> They are identical
19        if (p == null && q == null) {
20            return true;
21        }
22        
23        // Base Case 2: One node is null but the other isn't -> They are not identical
24        if (p == null || q == null) {
25            return false;
26        }
27        
28        // Base Case 3: The values don't match -> They are not identical
29        if (p.val != q.val) {
30            return false;
31        }
32        
33        // Recursively check if the left subtrees match AND the right subtrees match
34        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
35    }
36}