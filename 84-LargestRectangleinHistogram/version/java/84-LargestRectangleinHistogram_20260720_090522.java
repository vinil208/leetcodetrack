// Last updated: 20/07/2026, 09:05:22
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
17    private TreeNode first = null;
18    private TreeNode second = null;
19    private TreeNode prev = null;
20
21    public void recoverTree(TreeNode root) {
22        // Step 1: Perform inorder traversal to find the two swapped nodes
23        traverse(root);
24        
25        // Step 2: Swap the values of the two mismatched nodes back
26        if (first != null && second != null) {
27            int temp = first.val;
28            first.val = second.val;
29            second.val = temp;
30        }
31    }
32
33    private void traverse(TreeNode root) {
34        if (root == null) {
35            return;
36        }
37
38        traverse(root.left);
39
40        // If a violation of ascending order is found
41        if (prev != null && root.val < prev.val) {
42            // The first anomaly is always the larger element (the previous node)
43            if (first == null) {
44                first = prev;
45            }
46            // The second anomaly is always the smaller element (the current node)
47            second = root;
48        }
49        
50        // Track the current node as the previous node for the next step
51        prev = root;
52
53        traverse(root.right);
54    }
55}