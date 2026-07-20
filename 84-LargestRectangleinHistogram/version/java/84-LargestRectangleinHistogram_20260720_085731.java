// Last updated: 20/07/2026, 08:57:31
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
12    public ListNode partition(ListNode head, int x) {
13        // Dummy heads to easily handle edge cases and maintain the starting points
14        ListNode lessHead = new ListNode(0);
15        ListNode greaterHead = new ListNode(0);
16        
17        // Pointers used to build the two lists
18        ListNode less = lessHead;
19        ListNode greater = greaterHead;
20        
21        // Traverse the original list
22        ListNode current = head;
23        while (current != null) {
24            if (current.val < x) {
25                less.next = current;
26                less = less.next;
27            } else {
28                greater.next = current;
29                greater = greater.next;
30            }
31            current = current.next;
32        }
33        
34        // Crucial step: cut off any trailing nodes to prevent cycles
35        greater.next = null;
36        
37        // Connect the 'less' list to the head of the 'greater' list
38        less.next = greaterHead.next;
39        
40        return lessHead.next;
41    }
42}