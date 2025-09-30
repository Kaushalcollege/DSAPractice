/*
 * @lc app=leetcode id=2749 lang=java
 *
 * [2749] Minimum Operations to Make the Integer Zero
 */

// @lc code=start
class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        /*
         -- Problem Statement:
            We are given two integers num1 and num2.
            In one operation, we can choose any integer i in the range [0, 60]
            and subtract (2^i + num2) from num1.

            We need to find the minimum number of operations required to make num1 equal to 0.
            If it's not possible, we return -1.

         -- Constraints:
            1 <= num1 <= 10^9
           -10^9 <= num2 <= 10^9

         -- Key Insight:
            After k operations:
                num1 = k * num2 + (2^i1 + 2^i2 + ... + 2^ik)

            Let:
                remain = num1 - k * num2

            Conditions:
              1) remain >= k   (since minimum sum of k powers of two is k, if all chosen powers are 2^0 = 1)
              2) popcount(remain) <= k
                 (because the binary representation of remain tells us how many powers of two are required,
                  and we can always split higher powers into smaller powers if needed)

         -- Approach:
            Iterate k from 1 to 60:
              - Calculate remain = num1 - k * num2
              - If remain >= k and popcount(remain) <= k, return k
            If no k satisfies the condition, return -1.
         */

        for (int k = 1; k <= 60; k++) {
            long remain = (long) num1 - (long) k * num2;  // use long to avoid overflow
            if (remain < k) {
                continue; // not enough to form k powers of two
            }
            if (Long.bitCount(remain) <= k) {
                return k; // found the minimum number of operations
            }
        }

        // If no valid k is found
        return -1;
    }
}
// @lc code=end
