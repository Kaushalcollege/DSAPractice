package LeetCode.dailychallenges;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ZeroArrayTransformation3355 {
    public static void main(String[] args) {
        int[] nums = {7};
        int[][] queries = {{0, 0}};
        System.out.println(new ZeroArrayTransformation3355().isZeroArray(nums, queries));
        //Because isZeroArray is not a static method, it cannot be called inside a static method without
        //object declaration.
    }
    public boolean isZeroArray(int[] nums, int[][] queries) {
        //using hashmap for O(1) lookup
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            map.put(i, nums[i]);
//        }
//        for(int[] arr : queries){
//            for (int i = arr[0]; i <= arr[1]; i++){
//                int val = map.get(i);
//                if (val == 0) continue;
//                val--;
//                map.put(i, val);
//            }
//        }
//        Set<Integer> set1 = new HashSet<>(map.values());
//        if (set1.size() == 1 && set1.contains(0)) return true;
//        return false;
        // the above code says the time limit exceeded.
        // because we are using hashmap for O(1) lookup.
        // we better use arrays.
//        for (int[] arr : queries){
//            for (int i = arr[0]; i <= arr[1]; i++){
//                int val = nums[i];
//                if (val == 0) continue;
//                val--;
//                nums[i] = val;
//            }
//        }
//        if (nums.length != 1){
//            boolean allEqual = Arrays.stream(nums).distinct().count() <= 1;
//            if (allEqual) return true;
//            return false;
//        }
//        return nums[0] == 0;
        // the above code says the time limit exceeded.
        // because we are using arrays.
        // we better use a new concept called difference arrays.
        int[] differencearr = new int[nums.length + 1];
        for (int[] q : queries){
            int l = q[0];
            int r = q[1];
            differencearr[l]--;
            if(r + 1 < differencearr.length){
                differencearr[r + 1]++;
            }
        }
        int dec = 0;
        for (int i = 0; i < nums.length; i++){
            dec += differencearr[i];
            nums[i] = Math.max(0, nums[i] + dec);
        }
        return nums.length != 1
                ? Arrays.stream(nums).distinct().count() <= 1
                : nums[0] == 0;
    }
}
