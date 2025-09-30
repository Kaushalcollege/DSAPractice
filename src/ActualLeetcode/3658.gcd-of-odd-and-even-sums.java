/*
 * @lc app=leetcode id=3658 lang=java
 *
 * [3658] GCD of Odd and Even Sums
 */

// @lc code=start
class Solution {
    public int gcdOfOddEvenSums(int n) {
        // int evenSum = 0, oddSum = 0;
        // int odd = 1, even = 2;
        // for (int i = 1; i <= n; i++) {
        //     evenSum += even;
        //     oddSum += odd;
        //     odd += 2;
        //     even += 2;
        // }
        // // System.out.println(evenSum + " " + oddSum);
        // return gcd(evenSum, oddSum);
        //OR
        
        return n;
    }
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
// @lc code=end

