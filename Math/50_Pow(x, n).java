/*
Problem:
50. Pow(x, n).

Difficulty:
Medium

Topic:
Math 

Approach:
1)Initialize power = n (store in a long to avoid overflow) and ans = 1.
2)If power is negative:
    Replace x with 1 / x.
    Convert power to its positive value.
3)While power > 0:
    If power is odd ((power & 1) == 1), multiply ans by the current value of x.
    Square the base (x = x * x).
    Divide power by 2 using right shift (power >>= 1).
4)Repeat the above steps until power becomes 0.
5)Return ans, which is the value of xⁿ.

Time Complexity:
O(log n)

Space Complexity:
O(1)

LeetCode:
https://leetcode.com/problems/powx-n/
*/

class solution{
    public double myPow(int x, int n){
        long power = n;
        double ans = 1;
        if(power < 0){
            power = - power;
            x = 1/x;
        }

        while(power > 0){
            if((n & 1) == 1) ans *= x;

            x *= x;
            n >>= 1;
        }
        return ans;
    }
}