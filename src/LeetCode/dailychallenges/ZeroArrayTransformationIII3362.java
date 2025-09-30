package LeetCode.dailychallenges;
//22-05-2025
import java.util.*;

public class ZeroArrayTransformationIII3362 {
    public static void main(String[] args) {
        int[] nums = {0, 3};
        int[][] queries = {{0, 1}, {0, 0}, {0, 1}, {0, 1}, {0, 0}};
        System.out.println(new ZeroArrayTransformationIII3362().maxRemoval(nums, queries));
    }

    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> candidates = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        PriorityQueue<Integer> chosen = new PriorityQueue<>();
        int ans = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < queries.length && queries[j][0] == i) {
                candidates.add(queries[j][1]);
                j++;
            }
            nums[i] = nums[i] - chosen.size();
            while (nums[i] > 0 && !candidates.isEmpty() && candidates.peek() >= i) {
                ans++;
                chosen.add(candidates.poll());
                nums[i]--;
            }
            if (nums[i] > 0) return -1;
            while (!chosen.isEmpty() && chosen.peek() == i) chosen.poll();
        }
        return queries.length - ans;
    }
}
