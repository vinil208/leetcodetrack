// Last updated: 09/07/2026, 10:13:26
class Solution {
    public boolean checkGoodInteger(int n) {
        int digitsum=0;
        int sq=0;
        int temp = n;
        while (temp>0){
            int digit = temp %10;
            digitsum +=digit;
            sq+=(digit * digit);
            temp/=10;
        }return (sq-digitsum)>=50;
        
    }
}