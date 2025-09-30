/*
 * @lc app=leetcode id=3659 lang=java
 *
 * [3659] Partition Array Into K-Distinct Groups
 */

// @lc code=start
class Solution {
    public boolean partitionArray(int[] nums, int k) {
        
        int n = nums.length;
        if(n % k != 0) return false;

        int max = 0;
        for(int x:nums)
            max = Math.max(max, x);
        
        int[] count = new int[max + 1];
        int limit = n / k;

        for(int x:nums){
            if(++count[x] > limit)
                return false;
        }
        
        return true;
    }
}
// @lc code=end

