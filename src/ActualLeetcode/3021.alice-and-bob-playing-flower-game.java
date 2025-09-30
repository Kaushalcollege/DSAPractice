/*
 * @lc app=leetcode id=3021 lang=java
 *
 * [3021] Alice and Bob Playing Flower Game
 */

// @lc code=start
import java.util.*;
class Solution {
    public long flowerGame(int n, int m) {
        /*
         Problem description:
         -- Let Alice be a, and Bob be b.
         -- alice takes first turn. and from there we have the consecutive opposite turns.
         -- They both are between lanes.
         -- First Lane has 'x' flowers, and second lane has 'y' flowers.
         -- In each turn, the player can take 1 flower from any one lane.
         -- At the end of the turn, if there are no flowers left at all, the current player captures their opponent and wins the game.

         -- We will be given 2 integers n and m.
         -- The task is to compute the number of possible pairs (x, y) that satisfy the following conditions:
            -- Alice must win the game according to the described rules.
            -- The number of flowers x in the first lane must be in the range [1,n].
            -- The number of flowers y in the second lane must be in the range [1,m].

        -- Example 1:
            Input: n = 3, m = 2
            Output: 3
            Explanation: The possible pairs (x, y) where Alice wins are:

                l1: p1
            a                  b
                l2: q1 q2
                In this case, Alice starts from lane 1 and takes the only flower p1.
                Bob can take either q1 or q2.
                If Bob takes q1, Alice takes q2 and wins.
                If Bob takes q2, Alice takes q1 and wins.
                So, Alice wins in both scenarios.

                l1: p1 p2 p3
            a                  b
                l2: q1 q2
                In this case, Alice starts from lane 1 and takes flower p3.
                Bob can take either q1 or q2.
                If Bob takes q1, Alice takes p2.
                Bob takes q2, Alice takes p1 and wins.
                If Bob takes q2, Alice takes p2.
                Bob takes q1, Alice takes p1 and wins.
                So, Alice wins in both scenarios.

                If alice starts from lane 2, she can take either q1 or q2.
                Bob takes p1, Alice takes q2.
                Bob takes p2, Alice takes p3 and wins.
                So, Alice wins in both scenarios.
            
            The following pairs satisfy conditions described in the statement: (1,2), (3,2), (2,1).

            -- Example 2:
            Input: n = 1, m = 1
            Output: 0
            Explanation: The only possible pair is (1, 1).
            Alice takes the only flower in lane 1.
            Bob takes the only flower in lane 2 and wins.
            So, there are no pairs where Alice wins.


            -- We can safely say that Alice can win only when the total number of flowers is odd.
            -- If the total number of flowers is even, Bob can always mirror Alice's moves and win the game.
            -- Therefore, we need to count the number of pairs (x, y) such that x + y is odd.
            -- This can be achieved by counting the number of odd and even integers in the ranges [1, n] and [1, m].
            -- The number of odd integers in the range [1, n] is (n + 1) / 2.
            -- The number of even integers in the range [1, n] is n / 2.
            -- Similarly, the number of odd integers in the range [1, m] is (m + 1) / 2.
            -- The number of even integers in the range [1, m] is m / 2.
            -- The total number of pairs (x, y) such that x + y is odd can be calculated as:
                -- (number of odd integers in [1, n] * number of even integers in [1, m]) + (
                -- number of even integers in [1, n] * number of odd integers in [1, m])
            -- This gives us the final formula to compute the result.   
         */
        long oddN = (n + 1) / 2;
        long evenN = n / 2;
        long oddM = (m + 1) / 2;
        long evenM = m / 2;
        return oddN * evenM + evenN * oddM;
        
    }
}
// @lc code=end

