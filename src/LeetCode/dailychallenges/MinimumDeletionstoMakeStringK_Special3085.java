package LeetCode.dailychallenges;

import java.util.Arrays;

public class MinimumDeletionstoMakeStringK_Special3085 {
    public static void main(String[] args) {
        String word = "dabdcbdcdcd";
        int k = 2;
        System.out.println(new MinimumDeletionstoMakeStringK_Special3085().minimumDeletions(word, k));
    }
    public int minimumDeletions(String word, int k) {
        int[] freqarr = new int[26];
        for (char c : word.toCharArray()){
            int n = (int)c;
            freqarr[n - 97]++;
        }
        Arrays.sort(freqarr);
        System.out.println(Arrays.toString(freqarr));
        return 0;
    }
}
