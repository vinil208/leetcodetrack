// Last updated: 20/07/2026, 09:11:52
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
17    public boolean isBalanced(TreeNode root) {
18        // If checkHeight returns -1, it means the tree is unbalanced
19        return checkHeight(root) != -1;
20    }
21
22    private int checkHeight(TreeNode node) {
23        // Base case: An empty tree has a height of 0 and is balanced
24        if (node == null) {
25            return 0;
26        }
27
28        // Check if the left subtree is balanced
29        int leftHeight = checkHeight(node.left);
30        if (leftHeight == -1) {
31            return -1; // Propagate the unbalanced signal upward
32        }
33
34        // Check if the right subtree is balanced
35        int rightHeight = checkHeight(node.right);
36        if (rightHeight == -1) {
37            return -1; // Propagate the unbalanced signal upward
38        }
39
40        // If the current node violates the balance property, return -1
41        if (Math.abs(leftHeight - rightHeight) > 1) {
42            return -1;
43        }
44
45        // Otherwise, return the actual height of this subtree to the parent call
46        return Math.max(leftHeight, rightHeight) + 1;
47    }
48}