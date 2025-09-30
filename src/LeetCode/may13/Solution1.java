package LeetCode.may13;
import java.util.*;
import java.util.Scanner;

//https://leetcode.com/problems/total-characters-in-string-after-transformations-i/description/?envType=daily-question&envId=2025-05-13
public class Solution1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int t = in.nextInt();
        System.out.println(new Solution1().lengthAfterTransformations(s, t));
    }
    public int lengthAfterTransformations(String s, int t) {
        //leetcode hint = count frquencies of each char
        Hashtable<Character, Integer> haho = new Hashtable<>();
        for(char c : s.toCharArray()) haho.put(c, haho.getOrDefault(c, 0) + 1);
        return 0;
    }
}
