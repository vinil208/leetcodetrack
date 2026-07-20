// Last updated: 20/07/2026, 10:13:03
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
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        
        // A dummy node simplifies edge cases where the head itself needs to be reversed
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Step 1: Advance `prev` pointer to the node right before the sublist starts
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        
        // Step 2: Set up pointers for the in-place rotation
        ListNode start = prev.next; // The first node of the sublist to be reversed
        ListNode then = start.next; // The node that will be moved to the front of the sublist
        
        // Step 3: Shift nodes between left and right positions
        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }
        
        return dummy.next;
    }
}