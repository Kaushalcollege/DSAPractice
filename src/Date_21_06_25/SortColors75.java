package Date_21_06_25;

import java.util.Arrays;

public class SortColors75 {
    public static void main(String[] args) {
        int[] nums = {2};
        sortColors(nums);
    }
    public static void sortColors(int[] nums) {
       int low = 0, mid = 0, high = nums.length - 1;
       while(mid <= high){
        //we have 3 cases:
        if (nums[mid] == 0){
            int temp = nums[mid];
            nums[mid] = nums[low];
            nums[low] = temp;
            mid++;
            low++;
        }
        else if (nums[mid] == 1) mid++;
        else {
            int temp = nums[mid];
            nums[mid] = nums[high];
            nums[high] = temp;
            high--;
        }
       }
       System.out.println(Arrays.toString(nums));
       return;
    }
}
