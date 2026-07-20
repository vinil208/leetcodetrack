// Last updated: 20/07/2026, 10:12:38
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        // Base case: if the list segment is empty
        if (head == null) {
            return null;
        }
        // Base case: if there's only one node left, it becomes a leaf node
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        // Find the middle element and disconnect the left half from it
        ListNode mid = findMiddleAndDisconnect(head);

        // The middle node becomes the root of the current subtree
        TreeNode root = new TreeNode(mid.val);

        // The 'head' now represents the start of the isolated left half list
        root.left = sortedListToBST(head);
        
        // The right half list starts immediately after the middle node
        root.right = sortedListToBST(mid.next);

        return root;
    }

    private ListNode findMiddleAndDisconnect(ListNode head) {
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        // Move fast pointer by 2 steps and slow pointer by 1 step
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Disconnect the left half of the list from the middle node
        if (prev != null) {
            prev.next = null;
        }

        return slow;
    }
}