// Last updated: 09/07/2026, 10:14:13
class Solution {
    public int reverse(int x) {
        long rev = 0;
        while (x != 0) {
            rev = (rev * 10) + (x % 10);
            x /= 10;
        }
        // Check if the final result fits in a 32-bit integer
        if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) rev;
    }
}
