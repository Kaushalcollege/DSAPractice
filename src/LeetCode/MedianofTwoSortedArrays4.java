package LeetCode;
import org.w3c.dom.ls.LSOutput;

import java.util.*;
public class MedianofTwoSortedArrays4 { // class name.
    public static void main(String[] args) { // main method
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        System.out.println(new Solution().findMedianSortedArrays(nums1, nums2));
    }
}
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Queue<Double> hihi1 = new LinkedList<>();
        PriorityQueue<Double> hihi = new PriorityQueue<>();
        for(int i : nums1) hihi.offer((double)i);
        for(int i : nums2) hihi.offer((double)i);
        while(!hihi.isEmpty()) hihi1.add(hihi.poll());
        List<Double> hihi2 = new ArrayList<>(hihi1);
        if (hihi2.size() % 2 != 0) return hihi2.get(hihi2.size() / 2);
        return (hihi2.get(hihi2.size() / 2) + hihi2.get(hihi2.size() / 2 - 1)) / 2;
    }
}