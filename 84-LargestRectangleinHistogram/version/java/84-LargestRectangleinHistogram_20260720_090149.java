// Last updated: 20/07/2026, 09:01:49
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
11class Solution {
12    public ListNode reverseBetween(ListNode head, int left, int right) {
13        if (head == null || left == right) {
14            return head;
15        }
16        
17        // A dummy node simplifies edge cases where the head itself needs to be reversed
18        ListNode dummy = new ListNode(0);
19        dummy.next = head;
20        
21        // Step 1: Advance `prev` pointer to the node right before the sublist starts
22        ListNode prev = dummy;
23        for (int i = 0; i < left - 1; i++) {
24            prev = prev.next;
25        }
26        
27        // Step 2: Set up pointers for the in-place rotation
28        ListNode start = prev.next; // The first node of the sublist to be reversed
29        ListNode then = start.next; // The node that will be moved to the front of the sublist
30        
31        // Step 3: Shift nodes between left and right positions
32        for (int i = 0; i < right - left; i++) {
33            start.next = then.next;
34            then.next = prev.next;
35            prev.next = then;
36            then = start.next;
37        }
38        
39        return dummy.next;
40    }
41}