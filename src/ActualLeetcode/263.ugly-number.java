/*
 * @lc app=leetcode id=263 lang=java
 *
 * [263] Ugly Number
 */

// @lc code=start
class Solution {
    public boolean isUgly(int n) {
        /*
         -- An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
         -- Given an integer n, return true if n is an ugly number. Otherwise, return false.

         -- An incorrect approach would be to check is it is divisible by 2, 3 or 5
         -- But we need to keep dividing it until it is no longer divisible by 2, 3 or 5
         -- If the result is 1, then it is an ugly number
         -- If the result is greater than 1, then it is not an ugly number

         -- So how do we start off?

         let n == 30, then
         30 % 2 == 0, so n = 30 / 2 = 15
         15 % 2 != 0, so we move to next prime factor
         15 % 3 == 0, so n = 15 / 3 = 5
         5 % 3 != 0, so we move to next prime factor
         5 % 5 == 0, so n = 5 / 5 = 1
         Now n == 1, so it is an ugly number
         */

        if (n <= 0) {
            return false;
        }
        int[] primeFactors = {2, 3, 5};
        while (n > 1){
            if (n % 2 == 0) {
                n /= 2;
                continue;
            } else if (n % 3 == 0) {
                n /= 3;
                continue;
            } else if (n % 5 == 0) {
                n /= 5;
                continue;
            } else {
                break;
            }
        }
        return n == 1;
    }
}
// @lc code=end

