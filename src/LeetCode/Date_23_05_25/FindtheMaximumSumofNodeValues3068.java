package LeetCode.Date_23_05_25;

public class FindtheMaximumSumofNodeValues3068 {
    public static void main(String[] args) {
       int[] nums = {1,2,1};
       int k = 3;
       int[][] edges = {{0,1},{0,2}};
       System.out.println(new FindtheMaximumSumofNodeValues3068().maximumValueSum(nums, k, edges));
    }
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0, cnt = 0, sacrifice = Integer.MAX_VALUE;
        for (int i : nums){
            if ((i ^ k) > i){
                sum += (i ^ k);
                sacrifice = Math.min(sacrifice, (long)(i ^ k) - i);
                cnt++;
            }
            else{
                sum += i;
                sacrifice = Math.min(sacrifice, (long)i - (i ^ k));
            }
        }
        if (cnt % 2 == 0) return sum;
        return sum - sacrifice;
    }
}

