// Last updated: 20/07/2026, 09:11:27
1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11/**
12 * Definition for a binary tree node.
13 * public class TreeNode {
14 *     int val;
15 *     TreeNode left;
16 *     TreeNode right;
17 *     TreeNode() {}
18 *     TreeNode(int val) { this.val = val; }
19 *     TreeNode(int val, TreeNode left, TreeNode right) {
20 *         this.val = val;
21 *         this.left = left;
22 *         this.right = right;
23 *     }
24 * }
25 */
26class Solution {
27    public TreeNode sortedListToBST(ListNode head) {
28        // Base case: if the list segment is empty
29        if (head == null) {
30            return null;
31        }
32        // Base case: if there's only one node left, it becomes a leaf node
33        if (head.next == null) {
34            return new TreeNode(head.val);
35        }
36
37        // Find the middle element and disconnect the left half from it
38        ListNode mid = findMiddleAndDisconnect(head);
39
40        // The middle node becomes the root of the current subtree
41        TreeNode root = new TreeNode(mid.val);
42
43        // The 'head' now represents the start of the isolated left half list
44        root.left = sortedListToBST(head);
45        
46        // The right half list starts immediately after the middle node
47        root.right = sortedListToBST(mid.next);
48
49        return root;
50    }
51
52    private ListNode findMiddleAndDisconnect(ListNode head) {
53        ListNode prev = null;
54        ListNode slow = head;
55        ListNode fast = head;
56
57        // Move fast pointer by 2 steps and slow pointer by 1 step
58        while (fast != null && fast.next != null) {
59            prev = slow;
60            slow = slow.next;
61            fast = fast.next.next;
62        }
63
64        // Disconnect the left half of the list from the middle node
65        if (prev != null) {
66            prev.next = null;
67        }
68
69        return slow;
70    }
71}