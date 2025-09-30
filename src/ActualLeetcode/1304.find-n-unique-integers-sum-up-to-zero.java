/*
 * @lc app=leetcode id=1304 lang=java
 *
 * [1304] Find N Unique Integers Sum up to Zero
 */

// @lc code=start
class Solution {
    public int[] sumZero(int n) {
        /*
        -- The idea here is to find an array of size 'n', which is same as the number 'n' given to us.
        -- a symmetric array is the option -- best option.
        -- if n is even, take n/2 pairs.
        -- if n is odd, take (n - 1)/2 pairs.
         */

        int[] res = new int[n];
        int idx = 0;

        for (int i = 1; i <= n / 2; i++){
            res[idx++] = -i;
            res[idx++] = i;
        }

        if (n % 2 != 0) res[idx] = 0;

        return res;
    }
}
// @lc code=end

