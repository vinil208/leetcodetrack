// Last updated: 20/07/2026, 08:58:47
1class Solution {
2    public void merge(int[] nums1, int m, int[] nums2, int n) {
3        // Pointers for the ends of valid elements in nums1 and nums2
4        int p1 = m - 1;
5        int p2 = n - 1;
6        // Pointer for the very last index of nums1
7        int p = m + n - 1;
8        
9        // Move backwards, picking the larger element between nums1 and nums2
10        while (p1 >= 0 && p2 >= 0) {
11            if (nums1[p1] > nums2[p2]) {
12                nums1[p] = nums1[p1];
13                p1--;
14            } else {
15                nums1[p] = nums2[p2];
16                p2--;
17            }
18            p--;
19        }
20        
21        // If there are leftover elements in nums2, copy them over
22        // (Leftover elements in nums1 are already in their correct places)
23        while (p2 >= 0) {
24            nums1[p] = nums2[p2];
25            p2--;
26            p--;
27        }
28    }
29}