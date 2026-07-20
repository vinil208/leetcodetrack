// Last updated: 20/07/2026, 08:59:24
1import java.util.ArrayList;
2import java.util.List;
3
4class Solution {
5    public List<Integer> grayCode(int n) {
6        List<Integer> result = new ArrayList<>();
7        int totalNumbers = 1 << n; // 2^n numbers
8        
9        for (int i = 0; i < totalNumbers; i++) {
10            // Apply the formula: i XOR (i shifted right by 1)
11            result.add(i ^ (i >> 1));
12        }
13        
14        return result;
15    }
16}